package com.example.order.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: storage-service
 * @description: AccountFeignClient
 * @author: loulvlin
 * @create: 2020-05-06 14:18
 **/
@FeignClient(name = "account-service")
public interface AccountFeignClient {

    @GetMapping("/debit/{userId}/{money}")
    Boolean debit(@PathVariable(value = "userId") String userId, @PathVariable(value = "money") Integer money);
}
