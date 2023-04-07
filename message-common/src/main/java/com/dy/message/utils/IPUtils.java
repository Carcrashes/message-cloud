package com.dy.message.utils;



import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * IP工具类
 */
public class IPUtils {

    private final static String UNKNOWN="unknown";

    /**
     * 如果是当前请求头获取IP地址，需要截取到第一个','未知
     */
    private final static String X_FORWARDED_FOR = "x-forwarded-for";

    /**
     * 固定配置获取IP方式
     * @param request
     * @return
     */
    public String getRealIp(HttpServletRequest request){
        //1.基于x-forward-for 请求头获取IP地址
        String ips = request.getHeader(X_FORWARDED_FOR);
        if (!StringUtils.isEmpty(ips) || !UNKNOWN.equalsIgnoreCase(ips)){
            if (ips.contains(",")){
                return ips.substring(0,ips.indexOf(","));
            }else{
                return ips;
            }
        }
        //2.基于请求头获取IP地址，基于请求头获取IP地址时候，除了null还可能拿到unknow
        String ip=request.getHeader("x-real-ip");
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)){
            //此时x-real-ip 没有拿到ip地址，考虑其他代理服务器
            //3.APACHE SERVER 请求头中携带真实IP名称是proxy-client-ip
            ip=request.getHeader("proxy-client-ip");
        }

        //4.proxy-client-ip 未获取到，考虑是weblogic，请求头信息中是wl-proxy-client-ip
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)){
            ip=request.getHeader("wl-proxy-client-ip");
        }

        //5.weblogic 未获取到ip，考虑其他服务器获取ip，请求头信息为http-client-ip
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)){
            ip=request.getHeader("http-client-ip");
        }

        //6.上述服务器获取不到IP，则采用传统方式获取
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)){
            ip=request.getRemoteAddr();
        }
        return ip;
    }


    /**
     * 支持动态配置获取IP
     * @param request 请求信息
     * @param headers 请求头获取客户端IP的信息x-forwarded-for,x-real-ip,proxy-client-ip,wl-proxy-client-ip,http-client-ip,使用，分割
     * @return
     */
    public static String getRealIP(HttpServletRequest request,String headers){
        String ip;
        for (String header: headers.split(",")){
            if (StringUtils.isNoneEmpty(header)){
                ip=request.getHeader(header);
                if (StringUtils.isNotEmpty(ip) && !UNKNOWN.equalsIgnoreCase(ip)){
                    // 判断请求头是否是x-forwarded-for
                    if (X_FORWARDED_FOR.equalsIgnoreCase(header) && ip.indexOf(",") > 0) {
                        ip = ip.substring(0,ip.indexOf(","));
                    }
                    // 返回IP地址
                    return ip;
                }
            }
        }
        //上述获取不到ip，则采用传统方式获取一个ip
        return request.getRemoteAddr();
    }
}
