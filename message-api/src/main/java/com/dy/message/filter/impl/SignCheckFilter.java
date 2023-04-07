package com.dy.message.filter.impl;

import com.dy.message.filter.CheckFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author dingyu
 * @descripton 签名校验
 */

@Component("sign")
@Slf4j
public class SignCheckFilter implements CheckFilter {
    @Override
    public void check(Object object) {
        log.info("【message-api】【接口校验】 签名 校验中");

    }
}
