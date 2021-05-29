#step:
#1.edit config.py to set your appid and secret
#2.add following code in your application
import DegreeCheck as DC
#Application will auto login when import ,so you should set your config first.
#you can check certificate by following two ways.
certificate_number="zsbh031"
name="xm"
school="测试大学"
degreetype="学士"
graduationdate="2021-04"
major="major"

if __name__ == '__main__':
    #Way1
    certificate=DC.Certificate(certificate_number,name,school,degreetype,graduationdate,major)
    if DC.checkCertificate(certificate):
        pass
    #Way2
    if(DC.check(certificate_number,name,school,degreetype,graduationdate,major)):
        print("yes")
