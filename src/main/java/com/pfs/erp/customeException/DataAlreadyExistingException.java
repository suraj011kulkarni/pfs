package com.pfs.erp.customeException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class DataAlreadyExistingException extends RuntimeException{

    public DataAlreadyExistingException(String message){
        super(message);
    }
}
