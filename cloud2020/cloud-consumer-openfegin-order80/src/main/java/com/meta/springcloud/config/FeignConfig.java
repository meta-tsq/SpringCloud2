package com.meta.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Tang poetry all
 * @Date 2022/7/16 17:35
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }

}
