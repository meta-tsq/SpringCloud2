package com.meta.springcloud.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.meta.springcloud.entities.CommonResult;
import com.meta.springcloud.entities.Payment;

/**
 * @Author Tang poetry all
 * @Date 2022/7/20 18:31
 */
public class CustomerBlockHandler {

    public static CommonResult customBlockHandlerOne(BlockException e){

        return new CommonResult(200, "自定义blockHandler---001", new Payment(2022L, "serial009"));

    }

    public static CommonResult customBlockHandlerTwo(BlockException e){

        return new CommonResult(200, "自定义blockHandler---002", new Payment(2022L, "serial009"));

    }

}
