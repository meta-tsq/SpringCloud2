package com.meta.springcloud.mapper;

import com.meta.springcloud.entities.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @Author Tang poetry all
 * @Date 2022/7/21 11:18
 */
@Mapper
public interface OrderMapper {

    /**
     * 创建订单
     */
    void create(Order order);

    /**
     * 修改订单金额
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);

}
