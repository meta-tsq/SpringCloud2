package com.meta.springcloud;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Tang poetry all
 * @Date 2022/7/15 10:51
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.meta.springcloud.mapper"})
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class,args);
    }
}
