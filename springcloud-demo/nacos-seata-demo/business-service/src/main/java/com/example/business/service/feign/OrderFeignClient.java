package com.example.business.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: storage-service
 * @description: OrderFeignClient
 * @author: loulvlin
 * @create: 2020-05-06 14:44
 **/
@FeignClient(value = "order-service")
public interface OrderFeignClient {

    @GetMapping("/order/{userId}/{commodityCode}/{count}")
    Boolean create(@PathVariable("userId") String userId,
                @PathVariable("commodityCode") String commodityCode,
                @PathVariable("count") Integer count);
}
