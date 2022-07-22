package com.meta.springcloud.controller;

import com.meta.springcloud.entities.CommonResult;
import com.meta.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 13:04
 */
@RestController
public class StorageController {
    private StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping(value = "/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        storageService.decrease(productId, count);

        return CommonResult.success("库存减少成功");
    }
}
