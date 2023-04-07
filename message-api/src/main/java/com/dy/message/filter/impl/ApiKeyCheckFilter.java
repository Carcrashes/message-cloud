package com.dy.message.filter.impl;

import com.dy.message.filter.CheckFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author dingyu
 * @descripton apikey校验
 */

@Component("apikey")
@Slf4j
public class ApiKeyCheckFilter implements CheckFilter {
    @Override
    public void check(Object object) {
        log.info("【message-api】【接口校验】 APIKEY 校验中");
    }
}
