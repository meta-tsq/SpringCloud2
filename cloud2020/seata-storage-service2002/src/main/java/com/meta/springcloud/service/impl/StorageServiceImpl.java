package com.meta.springcloud.service.impl;

import com.meta.springcloud.mapper.StorageMapper;
import com.meta.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 13:05
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    private StorageMapper storageMapper;

    public StorageServiceImpl(StorageMapper storageMapper) {
        this.storageMapper = storageMapper;
    }

    /**
     * 扣减库存
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");
    }

}
