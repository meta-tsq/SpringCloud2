package com.meta.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @Author Tang poetry all
 * @Date 2022/7/19 10:02
 */
@SpringBootApplication
@EnableBinding({Source.class, Sink.class})
public class RocketConsumer8802 {
    public static void main(String[] args) {
        SpringApplication.run(RocketConsumer8802.class,args);
    }
}
