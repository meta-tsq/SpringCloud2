package com.meta.springcloud.service;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 13:05
 */
public interface StorageService {

    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
