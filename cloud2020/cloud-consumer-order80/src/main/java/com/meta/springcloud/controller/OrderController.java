package com.meta.springcloud.controller;

import com.meta.springcloud.lb.LoadBalancer;
import com.meta.springcloud.entities.CommonResult;
import com.meta.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @Author Tang poetry all
 * @Date 2022/7/15 8:55
 */
@RestController
@Slf4j
public class OrderController {
    private RestTemplate restTemplate;

    private DiscoveryClient discoveryClient;

    private LoadBalancer loadBalancer;

    private static final String PAYMENT_SERVICE = "http://CLOUD-PAYMENT-SERVICE";

    public OrderController(RestTemplate restTemplate,DiscoveryClient discoveryClient,LoadBalancer loadBalancer) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
        this.loadBalancer = loadBalancer;
    }

    @GetMapping("/order/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id")Long id){

        CommonResult<Payment> commonResult = restTemplate.getForObject(PAYMENT_SERVICE+"/payment/get/" + id, CommonResult.class, CommonResult.class);

        return commonResult;
    }

    @GetMapping("/order/get/all")
    public CommonResult<List<Payment>> getAll(){
       return restTemplate.getForObject(PAYMENT_SERVICE + "/payment/get/all",CommonResult.class);
    }

    @PostMapping("/order/create")
    public CommonResult<String> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_SERVICE + "/payment/create" , payment , CommonResult.class);
    }

    @GetMapping("/order/service/all")
    public CommonResult<List<String>> getServiceAll(){
        List<String> services = discoveryClient.getServices();

        services.stream().forEach(service -> {log.info("-------->"+service);});

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-8001");

        for (ServiceInstance instance : instances){
            log.info("----->"+instance.getHost());
        }

        return CommonResult.success(services);
    }

    @GetMapping("/order/get/entity/{id}")
    public CommonResult<Payment> getForEntity(@PathVariable("id")Long id){

        ResponseEntity<CommonResult> resultResponseEntity =  restTemplate.getForEntity(PAYMENT_SERVICE+"/payment/get/"+id,CommonResult.class);

        log.info(resultResponseEntity.toString());

        return resultResponseEntity.getBody();
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLb(){
        List<ServiceInstance> clientInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (clientInstances == null || clientInstances.size() == 0){

            return "没有可用机器";

        }
        
        ServiceInstance instances = loadBalancer.instances(clientInstances);

        URI uri = instances.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);

        return result;
    }
}
