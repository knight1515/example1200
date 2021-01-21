https://www.cnblogs.com/xdp-gacl/p/3789624.html

https://www.cnblogs.com/xdp-gacl/p/3798347.html //HttpServletRequest对象(一)

## HttpServletResponse 生成验证码

代码：
    /example1200/src/com/family/httpServlet/DrawImage.java //生成验证码图片
    /example1200/WebContent/DrawImage.jsp //显示
    /example1200/WebContent/DrawImage2.jsp //验证的前端
    /example1200/src/com/family/httpServlet/CheckServlet.java //验证的后端

配置:
  <!-- 使用OutputStream生成验证码 -->
  <servlet>
        <servlet-name>DrawImage</servlet-name>
        <servlet-class>family.httpServlet.DrawImage</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>DrawImage</servlet-name>
    <url-pattern>/servlet/DrawImage</url-pattern>
  </servlet-mapping>
      <!-- 验证 -->
  <servlet>
        <servlet-name>CheckServlet</servlet-name>
        <servlet-class>com.family.httpServlet.CheckServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>CheckServlet</servlet-name>
    <url-pattern>/servlet/CheckServlet</url-pattern>
  </servlet-mapping>
  
## 后端向前段输出的有两种方式OutputStream和PrintWriter
代码：
    /example1200/src/com/family/httpServlet/ResponseDemo01.java
    
## 文件下载功能，要用OutputStream，不用PrintWriter，OutputStream是字节流，PrintWriter是字符流容易丢失数据。
代码：
    /example1200/src/com/family/httpServlet/ResponseDemo02.java
## 生成验证码的工具
代码：
    /example1200/src/com/family/httpServlet/ResponseDemo03.java
    
## 重定向
代码：
    /example1200/src/com/family/httpServlet/ResponseDemo04.java
    
    
# HttpServletRequest对象(一)
https://www.cnblogs.com/xdp-gacl/p/3798347.html
## 获得客户机请求参数(客户端提交的数据)

代码：
/example1200/src/com/family/httpServlet/RequestDemo03.java
/example1200/WebContent/RequestDemo03.jsp

## 以GET方式提交表单中文参数的乱码问题
## get方式提交中文数据乱码产生的原因和解决办法
## 以超链接形式传递中文参数的乱码问题
## 提交中文数据乱码问题总结
## Request对象实现请求转发
## post方式提交中文数据乱码产生的原因和解决办法
