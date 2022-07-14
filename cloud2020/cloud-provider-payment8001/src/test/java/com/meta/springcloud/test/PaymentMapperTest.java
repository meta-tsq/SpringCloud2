package com.meta.springcloud.test;

import com.meta.springcloud.entities.Payment;
import com.meta.springcloud.mapper.PaymentMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Tang poetry all
 * @Date 2022/7/14 19:33
 */
@SpringBootTest
public class PaymentMapperTest {

    @Autowired
    private PaymentMapper paymentMapper;

    @Test
    @DisplayName("测试PaymentMapper接口是否能正常使用")
    public void testPaymentMapper(){
        Payment payment = new Payment(null,"2147483648");

        int result = paymentMapper.insert(payment);

        System.out.println(result);

        System.out.println(payment.getId());
/*
        Payment payment = paymentMapper.selectById(1L);

        System.out.println(payment);*/
    }
}
