package com.xinyi.degree;

import com.alibaba.fastjson.JSONObject;
import com.xinyi.degree.exception.LoginException;
import jdk.nashorn.internal.parser.JSONParser;
import com.alibaba.fastjson.JSON;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Client {
    private String appid;
    private String secret;
    private Date expiretime;
    private String session;
    private Client(){}
    public Client(String appid, String secret) throws Exception {
        this.appid=appid;
        this.secret=secret;
        this.login();
    }

    public String call() throws Exception {
        if(new Date().getTime()>this.expiretime.getTime()){
            System.out.println("Session expired.Trying reconnect.....");
            login();
        }
        else{
            this.expiretime=new Date(new Date().getTime()+2*3600);
        }
        return this.session;
    }

    private void login() throws Exception {
        Map<String,Object> mp=new HashMap<>();
        mp.put("applicationid",this.appid);
        mp.put("secret",this.secret);
        String res=Http.doPost("https://xinyi.laoluoli.com:3000/api/auth/login",mp);
        RetMap retMap=JSON.parseObject(res,RetMap.class);
        if(retMap.getCode()==0){
            String data=retMap.getData();
            try{
                JSONObject jb=JSON.parseObject(data);
                this.session=jb.getString("session");
            }
            catch (Exception e){
                throw new LoginException("Return session missing when login");
            }
            this.expiretime=new Date();
        }
        else if(retMap.getCode()==30001){
            throw new LoginException();
        }
        else{
            throw new LoginException("Unknown error when login!");
        }
    }
}
