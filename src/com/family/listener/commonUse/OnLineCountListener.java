package com.family.listener.commonUse;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 统计当前在线用户个数
 * @author: gzb
 * @date  : 2019年8月7日 下午4:34:01
 *
 */
public class OnLineCountListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        ServletContext context = arg0.getSession().getServletContext();
        Integer onLineCount = (Integer) context.getAttribute("onLineCount");
        if(onLineCount==null){
            context.setAttribute("onLineCount", 1);
        }else{
            onLineCount++;
            context.setAttribute("onLineCount", onLineCount);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        ServletContext context = arg0.getSession().getServletContext();
        Integer onLineCount = (Integer) context.getAttribute("onLineCount");
        if(onLineCount==null){
            context.setAttribute("onLineCount", 1);
        }else{
            onLineCount--;
            context.setAttribute("onLineCount", onLineCount);
        }
    }

}
