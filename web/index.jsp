<%@ page import="a.b.A" %><%--
  Created by IntelliJ IDEA.
  User: moyu
  Date: 2017/6/8
  Time: 下午11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% A a = new A();
  System.out.println("Heelo! Wsxx");%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>88 <%=a.a%></h1>
  <h1><%=a.n()%></h1>
  <h1>JSON = <%=a.json().toString()%> ssx</h1>
  ssssss$END$sss
  </body>
</html>
