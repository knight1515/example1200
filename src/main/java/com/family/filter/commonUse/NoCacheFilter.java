package com.family.filter.commonUse;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 禁止浏览器缓存所有动态页面
 * @author: gzb
 * @date  : 2019年8月7日 下午3:27:29
 *
 */
public class NoCacheFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
      //把ServletRequest强转成HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) arg0;
        //把ServletResponse强转成HttpServletResponse
        HttpServletResponse response = (HttpServletResponse) arg1;
        //禁止浏览器缓存所有动态页面
        response.setDateHeader("Expires", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        arg2.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
