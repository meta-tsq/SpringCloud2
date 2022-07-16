package com.meta.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Tang poetry all
 * @Date 2022/7/16 15:28
 */
@Component
@Slf4j
public class MyLb implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){

        int current;

        int next;

        do{

            current = atomicInteger.get();

            next = current >= Integer.MAX_VALUE ? 0 : current + 1;

        }while (!atomicInteger.compareAndSet(current,next));

        log.info("---第几次访问次数---->"+next);

        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
