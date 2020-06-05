package com.family.filter.commonUse;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * 此过滤器用来解决全站中文乱码问题
 * @author: gzb
 * @date  : 2019年8月7日 下午3:22:17
 *
 */
public class CharacterEncodingFilter implements Filter {

    private FilterConfig filterConfig = null;
    //设置默认的字符编码
    private String defaultCharset = "UTF-8";
    
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        String charset = filterConfig.getInitParameter("charset");
        if(charset==null){
            charset = defaultCharset;
        }
        request.setCharacterEncoding(charset);
        response.setCharacterEncoding(charset);
        response.setContentType("text/html;charset="+charset);
        
        MyCharacterEncodingRequest requestWrapper = new MyCharacterEncodingRequest(request);
        arg2.doFilter(requestWrapper, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        //得到过滤器的初始化配置信息
        this.filterConfig = filterConfig;
    }

}

/*
1.实现与被增强对象相同的接口 
2、定义一个变量记住被增强对象
3、定义一个构造器，接收被增强对象
4、覆盖需要增强的方法
5、对于不想增强的方法，直接调用被增强对象（目标对象）的方法
 */
 
class MyCharacterEncodingRequest extends HttpServletRequestWrapper{
    
    private HttpServletRequest request;
    public MyCharacterEncodingRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }
    /* 重写getParameter方法
     * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
     */
    @Override
    public String getParameter(String name) {
        
        try{
            //获取参数的值
            String value= this.request.getParameter(name);
            if(value==null){
                return null;
            }
            //如果不是以get方式提交数据的，就直接返回获取到的值
            if(!this.request.getMethod().equalsIgnoreCase("get")) {
                return value;
            }else{
                //如果是以get方式提交数据的，就对获取到的值进行转码处理
                value = new String(value.getBytes("ISO8859-1"),this.request.getCharacterEncoding());
                return value;
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
