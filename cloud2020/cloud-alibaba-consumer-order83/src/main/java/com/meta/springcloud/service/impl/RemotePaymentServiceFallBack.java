package com.meta.springcloud.service.impl;

import com.meta.springcloud.entities.CommonResult;
import com.meta.springcloud.entities.Payment;
import com.meta.springcloud.service.api.RemotePaymentService;
import org.springframework.stereotype.Component;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 8:01
 */
@Component
public class RemotePaymentServiceFallBack implements RemotePaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级返回,没有该流水信息", new Payment(id, "errorSerial......"));
    }

}
