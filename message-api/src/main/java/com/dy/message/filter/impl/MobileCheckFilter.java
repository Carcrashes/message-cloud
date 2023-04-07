package com.dy.message.filter.impl;

import com.dy.message.filter.CheckFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author dingyu
 * @descripton 手机号码校验
 */

@Component("mobile")
@Slf4j
public class MobileCheckFilter implements CheckFilter {
    @Override
    public void check(Object object) {
        log.info("【message-api】【接口校验】 手机号码 校验中");

    }
}
