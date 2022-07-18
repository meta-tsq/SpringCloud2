package com.meta.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Tang poetry all
 * @Date 2022/7/17 14:21
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder locatorBuilder){
        RouteLocatorBuilder.Builder routes = locatorBuilder.routes();

        routes.route("path_route_meta", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }
}
