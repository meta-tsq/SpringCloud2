package com.meta.springcloud.imp;

import com.meta.springcloud.api.HystrixProviderServiceRemote;
import com.meta.springcloud.api.PaymentProviderServiceRemote;
import org.springframework.stereotype.Component;

/**
 * @Author Tang poetry all
 * @Date 2022/7/17 9:27
 */
@Component
public class PaymentProviderFallBack implements HystrixProviderServiceRemote {

    @Override
    public String successRequest(Integer id) {
        return "PaymentProviderFallBack Method ---successRequest---"+Thread.currentThread().getName();
    }

    @Override
    public String failed(Integer id) {
        return "PaymentProviderFallBack Method ---failed---"+Thread.currentThread().getName();
    }
}
