package com.meta.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Tang poetry all
 * @Date 2022/7/20 13:29
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "----TestA";
    }

    @GetMapping("/testB")
    public String testB(){
        log.info("------>"+Thread.currentThread().getName());
        return "----TestB";
    }

    @GetMapping("/testD")
    public String testD(){
       /* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("------>"+Thread.currentThread().getName());*/

        log.info("测试异常比例");
        int a = 10 / 0;
        return "----TestB";
    }

    @GetMapping("/testE")
    public String testE(){
        log.info("测试异常数");
        int a = 10 / 0;
        return "----TestE";
    }

    @GetMapping("/testH")
    @SentinelResource(value = "testH",blockHandler = "dealHandlerTestHotKey")
    public String testHotKey(
            @RequestParam(value="p1",required = false)String p1,
            @RequestParam(value="p2",required = false)String p2
    ){
        return "----testHotKey";
    }

    public String dealHandlerTestHotKey(String p1, String p2, BlockException ex){
        return "----dealHandler_testHotKey";
    }
}
