package com.example.account.service.controller;

import com.example.account.service.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: aos-project
 * @description: AccountController
 * @author: loulvlin
 * @create: 2020-04-30 16:02
 **/
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping("/debit/{userId}/{money}")
    public Boolean debit(@PathVariable("userId") String userId, @PathVariable("money") Integer money) {
        accountService.debit(userId, money);
        return true;
    }
}
