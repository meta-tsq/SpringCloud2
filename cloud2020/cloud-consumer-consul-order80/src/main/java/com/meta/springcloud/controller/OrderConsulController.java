package com.meta.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Tang poetry all
 * @Date 2022/7/16 13:40
 */
@RestController
public class OrderConsulController {

    private static final String MICRO_SERVICE_ORDER = "http://consul-provider-service";

    private RestTemplate restTemplate;

    public OrderConsulController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo() {
        String result = restTemplate.getForObject(MICRO_SERVICE_ORDER+"/payment/consul", String.class);

        System.out.println("消费者调用支付服务(consule)--->result:" + result);

        return result;
    }

}
