import requests
import json

from . import config as __config,client as __client,model as __model

__Client=__client.client(__config.appid,__config.secret)

Certificate=__model.Certificate

def checkCertificate(certificate:Certificate):
    data = certificate.__dict__
    data['session'] = __Client.call()
    restext = requests.post('https://xinyi.laoluoli.com:3000/api/auth/check', data)
    ret = json.loads(restext.text)
    if ret['code'] == 0:
        if ret['data']['result'] == 1:
            return True
        else:
            return False
    elif ret['code'] == 40001:
        raise Exception("Auth check failed! Please check your login status.")
    elif ret['code'] == 50001:
        raise Exception("No remaining times,please buy more times on our website.")
    else:
        raise Exception("Unknown error when check.")

def check(certificate_number,name,school,degreetype,graduationdate,major):
    certificate=__model.Certificate(certificate_number,name,school,degreetype,graduationdate,major)
    return checkCertificate(certificate)