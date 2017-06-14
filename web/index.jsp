<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
  <%@include file="WEB-INF/template/head.jsp"%>
  <title>首页 - ${initParam["title"]}</title>
</head>
<body>
  <jsp:include page="WEB-INF/template/navbar.jsp">
    <jsp:param name="active" value="index"/>
  </jsp:include>
  <main class="container">
    <jsp:include page="WEB-INF/template/infor.jsp">
      <jsp:param name="title" value="${initParam['title']}"/>
      <jsp:param name="subTitle" value="欢迎来到${initParam['title']}！"/>
    </jsp:include>
  </main>

  <jsp:include page="WEB-INF/template/footer.jsp"/>
  <script src="asset/js/a.min.js"></script>
</body>
</html>