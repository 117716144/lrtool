package com.base.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * @author XIEYING
 *
 */
public class SpringUtil implements ApplicationContextAware {

    ApplicationContext applicationContext;

    static SpringUtil instance;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (instance == null) {
            instance = new SpringUtil();
        }
        instance.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return instance.applicationContext;
    }
}
