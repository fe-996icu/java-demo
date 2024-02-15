package com.icu.schedule.listeners;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener, ServletContextAttributeListener {
    // 监听application初始化
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        System.out.println("application" + application.hashCode() + " initialized");
    }

    // 监听application销毁
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        System.out.println("application" + application.hashCode() + " destroyed");
    }

    // 监听application数据增加
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        String name = scae.getName();
        Object value = scae.getValue();
        ServletContext application = scae.getServletContext();
        System.out.println("application" + application.hashCode() + " add:" + name + "=" + value);
    }

    // 监听application数据移除
    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        String name = scae.getName();
        Object value = scae.getValue();
        ServletContext application = scae.getServletContext();
        System.out.println("application" + application.hashCode() + " remove:" + name + "=" + value);
    }

    // 监听数据修改
    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        String name = scae.getName();
        // 旧值
        Object value = scae.getValue();
        ServletContext application = scae.getServletContext();
        // 新值
        Object newValue = application.getAttribute(name);
        System.out.println("application" + application.hashCode() + " change:" + name + "=" + value + " to " + newValue);
    }
}