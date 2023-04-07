package com.dy.message.filter.impl;

import com.dy.message.filter.CheckFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author dingyu
 * @descripton 模板校验
 */

@Component("template")
@Slf4j
public class TemplateCheckFilter implements CheckFilter {
    @Override
    public void check(Object object) {
        log.info("【message-api】【接口校验】 模板 校验中");
    }
}
