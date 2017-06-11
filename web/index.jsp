<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%@include file="WEB-INF/template/head.jsp"%>
  <title>首页 - ${initParam["title"]}</title>
</head>
<body>
  <jsp:include page="WEB-INF/template/navbar.jsp">
    <jsp:param name="active" value="index"/>
  </jsp:include>
  <h1><%=Arrays.toString((Object[]) request.getAttribute("data"))%> ss</h1>

  <jsp:include page="WEB-INF/template/footer.jsp"/>
  <script src="asset/js/a.min.js"></script>
</body>
</html>