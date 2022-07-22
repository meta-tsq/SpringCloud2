package com.meta.springcloud.service.api;

import com.meta.springcloud.entities.CommonResult;
import com.meta.springcloud.entities.Payment;
import com.meta.springcloud.service.impl.RemotePaymentServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 7:57
 */
@FeignClient(value = "nacos-payment-provider",fallback = RemotePaymentServiceFallBack.class)
public interface RemotePaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
