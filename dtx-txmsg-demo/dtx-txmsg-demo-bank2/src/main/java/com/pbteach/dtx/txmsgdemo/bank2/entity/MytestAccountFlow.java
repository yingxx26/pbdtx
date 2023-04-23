package com.pbteach.dtx.txmsgdemo.bank2.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class MytestAccountFlow implements Serializable {
    //明细ID
    private String detail_id;
    //账户ID
    private String acct_id;
    //类型，1001 转入 2002 转出
    private String detail_type;
    //关联账户
    private String rel_acct_id;
    //金额
    private BigDecimal amount;
    //对象类型，6006 个人 7007 商户
    private String obj_type;
    //对象ID
    private String obj_id;
    //交易单号
    private String order_id;
    //业务Id
    private String b_id;

    private String remark;
    //创建时间
    private Date create_time;
    //数据状态，详细参考c_status表，S 保存，0, 在用 1失效
    private String status_cd;
}
