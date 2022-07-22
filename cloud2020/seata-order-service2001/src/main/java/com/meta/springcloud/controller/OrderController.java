package com.meta.springcloud.controller;

import com.meta.springcloud.entities.CommonResult;
import com.meta.springcloud.entities.Order;
import com.meta.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 12:41
 */
@RestController
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/create")
    public CommonResult creatOrder(Order order){

        orderService.create(order);

        return CommonResult.success("订单创建成功");
    }
}
