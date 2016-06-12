import tweepy
import config
from alchemyapi import AlchemyAPI

class twitter:
    twitterconfig = config.read(section='twitter')
    auth = tweepy.OAuthHandler(twitterconfig['oauth1'],twitterconfig['oauth2'])
    auth.set_access_token(twitterconfig['token1'],twitterconfig['token2'])
    api = tweepy.API(auth)
    alchemyapi = AlchemyAPI()
    
    def __init__(self):
        None
    
    def get_userdetails(self, userid):
        user = self.api.search_users(userid)[0]
        userdetails = {}
        userdetails['userid'] = userid
        userdetails['verified'] = user.verified
        userdetails['created_at'] = user.created_at
        userdetails['timezone'] = user.time_zone
        userdetails['statuses_count'] = user.statuses_count
        userdetails['lang'] = user.lang
        userdetails['friends_count'] = user.friends_count
        userdetails['name'] = user.name
        userdetails['screen_name'] = user.screen_name
        userdetails['location'] = user.location
        return userdetails
    
    def get_person_tagged(self, userid):
        tweets_summary = {}
        tweets = self.api.search_users(userid)[0].timeline()
        total_score = 0
        for tweet in tweets:
            response = self.alchemyapi.sentiment("text",str(tweet.text)).get("docSentiment")
            score = 0
            if bool(response) and (response.get("type") in ['positive','neutral']):
                score= 1*float(self.twitterconfig['sentiment_score'])
            else:
                score= -1*float(self.twitterconfig['sentiment_score'])
            total_score+= score
            for user_mentioned in tweet.entities['user_mentions']:
                if bool(tweets_summary.get(userid+"-"+user_mentioned['screen_name'])):
                    tweets_summary[userid+"-"+user_mentioned['screen_name']]+= score
                else:
                    tweets_summary[userid+"-"+user_mentioned['screen_name']] = score
        for t in tweets_summary:
            tweets_summary[t] = tweets_summary[t]/total_score
        return tweets_summary