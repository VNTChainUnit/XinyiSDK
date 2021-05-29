import requests
import datetime
import json
class client:
    def __init__(self,appid,secret):
        self.appid=appid
        self.secret=secret
        self.login()

    def login(self):
        print("Auto Login....")
        restext=requests.post('https://xinyi.laoluoli.com:3000/api/auth/login',{"applicationid":self.appid,"secret":self.secret})
        # restext=requests.post('http://127.0.0.1:3001/api/auth/login',{"applicationid":self.appid,"secret":self.secret})
        ret=json.loads(restext.text)
        if ret['code']==0:
            print("login successfully!")
            self.session=ret['data']['session']
            self.expiretime=datetime.datetime.now()+datetime.timedelta(hours=2)
            assert self.session
        elif ret['code']==30001:
            raise Exception("Login faild ! Please check your appid and secret.")
        else:
            raise Exception("Unknown error when login.")

    def call(self):
        if datetime.datetime.now()>self.expiretime:
            print("Session expired,trying login again.")
            self.login()
        else:
            self.time=datetime.datetime.now()+datetime.timedelta(hours=2)
        return self.session