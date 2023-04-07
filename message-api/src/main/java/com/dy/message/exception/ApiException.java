package com.dy.message.exception;

import com.dy.message.enums.ResultMessageEnum;

public class ApiException extends RuntimeException{

    private Integer code;
    public ApiException(String message,Integer code){
        super(message);
        this.code=code;
    }

    public ApiException(ResultMessageEnum messageEnum){
        super(messageEnum.getMsg());
        this.code=messageEnum.getCode();
    }
}
