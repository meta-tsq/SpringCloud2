package com.meta.springcloud.service.impl;


import com.meta.springcloud.mapper.PaymentMapper;
import com.meta.springcloud.service.api.PaymentService;
import com.meta.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Tang poetry all
 * @Date 2022/7/14 20:06
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }

    @Override
    public int add(Payment payment) {
        return paymentMapper.insert(payment);
    }

    @Override
    public Payment get(Long id) {
        return paymentMapper.selectById(id);
    }

    @Override
    public List<Payment> getAll() {
        return paymentMapper.selectAll();
    }
}
