package com.meta.springcloud.api;

import com.meta.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 12:23
 */
@FeignClient(value = "cloud-alibaba-seata-account")
public interface AccountServiceRemote {
    /**
     * 扣减账户余额
     */
    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
