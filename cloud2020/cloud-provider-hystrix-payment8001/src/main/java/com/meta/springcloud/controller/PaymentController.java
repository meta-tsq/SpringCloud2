package com.meta.springcloud.controller;

import com.meta.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Tang poetry all
 * @Date 2022/7/16 18:44
 */
@RestController
@Slf4j
public class PaymentController {

    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/success/req/{id}")
    public String successRequest(@PathVariable("id") Integer id) {

        String result = paymentService.paymentServiceMethodOK(id);

        log.info("------------>" + result);

        return result;

    }

    @GetMapping("/failed/req/{id}")
    public String failed(@PathVariable("id") Integer id) {

        String result = paymentService.paymentServiceMethodTimeOut(id);

        log.info("------------->" + result);

        return result;

    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        log.info("------------>熔断?<----------");

        return paymentService.paymentCircuitBreaker(id);
    }
}
