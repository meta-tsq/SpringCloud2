package com.meta.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.meta.springcloud.entities.CommonResult;
import com.meta.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Tang poetry all
 * @Date 2022/7/19 12:44
 */
@RestController
public class NacosOrderController {

    @Value("${service-url.nacos-user-service}")
    private String microService;

    private RestTemplate restTemplate;

    public NacosOrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable Long id){
        return restTemplate.getForObject(microService + "/payment/nacos/" + id ,String.class);
    }

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback") 无配置
    // @SentinelResource(value = "fallback",fallback = "handlerFallBack") fallback只负责业务逻辑异常兜底
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler") blockhandler只负责Sentinel配置异常
    @SentinelResource(value = "fallback",blockHandler = "blockHandler",fallback = "handlerFallBack",exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id) {

        CommonResult<Payment> result = restTemplate.getForObject(microService + "/paymentSQL/"+id,CommonResult.class,id);

        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }

    public CommonResult handlerFallBack(@PathVariable Long id,Throwable e){

        Payment payment = new Payment(id,null);

        return CommonResult.failed("兜底异常handlerFallBack,exception内容"+e.getMessage(),payment);
    }

    public CommonResult blockHandler(@PathVariable  Long id,BlockException blockException) {

        Payment payment = new Payment(id,"null");

        return new CommonResult<>(445,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }

}
