package com.meta.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author Tang poetry all
 * @Date 2022/7/16 10:22
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentZk(){
        return "springCloud with zookeeper: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
