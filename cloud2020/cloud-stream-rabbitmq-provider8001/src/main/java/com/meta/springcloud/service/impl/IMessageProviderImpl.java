package com.meta.springcloud.service.impl;

import com.meta.springcloud.service.IMessageProvider;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * @Author Tang poetry all
 * @Date 2022/7/18 15:21
 */
@EnableBinding(Source.class)
public class IMessageProviderImpl implements IMessageProvider {

    private MessageChannel output;

    public IMessageProviderImpl(MessageChannel output) {
        this.output = output;
    }

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();

        this.output.send(MessageBuilder.withPayload(serial).build());
        // 创建并发送消息

        System.out.println("***serial: "+serial);

        return serial;
    }
}
