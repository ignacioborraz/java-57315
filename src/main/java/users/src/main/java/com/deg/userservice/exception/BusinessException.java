package com.deg.userservice.exception;


import lombok.Getter;
import lombok.Setter;

public class BusinessException extends Exception {

    @Getter @Setter
    private String field;

    public BusinessException(String msg){
        super(msg);
    }

    public BusinessException(String msg, String field){
        super(msg);
        this.field = field;
    }
}
