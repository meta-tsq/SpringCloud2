package com.meta.springcloud.controller;

import com.meta.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Tang poetry all
 * @Date 2022/7/18 15:27
 */
@RestController
public class MessageProviderController {

    private IMessageProvider messageProvider;


    public MessageProviderController(IMessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }


    @GetMapping("/send/message")
    public String sendMessage(){

        String msg = messageProvider.send();

        return msg;
    }

}
