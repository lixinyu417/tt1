<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/11 0011
  Time: 上午 3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>msg数据：${param.myname}</h3>  <%--这是用的 jsp的EL表达式--%>
<h3>fun数据：${param.myage}</h3>  <%--当使用重定向时，容易搞错request作用域--%>
<h3>取参数数据：<%=request.getParameter("myname")%></h3>

</body>
</html>
