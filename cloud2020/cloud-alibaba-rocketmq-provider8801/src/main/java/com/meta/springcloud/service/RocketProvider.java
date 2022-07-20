package com.meta.springcloud.service;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Service;

/**
 * @Author Tang poetry all
 * @Date 2022/7/19 10:00
 */
@Service
public class RocketProvider {

    public String send() throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("producer_group");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();

        String body = "心动不如行动";

        Message msg = new Message("test-topic", "tagStr", body.getBytes());
        producer.send(msg);

        return body;

    }
}
