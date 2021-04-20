package com.pfs.erp.customeException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {

    public ValidationException(String message){

        super(message);

    }

}
