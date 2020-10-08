package com.example.storage.service.config;

import com.example.storage.service.service.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @program: springcloud-demo
 * @description: MyDataSourceTransactionManagerAutoConfiguration
 * @author: loulvlin
 * @create: 2020-10-06 15:10
 */

//@Configuration
//@EnableTransactionManagement
@Slf4j
public class MyDataSourceTransactionManagerAutoConfiguration extends DataSourceTransactionManagerAutoConfiguration {

    /**
     * 自定义事务
     * MyBatis自动参与到spring事务管理中，无需额外配置，只要org.mybatis.spring.SqlSessionFactoryBean引用的数据源与DataSourceTransactionManager引用的数据源一致即可，否则事务管理会不起作用。
     * @return
     */
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManagers() {
        log.info("-------------------- transactionManager init ---------------------");
        return new DataSourceTransactionManager(SpringContextUtil.getBean("dataSource"));
    }

}
