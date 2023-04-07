package com.dy.message.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author dingyu
 * @description 统一返回包装类
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo<T> {

    private Integer code;

    private String msg;

    private String uid;

    private T data;



}
