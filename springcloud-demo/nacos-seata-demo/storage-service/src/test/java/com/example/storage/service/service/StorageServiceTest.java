package com.example.storage.service.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @program: springcloud-demo
 * @description: StorageServiceTest
 * @author: loulvlin
 * @create: 2020-10-06 14:36
 */
@SpringBootTest
public class StorageServiceTest {

    @Resource
    private StorageService storageService;


    @Test
    public void test(){
        storageService.deduct("2001",2);
    }


    @Test
    public void test1(){
        storageService.create("1002","2001",2);
    }

}
