package com.xinyi.degree;

public class TestDemo {
    public static void main(String[] args) throws Exception {
        String yourappid="";
        String yoursecret="";
        Certificate certificate=new Certificate("zsbh031","xm","测试大学","学士","2021-04","major");
        DegreeCheck dc=DegreeCheck.openClient(yourappid,yoursecret);
        System.out.println(dc.check(certificate));
    }
}
