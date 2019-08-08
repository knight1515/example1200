package com.family.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author: gzb
 * @date  : 2019年8月7日 上午10:15:34
 *
 */
public class JavaBeanSession implements HttpSessionBindingListener {

    private String name;
    
    @Override
    public void valueBound(HttpSessionBindingEvent arg0) {
        System.out.println(name+"被加到session中了");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent arg0) {
        System.out.println(name+"被session踢出来了");
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JavaBeanSession(String name) {
        this.name = name;
    }
}
