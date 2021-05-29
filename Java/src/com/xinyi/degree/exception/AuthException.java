package com.xinyi.degree.exception;

public class AuthException extends Exception{
    String message="Session expired!Please try to login again.";
    public AuthException(){
        super("Auth Check Failed!");
        System.out.println(message);
    }
    public AuthException(String msg){
        super("Auth Check Failed!");
        message+=msg;
        System.out.println(message);
    }
}
