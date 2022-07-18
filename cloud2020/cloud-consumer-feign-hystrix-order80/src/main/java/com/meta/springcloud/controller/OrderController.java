package com.meta.springcloud.controller;

import com.meta.springcloud.api.HystrixProviderServiceRemote;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Tang poetry all
 * @Date 2022/7/16 19:33
 */
@RestController
@Slf4j
public class OrderController {
    private HystrixProviderServiceRemote hystrixProviderServiceRemote;

    public OrderController(HystrixProviderServiceRemote hystrixProviderServiceRemote) {
        this.hystrixProviderServiceRemote = hystrixProviderServiceRemote;
    }

    @GetMapping("/consumer/success/req/{id}")
    public String successReq(@PathVariable("id") Integer id) {

        String result = hystrixProviderServiceRemote.successRequest(id);

        log.info("------>当前是：" + Thread.currentThread().getName() + "线程所执行的程序");

        return result;
    }

    @GetMapping("/consumer/failed/req/{id}")
    @HystrixCommand(fallbackMethod = "failedReqFallBack",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1888")
    })
    public String failedReq(@PathVariable("id") Integer id) {

        String failed = hystrixProviderServiceRemote.failed(id);

        log.info("------>当前是：" + Thread.currentThread().getName() + "线程所执行的程序");

        return failed;
    }

    public String failedReqFallBack(@PathVariable("id") Integer id){
        return "当前服务超时或异常,触发Hystrix的服务降级机制"+Thread.currentThread().getName();
    }

    public String globalFallBack(){
        return "Global全局方法..."+Thread.currentThread().getName();
    }
}
