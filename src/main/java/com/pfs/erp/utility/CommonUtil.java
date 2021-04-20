package com.pfs.erp.utility;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class CommonUtil {

    public static String getErrorMessage(List<FieldError> fieldErrors){

        List<String> errorList = new ArrayList<>();

        for (FieldError error : fieldErrors){
            errorList.add(error.getDefaultMessage());
        }

        return String.join(",",errorList);

    }
}
