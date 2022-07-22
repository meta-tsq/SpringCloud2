package com.meta.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 13:05
 */
@Mapper
public interface StorageMapper {
    /**
     * 扣减库存
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
