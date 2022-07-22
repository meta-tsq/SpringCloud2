package com.meta.springcloud.api;

import com.meta.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 12:24
 */
@FeignClient(value = "cloud-alibaba-seata-storage")
public interface StorageServiceRemote {

    /**
     * 扣减库存
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
