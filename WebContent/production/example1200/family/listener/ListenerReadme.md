讲解：https://www.cnblogs.com/xdp-gacl/p/3961929.html

## 总则
　JavaWeb中的监听器是Servlet规范中定义的一种特殊类，它用于监听web应用程序中的ServletContext, HttpSession和 ServletRequest等域对象的创建与销毁事件，以及监听这些域对象中的属性发生修改的事件。

## 自己的listener监听器代码
    位置：/example1200/src/com/family/listener/Demo1.java
    /example1200/src/com/family/listener/Person.java
    /example1200/src/com/family/listener/PersonTest.java
    
## 监听ServletContext对象的创建和销毁
    代码：/example1200/src/com/family/listener/MyServletContextListener.java
    配置：
  <!-- 注册针对ServletContext对象进行监听的监听器 -->
  <listener>
      <description>ServletContextListener监听器</description>
      <!--实现了ServletContextListener接口的监听器类 -->
      <listener-class>com.family.listener.MyServletContextListener</listener-class>
  </listener>
  
## 监听HttpSession域对象的创建和销毁
    代码：/example1200/src/com/family/listener/MyHttpSessionListener.java
    /example1200/WebContent/index.jsp
    配置：
   <!--注册针对HttpSession对象进行监听的监听器-->
   <listener>
      <description>HttpSessionListener监听器</description>
      <listener-class>com.family.listener.MyHttpSessionListener</listener-class>
  </listener>
    <!-- 配置HttpSession对象的销毁时机 -->
  <session-config>
      <!--配置HttpSession对象的1分钟之后销毁 -->
      <session-timeout>1</session-timeout>
  </session-config>
  
## 监听ServletRequest域对象的创建和销毁
    代码：/example1200/src/com/family/listener/MyServletRequestListener.java
    配置：
    
   <listener>
       <description>ServletRequestListener监听器</description>
       <listener-class>com.family.listener.MyServletRequestListener</listener-class>
   </listener>
   
## 监听ServletContext域对象的属性值变化情况
    代码：
    /example1200/src/com/family/listener/MyServletContextAttributeListener.java
    /example1200/WebContent/ServletContextAttributeListenerTest.jsp
    配置：
       <!-- ServletContext,域对象中属性的变更的事件监听器 -->
    <listener>
       <description>MyServletContextAttributeListener监听器</description>
       <listener-class>com.family.listener.MyServletContextAttributeListener</listener-class>
   </listener>
    
## ServletRequestAttributeListener和HttpSessionAttributeListener监听器范例
    代码：/example1200/src/com/family/listener/MyRequestAndSessionAttributeListener.java
    /example1200/WebContent/RequestAndSessionAttributeListenerTest.jsp
    配置：
          <!-- HttpSession,HttpServletRequest,域对象中属性的变更的事件监听器 -->
    <listener>
       <description>MyRequestAndSessionAttributeListener监听器</description>
       <listener-class>com.family.listener.MyRequestAndSessionAttributeListener</listener-class>
   </listener>
   
## 感知Session绑定的事件监听器
    实现这两个接口的类不需要 web.xml 文件中进行注册。

### 实现了HttpSessionBindingListener接口的JavaBean对象可以感知自己被绑定到Session中和 Session中删除的事件
    代码：/example1200/src/com/family/listener/JavaBeanSession.java
    /example1200/WebContent/JavaBeanSession.jsp
    
### 实现了HttpSessionActivationListener接口的JavaBean对象可以感知自己被活化(反序列化)和钝化(序列化)的事件
    代码：/example1200/src/com/family/listener/JavaBeanSession2.java
    /example1200/WebContent/JavaBeanSession2.jsp
    配置：
    /example1200/WebContent/META-INF/context.xml
    
 <Context>
     <Manager className="org.apache.catalina.session.PersistentManager" maxIdleSwap="1">
     <Store className="org.apache.catalina.session.FileStore" directory="gacl"/>
     </Manager>
 </Context>


