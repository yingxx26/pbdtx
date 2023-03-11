package com.pbteach.dtx.txmsgdemo.bank1.dao;

import com.pbteach.dtx.txmsgdemo.bank1.entity.AccountInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TestShiWuDao {
    @Update("update test_shi_wu set amount=amount+1 where id=#{id}")
    int updateTestShiWu(@Param("id") Integer id, @Param("amount") Double amount);


}
