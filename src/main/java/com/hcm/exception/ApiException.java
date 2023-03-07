package com.hcm.exception;

public class ApiException extends Exception{

    public ApiException(String errorMessage){
        super(errorMessage);
    }
}
