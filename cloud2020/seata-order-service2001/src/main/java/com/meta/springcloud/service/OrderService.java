package com.meta.springcloud.service;

import com.meta.springcloud.entities.Order;
import org.springframework.stereotype.Service;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 12:21
 */
public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
