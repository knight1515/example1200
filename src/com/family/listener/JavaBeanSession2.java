package com.family.listener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * @author: gzb
 * @date  : 2019年8月7日 上午10:22:31
 *
 */
public class JavaBeanSession2 implements HttpSessionActivationListener, Serializable {

    private static final long serialVersionUID = 7589841135210272124L;
    private String name;
    
    @Override
    public void sessionDidActivate(HttpSessionEvent arg0) {
        System.out.println(name+"和session一起从硬盘反序列化(活化)回到内存了，session的id是："+arg0.getSession().getId());    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent arg0) {
        System.out.println(name+"和session一起被序列化(钝化)到硬盘了，session的id是："+arg0.getSession().getId());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JavaBeanSession2(String name) {
        this.name = name;
    }
    
}

