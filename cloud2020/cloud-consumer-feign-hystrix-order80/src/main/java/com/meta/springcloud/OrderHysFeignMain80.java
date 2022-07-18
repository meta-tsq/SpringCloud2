package com.meta.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Tang poetry all
 * @Date 2022/7/16 19:32
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class OrderHysFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHysFeignMain80.class,args);
    }
}
