package com.meta.springcloud.controller;

import com.meta.springcloud.entities.CommonResult;
import com.meta.springcloud.entities.Payment;
import com.meta.springcloud.service.api.RemotePaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 7:59
 */
@RestController
@Slf4j
public class FeignOrderController {

    private RemotePaymentService paymentService;

    public FeignOrderController(RemotePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(value = "/consumer/openfeign/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {

        if (id == 4) {
            throw new RuntimeException("没有该id");
        }

        return paymentService.paymentSQL(id);

    }

}
