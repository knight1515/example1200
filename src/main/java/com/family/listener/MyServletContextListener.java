package com.family.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author: gzb
 * @date  : 2019年8月6日 下午3:26:45
 *
 */
public class MyServletContextListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("ServletContext对象创建");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("ServletContext对象销毁");
    }


}
