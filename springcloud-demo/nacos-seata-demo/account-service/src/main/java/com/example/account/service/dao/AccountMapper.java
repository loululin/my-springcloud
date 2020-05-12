package com.example.account.service.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.account.service.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: aos-project
 * @description: AccountDAO
 * @author: loulvlin
 * @create: 2020-04-30 15:56
 **/
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
