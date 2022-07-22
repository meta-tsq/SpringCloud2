package com.meta.springcloud;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 13:03
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.meta.springcloud.mapper"})
public class SeataStorageServer {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageServer.class,args);
    }
}
