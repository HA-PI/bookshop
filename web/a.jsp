<%@ page import="net.sf.json.JSONObject" %>
<%@ page import="a.b.Name, a.b.A" %>
<%--
  Created by IntelliJ IDEA.
  User: moyu
  Date: 2017/6/8
  Time: 下午11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>AAA</title>
  </head>
  <body>
  <%
    JSONObject obj = new JSONObject();
    obj.put("k", new Name("是啥啦啦ww啦啦xx", "b"));
  %>
  <h2><%=new Name("0ssssss8s8pp", "b")%></h2>
  <h2><%=new A().a%>pwpwpwpwxxxxwwssspppxww</h2>
  <h1><%=obj%></h1>
  </body>
</html>
