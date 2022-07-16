package com.meta.springcloud.controller;

import com.meta.springcloud.api.PaymentProviderServiceRemote;
import com.meta.springcloud.entities.CommonResult;
import com.meta.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Tang poetry all
 * @Date 2022/7/16 16:10
 */
@RestController
public class OrderOpenFeignController {

    private PaymentProviderServiceRemote paymentProviderServiceRemote;

    public OrderOpenFeignController(PaymentProviderServiceRemote paymentProviderServiceRemote) {
        this.paymentProviderServiceRemote = paymentProviderServiceRemote;
    }

    @GetMapping("/consumer/get/all")
    public CommonResult<List<Payment>> getAll(){
       return paymentProviderServiceRemote.getAll();
    }

    @GetMapping("/consumer/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id")Long id){
        return paymentProviderServiceRemote.get(id);
    }

    @GetMapping("/consumer/time/out")
    public String timeOut(){
       return paymentProviderServiceRemote.paymentTimeOut();
    }
}
