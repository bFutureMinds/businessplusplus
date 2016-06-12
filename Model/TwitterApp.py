import flask
from flask import Flask
from flask import request
from twitter import twitter
app = Flask(__name__)
import networkx as nx
import config
import pickle
from nltk.stem.snowball import PorterStemmer
from nltk.corpus import stopwords
import nltk
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn import svm
import numpy as np
from twitter import twitter
import sys
from fb import fb
twitterapi = twitter()
mongoconfig = config.read(section='mongodb')
from pymongo import MongoClient
mongoclient = MongoClient(mongoconfig['host'])
db = mongoclient[mongoconfig['database']]
from alchemyapi import AlchemyAPI
alchemyapi = AlchemyAPI()

stemmer = PorterStemmer()
stopwords = stopwords.words("english")
twitterapi = twitter()

#@app.route('/details',methods=['GET'])
#def getuser_details():
#    return flask.jsonify(**twitterapi.get_userdetails(request.args.get('user')))
#    
#@app.route('/followers',methods=['GET'])
#def getfollower_details():
#    return flask.jsonify(**twitterapi.get_person_tagged(request.args.get('user')))

def apply_stop_stem_case(message):
            message_tokens = nltk.word_tokenize(message)
            filtered_msg_tokens = []
            for token in message_tokens:
                if token not in stopwords and type(token) != int:
                    filtered_msg_tokens.append(token)
            stems = [stemmer.stem(token) for token in filtered_msg_tokens]
            return stems    
    
    
@app.route('/compute',methods=['GET'])
def getrating():
    return_value = {}

    #module-1

    
            
    f = open('stage1tfidf.pickle','rb')
    tfidf = pickle.load(f)
    f.close()

    f = open('stage1Classifier.pickle','rb')
    clf = pickle.load(f)
    f.close()

    twitterUsers = db['twitterusers']
    phone_no = twitterUsers.find_one({'screen_name':request.args.get('user1')})['phone']
    phonemessages = db['phonemessages']
    message = list(phonemessages.find({'$or':[{'from':phone_no},{'to':phone_no}]}))
    msgs = []
    for msg in message:
        msgs+= [msg['text']]

    output = clf.predict(tfidf.transform(msgs)).tolist()
    ideal_ratio = float(config.read(section='stage1')['ideal_dbt_crdt_ratio'])
    actual_ratio = output.count('financial positive')/(output.count('financial negative')+1)

    stage1_score = actual_ratio%ideal_ratio/ideal_ratio
    return_value['sms'] = stage1_score
    #print(stage1_score)

    #module -1 complete


    #module-2 starts
    debt_rcvry_numbers = [int(x) for x in config.read(section='debt_rcvry_numbers')['numbers'].split(',')]
    call_logs = db['call_logs']
    phone = list(call_logs.find({'$or':[{'from':phone_no},{'to':phone_no}]}))

    stage2_score = 0
    count=0
    for log in phone:
        if (int(log['to']) in debt_rcvry_numbers) or (int(log['from']) in debt_rcvry_numbers):
            count+= 1
    max_allwd_calls = int(config.read(section='stage2')['max_dbt_rcvry_nos_allwd'])
    if count > max_allwd_calls:
        stage2_score = 1- (count-max_allwd_calls)/max_allwd_calls

    #print(stage2_score)
    return_value['call_logs'] = stage2_score

    #module-2 complete

    #module-3 starts
    output = twitterapi.get_person_tagged(request.args.get('user1'))
    stage3_score = 0
    for line in output:
        if request.args.get('user2') in line:
            stage3_score = output[line]

    return_value['twitter'] = stage3_score

    #module-3 complete
    
    #module-4 starts
    facebook = fb(config.read(section='fb')['access_token'])
    posts = facebook.get_object(['posts'])
    stage4_score = 0
    if bool(posts):
        posts = posts.get('posts')
    if bool(posts):
        posts = posts.get('data')
    total_score = 0
    if bool(posts):
        for post in posts:
            score = 0
            response = alchemyapi.sentiment("text",post.get('story')).get("docSentiment")
            if bool(response) and (response.get("type") in ['positive','neutral']):
                score= 1*float(config.read(section='fb')['sentiment_score'])
            else:
                score= -1*float(config.read(section='fb')['sentiment_score'])
            if bool(post.get('story')) and twitterUsers.find_one({'screen_name':request.args.get('user2')})['name'] in post.get('story'):
                total_score+= score
        stage4_score = total_score/len(posts)
        return_value['fb'] = stage4_score
    
    
    #module-4 complete

    final_score = (stage1_score+stage2_score+stage3_score+stage4_score)/4
    return_value['edge_weight'] = final_score
    
    #pagerank starts
    netx = db['networkx']
    netx.update({'from':request.args.get('user1'),'to':request.args.get('user2')},{'$set':{'weight':final_score}},True,False)
    G=nx.DiGraph()
    for element in list(netx.find()):
        G.add_edge(element['from'],element['to'],weight=float(element['weight'])) 

    socialscore = db['socialscore']
    pagranks = nx.pagerank(G)
    for rank in pagranks:
        socialscore.update({'name':rank},{'$set':{'score':pagranks[rank]*1000}},True,False)
        if(rank in [request.args.get('user1'),request.args.get('user2')]):
            return_value[rank] = pagranks[rank]*1000
    return flask.jsonify(**return_value)


if __name__ == '__main__':
    app.run(debug=True)