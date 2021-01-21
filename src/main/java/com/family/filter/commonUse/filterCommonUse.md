# 1、总则
Filter(过滤器)常见应用：
    1、统一全站字符编码
    2、禁止浏览器缓存所有动态页面
    3、控制浏览器缓存页面中的静态资源
    4、实现用户自动登陆

## 1、统一全站字符编码
    通过配置参数charset指明使用何种字符编码,以处理Html Form请求参数的中文问题
    
    filter:CharacterEncodingFilter
    ```
      <filter>
          <filter-name>CharacterEncodingFilter</filter-name>
          <filter-class>me.gacl.web.filter.CharacterEncodingFilter</filter-class>
          <init-param>
              <param-name>charset</param-name>
              <param-value>UTF-8</param-value>
          </init-param>
      </filter>
      
      <filter-mapping>
          <filter-name>CharacterEncodingFilter</filter-name>
          <url-pattern>/*</url-pattern>
      </filter-mapping>
    ```
  
## 2、禁止浏览器缓存所有动态页面
            有3 个HTTP 响应头字段都可以禁止浏览器缓存当前页面，它们在 Servlet 中的示例代码如下：

    1 response.setDateHeader("Expires",-1);
    2 response.setHeader("Cache-Control","no-cache");
    3 response.setHeader("Pragma","no-cache"); 
    　　并不是所有的浏览器都能完全支持上面的三个响应头，因此最好是同时使用上面的三个响应头。
    
    Expires数据头：值为GMT时间值，为-1指浏览器不要缓存页面
    Cache-Control响应头有两个常用值：
    no-cache指浏览器不要缓存当前页面。
    max-age:xxx指浏览器缓存页面xxx秒。
    
    web.xml
  <filter>
      <filter-name>NoCacheFilter</filter-name>
      <filter-class>me.gacl.web.filter.NoCacheFilter</filter-class>
  </filter>
  
  <filter-mapping>
      <filter-name>NoCacheFilter</filter-name>
        <!--只拦截Jsp请求-->
      <servlet-name>*.jsp</servlet-name>
  </filter-mapping>

## 3、控制浏览器缓存页面中的静态资源
    有些动态页面中引用了一些图片或css文件以修饰页面效果，这些图片和css文件经常是不变化的，所以为减轻服务器的压力，可以使用filter控制浏览器缓存这些文件，以提升服务器的性能。

    web.xml
    ```
    <!-- 配置缓存过滤器 -->
       <filter>
          <filter-name>CacheFilter</filter-name>
          <filter-class>me.gacl.web.filter.CacheFilter</filter-class>
           <!-- 配置要缓存的web资源以及缓存时间，以小时为单位 -->
          <init-param>
              <param-name>css</param-name>
              <param-value>4</param-value>
          </init-param>
          <init-param>
              <param-name>jpg</param-name>
              <param-value>1</param-value>
          </init-param>
          <init-param>
              <param-name>js</param-name>
              <param-value>4</param-value>
          </init-param>
          <init-param>
              <param-name>png</param-name>
              <param-value>4</param-value>
          </init-param>
      </filter>
      <!-- 配置要缓存的web资源的后缀-->
      <filter-mapping>
          <filter-name>CacheFilter</filter-name>
          <url-pattern>*.jpg</url-pattern>
      </filter-mapping>
      
      <filter-mapping>
          <filter-name>CacheFilter</filter-name>
          <url-pattern>*.css</url-pattern>
      </filter-mapping>
      
      <filter-mapping>
          <filter-name>CacheFilter</filter-name>
          <url-pattern>*.js</url-pattern>
      </filter-mapping>
       <filter-mapping>
          <filter-name>CacheFilter</filter-name>
          <url-pattern>*.png</url-pattern>
      </filter-mapping>
    ```


## 4、实现用户自动登陆
    思路是这样的：

　　1、在用户登陆成功后，发送一个名称为user的cookie给客户端，cookie的值为用户名和md5加密后的密码。
　　2、编写一个AutoLoginFilter，这个filter检查用户是否带有名称为user的cookie来，如果有，则调用dao查询cookie的用户名和密码是否和数据库匹配，
            匹配则向session中存入user对象（即用户登陆标记），以实现程序完成自动登陆。

　　核心代码如下：

　　处理用户登录的控制器：LoginServlet

    代码：
    //如果想取消自动登录，那么可以在用户注销时删除自动登录cookie，核心代码如下：
    CancelAutoLoginServlet
    //处理用户自动登录的过滤器：AutoLoginFilter
    AutoLoginFilter
    //处理用户登录的控制器：LoginServlet
    com.family.filter.commonUse.LoginServlet