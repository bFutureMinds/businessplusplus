import requests
import json
class fb:
	access_token = ''
	
	def __init__(self, access_token):
		self.access_token = access_token
	
	def get_object(self, fields):
		url = 'https://graph.facebook.com/v2.6/me?fields='
		url+= ','.join(fields)
		url+= '&access_token='+self.access_token
		response = requests.get(url)
		if response.ok:
			return json.loads(response.text)
		else:
			return None
		