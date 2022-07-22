package com.meta.springcloud.service.impl;

import com.meta.springcloud.mapper.AccountMapper;
import com.meta.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 12:52
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    private AccountMapper accountMapper;

    public AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");

        try { TimeUnit.SECONDS.sleep(30); } catch (InterruptedException e) { e.printStackTrace(); }

        accountMapper.decrease(userId,money);

        log.info("------->account-service中扣减账户余额结束");
    }
}
