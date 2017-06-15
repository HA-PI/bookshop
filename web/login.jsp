<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%@include file="WEB-INF/template/head.jsp" %>
  <title> 登录 </title>
</head>
<body>
<jsp:include page="WEB-INF/template/navbar.jsp">
  <jsp:param name="active" value="login"/>
</jsp:include>

<main class="container">
  <jsp:include page="WEB-INF/template/infor.jsp">
    <jsp:param name="title" value="登录吧，骚年"/>
    <jsp:param name="subTitle" value="欢迎来到${initParam['title']}！"/>
  </jsp:include>

  <main class="row">
  <div class="center-block col-lg-4 col-md-5 no-float ">
    <div class="panel panel-success">
      <div class="panel-body">

        <form id="form" class="" method="get" action="/api/user/login">

          <div class="form-group">
            <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i> <span
                                    class="hidden-xs"> 用户</span></span>
              <input type="text" name="username" class="form-control" placeholder="用户名" maxlength="10" minlength="6" />
            </div>
          </div>

          <div class="form-group">
            <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock"></i> <span
                                    class="hidden-xs"> 密码</span></span>
              <input type="password" class="form-control" maxlength="10" minlength="6" placeholder="密码" name="password"/>
            </div>
          </div>

          <input type="submit" class="btn btn-success pull-right" value="登录">

        </form>
      </div>
    </div>
  </div>
</main>
</main>


<jsp:include page="WEB-INF/template/footer.jsp"/>
<script src="asset/js/jquery-form.min.js"></script>
<script src="asset/js/login.min.js"></script>
</body>
</html>