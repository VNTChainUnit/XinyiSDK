package com.xinyi.degree;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xinyi.degree.exception.AuthException;
import com.xinyi.degree.exception.CallException;

import java.util.Map;

public class DegreeCheck {
    private Client client;
    private DegreeCheck(){

    }
    public static DegreeCheck openClient(String appid,String secret) throws Exception {
        DegreeCheck degreeCheck=new DegreeCheck();
        degreeCheck.client=new Client(appid,secret);
        return degreeCheck;
    }
    public boolean check(Certificate certificate) throws Exception {
        String url="https://xinyi.laoluoli.com:3000/api/auth/check";
        Map<String,Object> param=certificate.toMap();
        param.put("session",this.client.call());
        String res=Http.doPost(url,param);
        RetMap retMap= JSON.parseObject(res,RetMap.class);
        if(retMap.getCode()==40001){
            throw new AuthException();
        }
        else if(retMap.getCode()==50001){
            throw new CallException("No remaining times,please buy more times on our website.");
        }
        else if(retMap.getCode()==0){
            String data=retMap.getData();
            JSONObject jb=JSON.parseObject(data);
            int result=jb.getInteger("result");
            return result == 1;
        }
        else{
            throw new CallException("Unknown error when call");
        }
    }
}
