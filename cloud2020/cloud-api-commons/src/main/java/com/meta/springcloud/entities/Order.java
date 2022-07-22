package com.meta.springcloud.entities;

import lombok.*;

import java.math.BigDecimal;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 11:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    /**
     * 订单状态：0：创建中；1：已完结
     */
    private Integer status;
}
