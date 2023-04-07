package com.dy.message.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.time.LocalDateTime;

/**
 * @author dingyu
 * @description 在接口模块-策略模块-短信网关模块传递的校验和封装的POJO对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardTransferDto {

    /**
     * 发送短信的唯一标识 雪花算法生成
     */
    private Long sequenceId;

    /**
     * 客户端ID
     */
    private Long clintId;

    /**
     * IP
     */
    private String ip;

    /**
     * 客户系统的业务ID 返回给客户
     */
    private String uid;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 签名
     */
    private String sign;

    /**
     * 短信文本
     */
    private String text;

    /**
     * 发送时间
     */
    private LocalDateTime sendTime;

    /**
     * 发送短信金额
     */
    private Long fee;

    /**
     * 运营商ID
     */
    private Integer operatorId;

    /**
     * 目标手机号的归属地区号  0451  0455
     */
    private Integer areaCode;

    /**
     * 目标手机的归属地 哈尔滨 长春
     */
    private String area;

    /**
     * 通道下发的源号码 10693498xxx
     */
    private String srcNumber;

    /**
     * 通道的ID信息
     */
    private Long channelId;
    /**
     * 短信发送状态 0-等待中 1-成功 2-失败
     */
    private Integer reportState;


}
