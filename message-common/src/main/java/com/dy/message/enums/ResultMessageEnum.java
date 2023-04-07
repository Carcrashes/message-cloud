package com.dy.message.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * @author dingyu
 * @description 统一返回结果枚举
 */

@Getter
@NoArgsConstructor
public enum ResultMessageEnum {

    SUCCESS(0,"success"), //成功
    SYSTEM_ERROR(-1,"system error"),

    //============================api 校验异常 ===========================
    CHECK_APIKEY_ERROR(-2,"非法的apikey"),
    CHECK_IP_ERROR(-3,"请求的ip不在白名单内"),
    CHECK_SIGN_ERROR(-4,"无可用签名"),
    CHECK_TEMPLATE_ERROR(-5,"无可用模板"),
    CHECK_MOBILE_ERROR(-6,"手机号格式不正确"),
    CHECK_FEE_AVAILABLE(-7,"客户余额不足"),
    PARAMETER_ERROR(-8,"参数不合法"),
    //============================api 校验异常 =============================
    ;
    ;
    private Integer code;

    private String msg;

     ResultMessageEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
