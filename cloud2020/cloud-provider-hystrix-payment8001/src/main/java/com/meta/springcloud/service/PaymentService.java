package com.meta.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author Tang poetry all
 * @Date 2022/7/16 18:49
 */
@Service
@DefaultProperties(defaultFallback = "globalFallBack")
public class PaymentService {

    @HystrixCommand
    public String paymentServiceMethodOK(Integer id) {
        int a = 10 / 0;

        return "当前处理的线程是: " + Thread.currentThread().getName() + " paymentOkInformation:" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentServiceMethodTimeOutFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentServiceMethodTimeOut(Integer id) {
        //int a = 10/0;

        int sleepTime = 3;

        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "当前处理的线程是：" + Thread.currentThread().getName() + "paymentInformation : " + id + "共耗时为：" + sleepTime + "秒";
    }

    public String paymentServiceMethodTimeOutFallBack(Integer id) {
        return "当前请求出现超时或失败,触发服务熔断" + Thread.currentThread().getName() + "o(╥﹏╥)o" + id;
    }

    public String globalFallBack() {
        return "Global全局方法..." + Thread.currentThread().getName();
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String paymentCircuitBreaker(Integer id) {

        if (id < 0) {

            throw new RuntimeException("id不能为负数");

        }

        String serialNumber = IdUtil.fastSimpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;

    }

    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " + id;
    }

}
