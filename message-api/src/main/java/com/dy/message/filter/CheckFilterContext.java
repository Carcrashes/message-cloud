package com.dy.message.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author dingyu
 * @decription 校验策略模式父接口
 */

@Component
@Slf4j
@RefreshScope //动态刷新
public class CheckFilterContext {

    //CheckFilter 校验链 spring ioc会把对象全部放到map集合中。基于spring4.x
    @Autowired
    private Map<String,CheckFilter> checkFilterMap;

    //基于nacos动态配置的执行顺序和需要校验的对象
    @Value("${filters:apikey,ip,mobile,sign,template,fee}")
    private String filters;

    public void check(Object obj){
        //1.将获取到filter进行切分
        String[] filterArray = filters.split(",");
        //2.便利数组进行校验
        for(String filter:filterArray){
            CheckFilter checkFilter = checkFilterMap.get(filter);
            checkFilter.check(obj);
        }
    }
}
