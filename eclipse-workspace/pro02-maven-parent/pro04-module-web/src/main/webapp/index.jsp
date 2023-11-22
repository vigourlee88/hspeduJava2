<%@ page import="com.atguigu.maven.Message" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/2/17
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%=new Message().getMessage() %>
</body>
</html>