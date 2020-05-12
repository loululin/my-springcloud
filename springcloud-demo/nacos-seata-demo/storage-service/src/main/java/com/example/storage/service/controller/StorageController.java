package com.example.storage.service.controller;

import com.example.storage.service.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: aos-project
 * @description: StorageController
 * @author: loulvlin
 * @create: 2020-05-06 09:36
 **/
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @GetMapping(path = "/deduct/{commodityCode}/{count}")
    public Boolean deduct(@PathVariable("commodityCode") String commodityCode,
                          @PathVariable("count") Integer count) {
        storageService.deduct(commodityCode, count);
        return true;
    }
}
