package com.pbteach.dtx.txmsgdemo.bank1.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MytestCarInout implements Serializable {
	//进出ID
	private String inout_id;
	//业务Id
	private String b_id;
	//小区ID
	private String community_id;
	//车牌号
	private String car_num;
	//状态，100300 进场状态 100400 支付完成 100500 离场状态 100600 支付超时重新支付
	private String state;
	//进场时间
	private Date in_time;
	//离场时间
	private Date out_time;
	//创建时间
	private Date create_time;
	private String status_cd;
}
