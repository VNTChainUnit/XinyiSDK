package com.xinyi.degree.exception;

public class CallException extends Exception{
    String message="Error when call check api.";

    public CallException(){
        super();
        System.out.println(message);
    }

    public CallException(String msg){
        super();
        System.out.println(message+msg);
    }
}
