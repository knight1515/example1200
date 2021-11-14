<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>Form表单</title>
    <script type="text/javascript">
        var isCommitted = false;//表单是否已经提交标识，默认为false
        function dosubmit(){
            if(isCommitted==false){
                isCommitted = true;//提交表单后，将表单是否已经提交标识设置为true
                return true;//返回true让表单正常提交
            }else{
                return false;//返回false那么表单将不提交
            }
        }
        //置灰处理
        function dosubmit2(){
            //获取表单提交按钮
            var btnSubmit = document.getElementById("submit");
            //将表单提交按钮设置为不可用，这样就可以避免用户再次点击提交按钮
            btnSubmit.disabled= "disabled";
            //返回true让表单可以正常提交
            return true;
        }
    </script>
  </head>
  
  <body>
      <form action="${pageContext.request.contextPath}/servlet/DoFormServlet" onsubmit="return dosubmit()"  method="post">
        用户名：<input type="text" name="username">
        <input type="submit" value="提交" id="submit">
    </form>
  </body>
</html>