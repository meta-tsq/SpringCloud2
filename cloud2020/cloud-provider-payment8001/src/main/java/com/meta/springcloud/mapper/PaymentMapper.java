package com.meta.springcloud.mapper;

import com.meta.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Tang poetry all
 * @Date 2022/7/14 19:24
 */
@Mapper
public interface PaymentMapper {

    /**
     * 增
     * @param payment
     * @return
     */
    int insert(Payment payment);

    /**
     * 查所有
     * @return
     */
    List<Payment> selectAll();

    /**
     * 根据id查一个
     * @param id
     * @return
     */
    Payment selectById(@Param("id") Long id);
}
