package com.meta.springcloud.service.api;

import com.meta.springcloud.entities.Payment;

import java.util.List;

/**
 * @Author Tang poetry all
 * @Date 2022/7/14 20:06
 */
public interface PaymentService {

    /**
     * 添加
     * @param payment
     * @return
     */
    int add(Payment payment);

    /**
     * 获取
     * @param id
     * @return
     */
    Payment get(Long id);

    /**
     * 获取所有
     * @return
     */
    List<Payment> getAll();
}
