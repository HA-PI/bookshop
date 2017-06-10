<%@ page import="a.b.A" %>
<%@ page import="net.sf.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% A a = new A();
  System.out.println("Heelo! Wsxx");%>
<html>
<head>
  <%@include file="WEB-INF/template/head.jsp"%>
  <title>Index</title>
</head>
<body>
  <jsp:include page="WEB-INF/template/navbar.jsp">
    <jsp:param name="active" value="index"/>
  </jsp:include>


  <jsp:include page="WEB-INF/template/footer.jsp"/>
</body>
</html>