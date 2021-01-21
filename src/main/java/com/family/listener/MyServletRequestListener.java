package com.family.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @author: gzb
 * @date  : 2019年8月6日 下午5:52:58
 *
 */
public class MyServletRequestListener implements ServletRequestListener{
    @Override
    public void requestInitialized(ServletRequestEvent arg0) {
        System.out.println(arg0.getServletRequest() + "创建了！！");
    }
    
    @Override
    public void requestDestroyed(ServletRequestEvent arg0) {
        System.out.println(arg0.getServletRequest() + "销毁了！！");
    }



}
