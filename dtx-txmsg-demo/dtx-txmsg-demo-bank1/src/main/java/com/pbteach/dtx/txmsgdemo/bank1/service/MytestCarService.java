package com.pbteach.dtx.txmsgdemo.bank1.service;

import com.pbteach.dtx.txmsgdemo.bank1.model.AccountChangeEvent;
import com.pbteach.dtx.txmsgdemo.bank1.model.MytestCarEvent;

/**
 * Created by Administrator.
 */
public interface MytestCarService {

    //向mq发送转账消息
    public void sendMyCar(MytestCarEvent mytestCarEvent);

    //更新账户，扣减金额
    public void doUpdateAccountBalance(AccountChangeEvent accountChangeEvent);

}
