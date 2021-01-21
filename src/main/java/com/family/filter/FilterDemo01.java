package com.family.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 *  @Description:filter的三种典型应用：
*                     1、可以在filter中根据条件决定是否调用chain.doFilter(request, response)方法，
*                        即是否让目标资源执行
*                     2、在让目标资源执行之前，可以对request\response作预处理，再让目标资源执行
*                     3、在目标资源执行之后，可以捕获目标资源的执行结果，从而实现一些特殊的功能
 * @author: gzb
 * @date  : 2019年8月7日 上午10:46:39
 *
 */
public class FilterDemo01 implements Filter {

    @Override
    public void destroy() {
        System.out.println("----过滤器销毁----");
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        //对request和response进行一些预处理
        arg0.setCharacterEncoding("UTF-8");
        arg1.setCharacterEncoding("UTF-8");
        arg1.setContentType("text/html;charset=UTF-8");
        
        System.out.println("FilterDemo01执行前！！！");
        arg2.doFilter(arg0, arg1);  //让目标资源执行，放行
        System.out.println("FilterDemo01执行后！！！");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("----过滤器初始化----");
    }

}
