package com.family.listener;

import java.text.MessageFormat;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * @author: gzb
 * @date  : 2019年8月7日 上午9:53:24
 *
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent arg0) {
        String str =MessageFormat.format(
                "ServletContext域对象中添加了属性:{0}，属性值是:{1}"
                ,arg0.getName()
                ,arg0.getValue());
        System.out.println(str);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent arg0) {
        String str =MessageFormat.format(
                "ServletContext域对象中删除属性:{0}，属性值是:{1}"
                ,arg0.getName()
                ,arg0.getValue());
        System.out.println(str);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent arg0) {
        String str =MessageFormat.format(
                "ServletContext域对象中替换了属性:{0}的值"
                ,arg0.getName());
        System.out.println(str);
    }

}
