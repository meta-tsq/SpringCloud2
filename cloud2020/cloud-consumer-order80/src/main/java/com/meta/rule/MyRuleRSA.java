package com.meta.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Tang poetry all
 * @Date 2022/7/16 14:58
 */
public class MyRuleRSA extends AbstractLoadBalancerRule {

    private  AtomicInteger total = new AtomicInteger(0);

    private AtomicInteger currentIndex = new AtomicInteger(0);

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

            /*int index = chooseRandomInt(serverCount);
            server = upList.get(index);*/

            // 先判断使用次数是否小于5次
            if (total.get() < 5){

                // 直接从数组中去取
                server = upList.get(currentIndex.get());

                // 将调用次数加一
                total.incrementAndGet();

            }else {

                total.set(0);

                if (currentIndex.incrementAndGet() >= upList.size()){

                    currentIndex.set(0);

                }

            }



            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }
}
