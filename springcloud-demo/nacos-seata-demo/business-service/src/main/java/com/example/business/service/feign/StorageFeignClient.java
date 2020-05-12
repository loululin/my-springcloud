package com.example.business.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: storage-service
 * @description: StorageFeignClient
 * @author: loulvlin
 * @create: 2020-05-06 14:49
 **/
@FeignClient(name = "storage-service")
public interface StorageFeignClient {

    @GetMapping("/deduct/{commodityCode}/{count}")
    Boolean deduct(@PathVariable("commodityCode") String commodityCode,
                   @PathVariable("count") Integer count);
}
