package com.example.storage.service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware, BeanFactoryPostProcessor {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    private static ConfigurableListableBeanFactory beanFactory; // Spring应用上下文环境

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        com.example.storage.service.service.SpringContextUtil.beanFactory = beanFactory;
        logger.info("-------postProcessBeanFactory");
    }

    // Spring应用上下文环境
    private static ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口的回调方法。设置上下文环境
     *
     * @param applicationContext
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        com.example.storage.service.service.SpringContextUtil.applicationContext = applicationContext;
        logger.info("-------setApplicationContext");

    }

    /**
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取对象
     *
     * @param name
     * @return Object
     */
    public static <T> T getBean(String name) throws BeansException {
        return (T)beanFactory.getBean(name);
    }
    public static <T> T getBean(Class<T> clz) throws BeansException {
        return (T)beanFactory.getBean(clz);
    }

}
