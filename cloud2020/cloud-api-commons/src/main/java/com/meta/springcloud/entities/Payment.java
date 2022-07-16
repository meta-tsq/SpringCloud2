package com.meta.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author Tang poetry all
 * @Date 2022/7/14 19:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment implements Serializable {

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 订单流水号
     */
    private String serial;
}
