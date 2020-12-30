package com.br.sysve.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class ResourceNeedBeUniqueException extends Exception{

    private static final long serialVersionUID = 1L;

    public ResourceNeedBeUniqueException(String message){
        super(message);
    }
}
