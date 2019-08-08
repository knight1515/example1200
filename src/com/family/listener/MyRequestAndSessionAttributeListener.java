package com.family.listener;

import java.text.MessageFormat;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author: gzb
 * @date  : 2019年8月7日 上午10:01:15
 *
 */
public class MyRequestAndSessionAttributeListener
        implements HttpSessionAttributeListener, ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent arg0) {
        String str =MessageFormat.format(
                "ServletRequest域对象中添加了属性:{0}，属性值是:{1}"
                ,arg0.getName()
                ,arg0.getValue());
        System.out.println(str);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent arg0) {
        String str =MessageFormat.format(
                "ServletRequest域对象中删除属性:{0}，属性值是:{1}"
                ,arg0.getName()
                ,arg0.getValue());
        System.out.println(str);
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent arg0) {
        String str =MessageFormat.format(
                "ServletRequest域对象中替换了属性:{0}的值"
                ,arg0.getName());
        System.out.println(str);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent arg0) {
        String str =MessageFormat.format(
                "HttpSession域对象中添加了属性:{0}，属性值是:{1}"
                ,arg0.getName()
                ,arg0.getValue());
        System.out.println(str);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent arg0) {
        String str =MessageFormat.format(
                "HttpSession域对象中删除属性:{0}，属性值是:{1}"
                ,arg0.getName()
                ,arg0.getValue());
        System.out.println(str);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent arg0) {
        String str =MessageFormat.format(
                "HttpSession域对象中替换了属性:{0}的值"
                ,arg0.getName());
        System.out.println(str);
    }

}
