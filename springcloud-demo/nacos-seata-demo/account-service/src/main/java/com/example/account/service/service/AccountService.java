package com.example.account.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.account.service.dao.AccountMapper;
import com.example.account.service.entity.Account;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: aos-project
 * @description: AccountService
 * @author: loulvlin
 * @create: 2020-04-30 15:57
 **/
@Service
public class AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    private static final String ERROR_USER_ID = "1002";

    @Resource
    private AccountMapper accountMapper;

    @Transactional
    public void debit(String userId, Integer num) {
        logger.info("开始全局事务，XID = " + RootContext.getXID());
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.setEntity(new Account().setUserId(userId));


        Account account = accountMapper.selectOne(wrapper);
        account.setMoney(account.getMoney() - num);
        accountMapper.updateById(account);

        if (ERROR_USER_ID.equals(userId)) {
            throw new RuntimeException("account branch exception");
        }
    }
}
