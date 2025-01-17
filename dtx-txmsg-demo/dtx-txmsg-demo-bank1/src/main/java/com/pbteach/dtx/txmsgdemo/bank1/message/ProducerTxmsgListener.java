package com.pbteach.dtx.txmsgdemo.bank1.message;

import com.pbteach.dtx.txmsgdemo.bank1.dao.AccountInfoDao;
import com.pbteach.dtx.txmsgdemo.bank1.model.AccountChangeEvent;
import com.pbteach.dtx.txmsgdemo.bank1.service.AccountInfoService;
import com.alibaba.fastjson.JSONObject;
import com.pbteach.dtx.txmsgdemo.bank1.utils.EnDecryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @version 1.0
 **/
@Component
@Slf4j
@RocketMQTransactionListener(txProducerGroup = "producer_group_txmsg_bank1")
public class ProducerTxmsgListener implements RocketMQLocalTransactionListener {

    @Autowired
    AccountInfoService accountInfoService;

    @Autowired
    AccountInfoDao accountInfoDao;

    //事务消息发送后的回调方法，当消息发送给mq成功，此方法被回调
    @Override
    @Transactional
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        log.info("==========================执行本地事务2");

        try {
            Thread.sleep(30000);
            log.info("XXXXXXXXXXXXXXXXXX-executeLocalTransaction");
            //解析message，转成AccountChangeEvent
            String messageString = new String((byte[]) message.getPayload());
            String decryptAESStr = EnDecryptUtil.decryptAES(messageString, "123");
            JSONObject jsonObject = JSONObject.parseObject(decryptAESStr);
            String accountChangeString = jsonObject.getString("accountChange");
            //将accountChange（json）转成AccountChangeEvent
            AccountChangeEvent accountChangeEvent = JSONObject.parseObject(accountChangeString, AccountChangeEvent.class);
            //执行本地事务，扣减金额
            accountInfoService.doUpdateAccountBalance(accountChangeEvent);
            //当返回RocketMQLocalTransactionState.COMMIT，自动向mq发送commit消息，mq将消息的状态改为可消费
            return RocketMQLocalTransactionState.COMMIT;
        } catch (Exception e) {
            e.printStackTrace();
            return RocketMQLocalTransactionState.ROLLBACK;
        }


    }

    //事务状态回查，查询是否扣减金额/   当第二步，即上面的代码由于消息队列网络异常的时候（UNKNOWN），几十秒后执行下面
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        log.info("==========================回查3");

        //解析message，转成AccountChangeEvent
        String messageString = new String((byte[]) message.getPayload());
        String decryptAESStr = EnDecryptUtil.decryptAES(messageString, "123");

        JSONObject jsonObject = JSONObject.parseObject(decryptAESStr);
        String accountChangeString = jsonObject.getString("accountChange");
        //将accountChange（json）转成AccountChangeEvent
        AccountChangeEvent accountChangeEvent = JSONObject.parseObject(accountChangeString, AccountChangeEvent.class);
        //事务id
        String txNo = accountChangeEvent.getTxNo();
        int existTx = accountInfoDao.isExistTx(txNo);
        if(existTx>0){
            return RocketMQLocalTransactionState.COMMIT;
        }else{
            return RocketMQLocalTransactionState.UNKNOWN;
        }
    }
}
