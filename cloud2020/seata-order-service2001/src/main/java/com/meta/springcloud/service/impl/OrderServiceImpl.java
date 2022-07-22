package com.meta.springcloud.service.impl;

import com.meta.springcloud.api.AccountServiceRemote;
import com.meta.springcloud.api.StorageServiceRemote;
import com.meta.springcloud.entities.Order;
import com.meta.springcloud.mapper.OrderMapper;
import com.meta.springcloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 12:22
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
     private OrderMapper orderMapper;

     private AccountServiceRemote accountServiceRemote;

     private StorageServiceRemote storageServiceRemote;

    public OrderServiceImpl(OrderMapper orderMapper, AccountServiceRemote accountServiceRemote, StorageServiceRemote storageServiceRemote) {
        this.orderMapper = orderMapper;
        this.accountServiceRemote = accountServiceRemote;
        this.storageServiceRemote = storageServiceRemote;
    }


    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("------->下单开始");

        // 1.往数据库中插入订单信息
        orderMapper.create(order);

        // 2.减少库存
        log.info("------->order-service中扣减库存开始");
        storageServiceRemote.decrease(order.getProductId(), order.getCount());
        log.info("------->order-service中扣减库存结束");

        // 3.扣除账户金额
        log.info("------->order-service中扣减余额开始");
        accountServiceRemote.decrease(order.getUserId(), order.getMoney());
        log.info("------->order-service中扣减余额结束");

        // 4.修改订单状态为已支付
        log.info("------->order-service中修改订单状态开始");
        orderMapper.update(order.getUserId(),0);
        log.info("------->order-service中修改订单状态结束");

        log.info("------->下单结束");
    }
}
