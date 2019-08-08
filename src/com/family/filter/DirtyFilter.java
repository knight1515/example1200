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
 * 敏感词过滤器
 * @author: gzb
 * @date  : 2019年8月7日 下午2:36:39
 *
 */
public class DirtyFilter implements Filter {

    private FilterConfig config = null;
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        DirtyRequest dirtyrequest = new DirtyRequest(request);
        
        System.out.println("DirtyFilter执行了---");
        arg2.doFilter(dirtyrequest, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        this.config = arg0;
    }
    
    /**
    * @Method: getDirtyWords
    * @Description: 获取敏感字符
    * @Anthor:孤傲苍狼
    *
    * @return
    */ 
    private List<String> getDirtyWords(){
        System.out.println("name为：------------------$");
        List<String> dirtyWords = new ArrayList<String>();
        String dirtyWordPath = config.getInitParameter("dirtyWord");
        InputStream inputStream = config.getServletContext().getResourceAsStream(dirtyWordPath);
        InputStreamReader is = null;
        try {
            is = new InputStreamReader(inputStream,"UTF-8");
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


/**
 * @ClassName: DirtyRequest
 * @Description: 使用Decorator模式包装request对象，实现敏感字符过滤功能
 * @author: 孤傲苍狼
 * @date: 2014-9-6 上午11:56:35
 *
 */ 
 class DirtyRequest extends HttpServletRequestWrapper{

     private List<String> dirtyWords = getDirtyWords();
     private HttpServletRequest request;
     public DirtyRequest(HttpServletRequest request) {
         super(request);
         this.request = request;
     }
     /* 重写getParameter方法，实现对敏感字符的过滤
      * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
      */
     @Override
     public String getParameter(String name) {
         System.out.println("name为：------------------%");
         String value = this.request.getParameter(name);
         if(value==null){
             return null;
         }
         
         for(String dirtyWord : dirtyWords){
             if(value.contains(dirtyWord)){
                 System.out.println("内容中包含敏感词："+dirtyWord+"，将会被替换成****");
                 //替换敏感字符
                 value = value.replace(dirtyWord, "****");
             }
         }
         return value;
     }
 }
}