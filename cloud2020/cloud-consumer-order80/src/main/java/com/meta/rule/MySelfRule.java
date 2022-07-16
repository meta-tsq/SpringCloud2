package com.meta.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Tang poetry all
 * @Date 2022/7/16 14:42
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule iRule(){
        return new MyRuleRSA();
    }
}
