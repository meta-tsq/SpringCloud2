package com.meta.springcloud.api;

import com.meta.springcloud.entities.CommonResult;
import com.meta.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author Tang poetry all
 * @Date 2022/7/16 16:08
 */
@FeignClient(name = "CLOUD-PAYMENT-SERVICE")
public interface PaymentProviderServiceRemote {

    @PostMapping("/payment/create")
    CommonResult<String> save(@RequestBody Payment payment);

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> get(@PathVariable("id") Long id);

    @GetMapping("/payment/get/all")
    CommonResult<List<Payment>> getAll();

    @GetMapping(value = "/payment/lb")
    String getPaymentLB();

    @GetMapping("/time/out")
    String paymentTimeOut();
}
