package com.henghao.Garden.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * function 自定义上下文监听
 * <p>
 * date 2017.02.28
 *
 * @author 严彬荣
 */
@Component
public class ProjetContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("关闭服务器");

    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("开启服务器");
    }

}
