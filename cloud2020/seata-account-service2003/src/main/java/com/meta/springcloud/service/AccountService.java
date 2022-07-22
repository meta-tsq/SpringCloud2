package com.meta.springcloud.service;


import java.math.BigDecimal;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 12:50
 */
public interface AccountService {

    /**
     * 扣减账户余额
     */
    void decrease(Long userId,BigDecimal money);
}
