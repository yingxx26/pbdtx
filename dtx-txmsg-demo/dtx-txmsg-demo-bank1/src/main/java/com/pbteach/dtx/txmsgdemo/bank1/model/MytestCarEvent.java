package com.pbteach.dtx.txmsgdemo.bank1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MytestCarEvent implements Serializable {
    /**
     * 账号
     */
    private String carNum;

    /**
     * 事务号
     */
    private String machineCode;

}
