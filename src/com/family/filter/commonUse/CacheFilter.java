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
 * 控制缓存的filter
 * @author: gzb
 * @date  : 2019年8月7日 下午3:29:43
 *
 */
public class CacheFilter implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        
        //1.获取用户想访问的资源
        String uri = request.getRequestURI(); 
        
        //2.得到用户想访问的资源的后缀名
        String ext = uri.substring(uri.lastIndexOf(".")+1);
        
        //得到资源需要缓存的时间
        String time = filterConfig.getInitParameter(ext);
        if(time!=null){
            long t = Long.parseLong(time)*3600*1000;
            //设置缓存
            response.setDateHeader("expires", System.currentTimeMillis() + t);
        }
        
        arg2.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
