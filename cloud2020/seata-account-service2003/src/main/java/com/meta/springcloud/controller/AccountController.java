package com.meta.springcloud.controller;

import com.meta.springcloud.entities.CommonResult;
import com.meta.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Author Tang poetry all
 * @Date 2022/7/21 12:50
 */
@RestController
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){

            accountService.decrease(userId,money);

            return CommonResult.success("成功");

    }
}
