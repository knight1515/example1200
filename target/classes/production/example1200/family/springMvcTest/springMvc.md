## 

代码：
    /example1200/src/com/family/springMvcTest/AnnotationHandleServlet.java
配置：
    <servlet>
    <servlet-name>AnnotationHandleServlet</servlet-name>
    <servlet-class>com.family.springMvcTest.AnnotationHandleServlet</servlet-class>
    <init-param>
         <description>配置要扫描包及其子包, 如果有多个包,以逗号分隔</description>
        <param-name>basePackage</param-name>
        <param-value>com.family.springMvcTest</param-value>
        <!-- <param-value>me.gacl.web.controller</param-value> -->
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>

  <servlet-mapping>
    <servlet-name>AnnotationHandleServlet</servlet-name>
    <!-- 拦截所有以.do后缀结尾的请求 -->
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>