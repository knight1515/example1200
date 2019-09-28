<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.family.listener.JavaBeanSession2"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title></title>
  </head>
  
  <body>
      一访问JSP页面，HttpSession就创建了，创建好的Session的Id是：${pageContext.session.id}
       <hr/>
   <% 
        session.setAttribute("bean",new JavaBeanSession2("孤傲苍狼"));
    %>
  </body>
</html>