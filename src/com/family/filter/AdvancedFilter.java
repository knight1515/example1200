package com.family.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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
 * @author: gzb
 * @date  : 2019年8月7日 下午2:57:13
 *
 */
public class AdvancedFilter implements Filter {
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
        //得到在web.xml中配置的字符编码
        String charset = filterConfig.getInitParameter("charset");
        if(charset==null){
            charset = defaultCharset;
        }
        request.setCharacterEncoding(charset);
        response.setCharacterEncoding(charset);
        response.setContentType("text/html;charset="+charset);
        
        AdvancedRequest requestWrapper = new AdvancedRequest(request);
        arg2.doFilter(requestWrapper, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        //得到过滤器的初始化配置信息
        this.filterConfig = arg0;
    }
class AdvancedRequest extends HttpServletRequestWrapper{
        
        private List<String> dirtyWords = getDirtyWords();
        
        //定义一个变量记住被增强对象(request对象是需要被增强的对象)
        private HttpServletRequest request;
        //定义一个构造函数，接收被增强对象
        public AdvancedRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
        }
        /* 覆盖需要增强的getParameter方法
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
                    //调用filter转义value中的html标签
                    value= filter(value);
                }else{
                    //如果是以get方式提交数据的，就对获取到的值进行转码处理
                    value = new String(value.getBytes("ISO8859-1"),this.request.getCharacterEncoding());
                    //调用filter转义value中的html标签
                    value= filter(value);
                }
                
                for(String dirtyWord : dirtyWords){
                    if(value.contains(dirtyWord)){
                        System.out.println("内容中包含敏感词："+dirtyWord+"，将会被替换成****");
                        //替换敏感字符
                        value = value.replace(dirtyWord, "****");
                    }
                }
                return value;
            }catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
    * @Method: filter
    * @Description: 过滤内容中的html标签
    * @Anthor:孤傲苍狼
    * @param value
    * @return
    */ 
    public String filter(String value) {
        if (value == null){
            return null;
        }
        char content[] = new char[value.length()];
        value.getChars(0, value.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
            case '<':
                result.append("&lt;");
                break;
            case '>':
                result.append("&gt;");
                break;
            case '&':
                result.append("&amp;");
                break;
            case '"':
                result.append("&quot;");
                break;
            default:
                result.append(content[i]);
            }
        }
        return (result.toString());
    }
    
    /**
    * @Method: getDirtyWords
    * @Description: 获取敏感字符
    * @Anthor:孤傲苍狼
    *
    * @return
    */ 
    private List<String> getDirtyWords(){
        List<String> dirtyWords = new ArrayList<String>();
        String dirtyWordPath = filterConfig.getInitParameter("dirtyWord");
        InputStream inputStream = filterConfig.getServletContext().getResourceAsStream(dirtyWordPath);
        InputStreamReader is = null;
        try {
            is = new InputStreamReader(inputStream,defaultCharset);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(is);
        String line;
        try {
            while ((line = reader.readLine())!= null) {//如果 line为空说明读完了
                dirtyWords.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return dirtyWords;
    }
}
