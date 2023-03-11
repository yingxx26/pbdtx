package com.pbteach.dtx.txmsgdemo.bank1.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.pbteach.dtx.txmsgdemo.bank1.dao.AccountInfoDao;
import com.pbteach.dtx.txmsgdemo.bank1.dao.TestShiWuDao;
import com.pbteach.dtx.txmsgdemo.bank1.model.AccountChangeEvent;
import com.pbteach.dtx.txmsgdemo.bank1.service.AccountInfoService;
import com.pbteach.dtx.txmsgdemo.bank1.service.TestShiWuService;
import com.pbteach.dtx.txmsgdemo.bank1.utils.EnDecryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
@Slf4j
public class TestShiWuServiceImpl implements TestShiWuService {

    @Autowired
    TestShiWuDao testShiWuDao;


    //更新账户，扣减金额
    @Override
    @Transactional
    public void doUpdateShiWu() {
        testShiWuDao.updateTestShiWu(1, 1D);
    }
}
