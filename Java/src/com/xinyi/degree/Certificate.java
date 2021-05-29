package com.xinyi.degree;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class Certificate {
    private String certificate_number;
    private String name;
    private String school;
    private String degreetype;
    private String graduationdate;
    private String major;

    public Certificate(String certificate_number, String name, String school, String degreetype, String graduationdate, String major) {
        this.certificate_number = certificate_number;
        this.name = name;
        this.school = school;
        this.degreetype = degreetype;
        this.graduationdate = graduationdate;
        this.major = major;
    }

    public String getCertificate_number() {
        return certificate_number;
    }

    public void setCertificate_number(String certificate_number) {
        this.certificate_number = certificate_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDegreetype() {
        return degreetype;
    }

    public void setDegreetype(String degreetype) {
        this.degreetype = degreetype;
    }

    public String getGraduationdate() {
        return graduationdate;
    }

    public void setGraduationdate(String graduationdate) {
        this.graduationdate = graduationdate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "certificate_number='" + certificate_number + '\'' +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", degreetype='" + degreetype + '\'' +
                ", graduationdate='" + graduationdate + '\'' +
                ", major='" + major + '\'' +
                '}';
    }

    public Map<String,Object> toMap(){
        Map<String,Object>map=new HashMap<>();
        map.put("certificate_number",this.certificate_number);
        map.put("name",this.name);
        map.put("school",this.school);
        map.put("degreetype",this.degreetype);
        map.put("graduationdate",this.graduationdate);
        map.put("major",this.major);
        return map;
    }
}
