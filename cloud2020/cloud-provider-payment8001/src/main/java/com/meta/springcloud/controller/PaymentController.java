package com.meta.springcloud.controller;

import com.meta.springcloud.entities.CommonResult;
import com.meta.springcloud.entities.Payment;
import com.meta.springcloud.service.api.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Tang poetry all
 * @Date 2022/7/14 20:09
 */
@RestController
@Slf4j
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment/create")
    public CommonResult<String> save(Payment payment){

            int result = paymentService.add(payment);

            if (result > 0){

                return CommonResult.success("插入数据成功");

            }else {

                return CommonResult.failed("数据插入失败");

            }

    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id")Long id){

        Payment payment = paymentService.get(id);

        if (payment != null){

            return CommonResult.success(payment);

        }else {

            return CommonResult.failed("没有查找到指定数据");

        }
    }

    @GetMapping("/payment/get/all")
    public CommonResult<List<Payment>> getAll(){

        List<Payment> payments = paymentService.getAll();

        if (payments == null || payments.size() == 0){

            return CommonResult.failed("数据库中没有指定数据");

        }else {

            return CommonResult.success(payments);

        }
    }
}
