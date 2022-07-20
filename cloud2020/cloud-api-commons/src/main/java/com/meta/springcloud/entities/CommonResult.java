package com.meta.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 前端统一json格式字符串
 * @Author Tang poetry all
 * @Date 2022/7/14 19:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable{

    /**
     * 请求处理成功返回的状态码
     */
    private static final Integer SUCCESS = 200;

    /**
     * 请求处理失败的状态码
     */
    private static final Integer FAILED = 500;

    private Integer code;

    private String message;

    private T data;

    public static <Type> CommonResult<Type> success(Type data){
        return new CommonResult<Type>(SUCCESS,null,data);
    }

    public static <Type> CommonResult<Type> success(){
        return new CommonResult<Type>(SUCCESS,null,null);
    }

    public static <Type> CommonResult<Type> success(String message){
        return new CommonResult<Type>(SUCCESS,message,null);
    }

    public static <Type> CommonResult<Type> success(String message,Type data){
        return new CommonResult<Type>(SUCCESS,message,data);
    }

    public static <Type> CommonResult<Type> failed(String message){
        return new CommonResult<Type>(FAILED,message,null);
    }

    public static <Type> CommonResult<Type> failed(String message,Type data){
        return new CommonResult<Type>(FAILED,message,data);
    }
}
