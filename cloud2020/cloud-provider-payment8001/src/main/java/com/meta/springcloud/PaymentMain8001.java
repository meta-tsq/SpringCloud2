package com.meta.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 主启动类
 * @Author Tang poetry all
 * @Date 2022/7/14 19:05
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.meta.springcloud.mapper"})
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
    }
}
