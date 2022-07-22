package com.meta.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 12:49
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class SeataAccountServer {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountServer.class,args);
    }
}
