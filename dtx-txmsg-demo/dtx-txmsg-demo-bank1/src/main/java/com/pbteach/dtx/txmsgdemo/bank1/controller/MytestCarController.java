package com.pbteach.dtx.txmsgdemo.bank1.controller;

import com.pbteach.dtx.txmsgdemo.bank1.model.AccountChangeEvent;
import com.pbteach.dtx.txmsgdemo.bank1.model.MytestCarEvent;
import com.pbteach.dtx.txmsgdemo.bank1.service.AccountInfoService;
import com.pbteach.dtx.txmsgdemo.bank1.service.MytestCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
@Slf4j
public class MytestCarController {

    @Autowired
    private MytestCarService mytestCarService;

    @GetMapping(value = "/car")
    public String transfer(@RequestParam("carNum") String carNum, @RequestParam("machine_code") String machineCode) {
        //查询订单
        //计算费用
        //保存账号流水 MytestAccountFlow
        MytestCarEvent mytestCarEvent = new MytestCarEvent(carNum, machineCode);
        //发送消息
        mytestCarService.sendMyCar(mytestCarEvent);
        return "转账成功";
    }
}
