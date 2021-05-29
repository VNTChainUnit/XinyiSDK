package com.xinyi.degree.exception;

public class LoginException extends Exception{
    String message="Please check your appid and secret.";
    public LoginException(){
        super("Login Failed!");
        System.out.println(message);
    }
    public LoginException(String msg){
        super("Login Failed!");
        message+=msg;
        System.out.println(message);
    }
}