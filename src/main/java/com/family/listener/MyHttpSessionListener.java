package com.family.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author: gzb
 * @date  : 2019年8月6日 下午5:32:27
 *
 */
public class MyHttpSessionListener implements HttpSessionListener {

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
     */
    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        System.out.println( arg0.getSession() + "创建了！！");
        
        System.out.println("Session的id是："+arg0.getSession().getId());
        
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        System.out.println("session销毁了！！");
        
    }
}
