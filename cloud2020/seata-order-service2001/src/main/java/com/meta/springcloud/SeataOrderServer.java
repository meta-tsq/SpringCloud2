package com.meta.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 11:17
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages = {"com.meta.springcloud.mapper"})
public class SeataOrderServer {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderServer.class,args);
    }
}
