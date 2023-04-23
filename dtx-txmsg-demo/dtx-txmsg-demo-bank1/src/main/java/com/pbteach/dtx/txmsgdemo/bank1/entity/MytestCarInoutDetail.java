package com.pbteach.dtx.txmsgdemo.bank1.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MytestCarInoutDetail implements Serializable {
	//详情ID
	private String detail_id;
	//进出ID
	private String inout_id;
	//业务Id
	private String b_id;
	//小区ID
	private String community_id;
	//设备ID
	private String machine_id;
	//设备编码
	private String machine_code;
	//3306 进场 3307 出场
	private String car_inout;
	//车牌号
	private String car_num;
	//创建时间
	private Date create_time;
	//数据状态，详细参考c_status表，S 保存，0, 在用 1失效
	private String status_cd;
}
