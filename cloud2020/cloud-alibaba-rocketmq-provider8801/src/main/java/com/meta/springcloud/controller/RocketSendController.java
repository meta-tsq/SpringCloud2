package com.meta.springcloud.controller;

import com.meta.springcloud.service.ProducerRunner;
import com.meta.springcloud.service.RocketProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Tang poetry all
 * @Date 2022/7/19 10:04
 */
@RestController
public class RocketSendController {

    private RocketProvider rocketProvider;

    private ProducerRunner producerRunner;

    public RocketSendController(RocketProvider rocketProvider, ProducerRunner producerRunner) {
        this.rocketProvider = rocketProvider;
        this.producerRunner = producerRunner;
    }

    @GetMapping("/send/1")
    public String sendMsg(){
        String send = null;
        try {
            send = rocketProvider.send();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return send;
    }
}
