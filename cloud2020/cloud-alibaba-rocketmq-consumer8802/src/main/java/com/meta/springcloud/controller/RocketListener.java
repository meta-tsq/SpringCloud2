package com.meta.springcloud.controller;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Controller;

/**
 * @Author Tang poetry all
 * @Date 2022/7/19 10:03
 */
@Controller
public class RocketListener {

    @StreamListener("input1")
    public void receiveInput1(String receiveMsg) {
        System.out.println("input1 receive: " + receiveMsg);
    }

    @StreamListener("input2")
    public void receiveInput2(String receiveMsg) {
        System.out.println("input2 receive: " + receiveMsg);
    }

}
