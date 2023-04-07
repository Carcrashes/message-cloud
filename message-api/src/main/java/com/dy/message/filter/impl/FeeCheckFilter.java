package com.dy.message.filter.impl;

import com.dy.message.filter.CheckFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author dingyu
 * @descripton 金额校验
 */

@Component("fee")
@Slf4j
public class FeeCheckFilter implements CheckFilter {
    @Override
    public void check(Object object) {
        log.info("【message-api】【接口校验】 余额 校验中");
    }
}
