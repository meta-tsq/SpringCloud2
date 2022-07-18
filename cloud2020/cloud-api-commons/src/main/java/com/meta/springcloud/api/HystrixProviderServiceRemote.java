package com.meta.springcloud.api;

import com.meta.springcloud.imp.PaymentProviderFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Tang poetry all
 * @Date 2022/7/16 19:34
 */
@FeignClient(name = "CLOUD-HYSTRIX-PAYMENT-SERVICE",fallback = PaymentProviderFallBack.class)
public interface HystrixProviderServiceRemote {

    @GetMapping("/success/req/{id}")
    String successRequest(@PathVariable("id") Integer id);

    @GetMapping("/failed/req/{id}")
    String failed(@PathVariable("id") Integer id);
}
