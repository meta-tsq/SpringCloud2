package com.meta.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Tang poetry all
 * @Date 2022/7/16 12:46
 */
@RestController
@Slf4j
public class OrderZkController {

    public static final String INSTANCE_SERVICE_NAME = "http://cloud-payment-service";

    private RestTemplate restTemplate;

    public OrderZkController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consumer/get/info")
    public String getInfo(){
        return  restTemplate.getForObject(INSTANCE_SERVICE_NAME + "/payment/zk",String.class);
    }
}
