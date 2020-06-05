地址：https://www.cnblogs.com/xdp-gacl/p/3948353.html


## 总则

    Filter接口中有一个doFilter方法，当我们编写好Filter，并配置对哪个web资源进行拦截后，WEB服务器每次在调用web资源的service方法之前，都会先调用一下filter的doFilter方法，因此，在该方法内编写代码可达到如下目的：

1 调用目标资源之前，让一段代码执行。
2 是否调用目标资源（即是否让用户访问web资源）。
3 调用目标资源之后，让一段代码执行。

    web服务器在调用doFilter方法时，会传递一个filterChain对象进来，filterChain对象是filter接口中最重要的一个对 象，它也提供了一个doFilter方法，开发人员可以根据需求决定是否调用此方法，调用该方法，则web服务器就会调用web资源的service方 法，即web资源就会被访问，否则web资源不会被访问。
    
## Filter开发步骤

Filter开发分为二个步骤：

1 编写java类实现Filter接口，并实现其doFilter方法。
2 在 web.xml 文件中使用<filter>和<filter-mapping>元素对编写的filter类进行注册，并设置它所能拦截的资源。
　　过滤器范例：
/example1200/src/com/family/filter/FilterDemo01.java

配置：
  <!--配置过滤器-->
  <filter>
      <filter-name>FilterDemo01</filter-name>
      <filter-class>com.family.filter.FilterDemo01</filter-class>
  </filter>
  
  <!--映射过滤器-->
  <filter-mapping>
      <filter-name>FilterDemo01</filter-name>
      <!--“/*”表示拦截所有的请求 -->
      <url-pattern>/*</url-pattern>
  </filter-mapping>
  
  
## 用户在配置filter时，可以使用<init-param>为filter配置一些初始化参数

代码：
    FilterInitParamDemo02
配置：
        <!--配置过滤器-->
  <filter>
      <filter-name>FilterDemo02</filter-name>
      <filter-class>FilterInitParamDemo02</filter-class>
   <!--配置FilterDemo02过滤器的初始化参数-->
       <init-param>
           <description>配置FilterDemo02过滤器的初始化参数</description>
           <param-name>name</param-name>
           <param-value>gacl</param-value>
       </init-param>
       <init-param>
           <description>配置FilterDemo02过滤器的初始化参数</description>
           <param-name>like</param-name>
           <param-value>java</param-value>
       </init-param>
  </filter>
  
  <!--映射过滤器-->
  <filter-mapping>
      <filter-name>FilterDemo02</filter-name>
      <!--“/*”表示拦截所有的请求 -->
      <url-pattern>/*</url-pattern>
  </filter-mapping>
  
## 使用Decorator模式包装request对象解决get和post请求方式下的中文乱码问题
代码：
    CharacterEncodingFilter
    /example1200/WebContent/CharacterEncodingFilter.jsp 页面：
    servlet:/example1200/src/com/family/filter/ServletDemo1.java
    
配置：
      
    <!--配置字符过滤器，解决get、post请求方式下的中文乱码问题-->
  <filter>
      <filter-name>CharacterEncodingFilter</filter-name>
      <filter-class>com.family.filter.CharacterEncodingFilter</filter-class>
  </filter>
  
  <filter-mapping>
      <filter-name>CharacterEncodingFilter</filter-name>
      <url-pattern>/*</url-pattern>
  </filter-mapping>
  
      <!-- ServletDemo1的Servlet -->
    <servlet>
        <servlet-name>ServletDemo1</servlet-name>
        <servlet-class>ServletDemo1</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>ServletDemo1</servlet-name>
        <url-pattern>/servlet/ServletDemo1</url-pattern>
    </servlet-mapping>
    
## 使用Decorator模式包装request对象实现html标签转义功能
代码：
    /example1200/src/com/family/filter/HtmlFilter.java
    /example1200/WebContent/HtmlFilter.jsp
    /example1200/src/com/family/filter/ServletDemo2.java
    
配置：
    <!--配置Html过滤器，转义内容中的html标签-->
  <filter>
      <filter-name>HtmlFilter</filter-name>
      <filter-class>HtmlFilter</filter-class>
  </filter>
  
  <filter-mapping>
      <filter-name>HtmlFilter</filter-name>
      <url-pattern>/*</url-pattern>
  </filter-mapping>
  
      <!-- ServletDemo2的Servlet -->
    <servlet>
        <servlet-name>ServletDemo2</servlet-name>
        <servlet-class>ServletDemo2</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>ServletDemo2</servlet-name>
        <url-pattern>/servlet/ServletDemo2</url-pattern>
    </servlet-mapping>
    
## 使用Decorator模式包装request对象实现敏感字符过滤功能
代码：
    /example1200/src/com/family/filter/DirtyFilter.java
    
配置：
   <!--配置敏感字符过滤器-->
  <filter>
      <filter-name>DirtyFilter</filter-name>
      <filter-class>com.family.filter.DirtyFilter</filter-class>
      <!-- 配置要过滤的敏感字符文件 -->
      <init-param>
         <param-name>dirtyWord</param-name>    
         <param-value>/WEB-INF/DirtyWord.txt</param-value>
    </init-param>
  </filter>
  
  <filter-mapping>
      <filter-name>DirtyFilter</filter-name>
      <url-pattern>/*</url-pattern>
  </filter-mapping>
    
## 具有以上三个功能

代码：
    /example1200/src/com/family/filter/AdvancedFilter.java
配置：

  <!-- AdvancedFilter过滤器同时具有解决中文乱码，转义内容中的html标签，过滤内容中的敏感字符这些功能 -->
  <filter>
      <filter-name>AdvancedFilter</filter-name>
      <filter-class>com.family.filter.AdvancedFilter</filter-class>
      <init-param>
         <param-name>charset</param-name>    
         <param-value>UTF-8</param-value>
    </init-param>
      <init-param>
         <param-name>dirtyWord</param-name>    
         <param-value>/WEB-INF/DirtyWord.txt</param-value>
    </init-param>
  </filter>
  
  <filter-mapping>
      <filter-name>AdvancedFilter</filter-name>
      <url-pattern>/*</url-pattern>
  </filter-mapping>
  
## response增强案例——压缩响应正文内容
代码：
    /example1200/src/com/family/filter/GzipFilter.java
配置：
  <filter>
       <description>Web资源缓存过滤器</description>
      <filter-name>WebResourceCachedFilter</filter-name>
      <filter-class>GzipFilter</filter-class>
  </filter>
  
  <filter-mapping>
      <filter-name>WebResourceCachedFilter</filter-name>
      <!-- 映射需要缓存输出的JSP页面，这几个页面都只是单纯作为输入UI，不会有太多的变化，因此可以缓存输出 -->
      <url-pattern>/index.jsp</url-pattern>
  </filter-mapping>
    