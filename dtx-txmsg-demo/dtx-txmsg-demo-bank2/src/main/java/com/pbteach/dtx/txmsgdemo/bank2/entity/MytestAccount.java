package com.pbteach.dtx.txmsgdemo.bank2.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class MytestAccount implements Serializable {
    //账户ID
    private String acct_id;
    //账户名称
    private String acct_name;
    // 账户类型，2003 现金账户 2004 积分账户 2005 优惠券账户
    private String acct_type;
    //金额
    private BigDecimal amount;
    //对象类型，6006 个人 7007 商户
    private String obj_type;
    //对象ID
    private String obj_id;
    //业务Id
    private String b_id;
    //创建时间
    private Date create_time;
    //数据状态，详细参考c_status表，S 保存，0, 在用 1失效
    private String status_cd;
}
