<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%@include file="WEB-INF/template/head.jsp" %>
  <title> 注册 </title>
</head>
<body>
<jsp:include page="WEB-INF/template/navbar.jsp">
  <jsp:param name="active" value="register"/>
</jsp:include>

<main class="container">
  <jsp:include page="WEB-INF/template/infor.jsp">
    <jsp:param name="title" value="注册吧，骚年"/>
    <jsp:param name="subTitle" value="欢迎来到${initParam['title']}！"/>
  </jsp:include>

<main class="row">
  <div class="center-block col-lg-5 col-md-6 no-float ">
    <div class="panel panel-success">
      <div class="panel-body">

        <form id="form" class="" method="post" action="/api/user/register">

          <div class="form-group">
            <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i>
                              <span class="hidden-xs">用户帐号</span>
                            </span>
              <input type="text" minlength="6" maxlength="10" class="form-control" placeholder="用户名" required name="username"/>
            </div>
          </div>

          <div class="form-group">
            <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock"></i> <span
                                    class="hidden-xs"> 输入密码</span></span>
              <input type="password" minlength="6" maxlength="10" class="form-control" placeholder="密码" id="password" required name="password"/>
            </div>
          </div>

          <div class="form-group">
            <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock"></i> <span
                                    class="hidden-xs"> 确定密码</span></span>
              <input type="password" minlength="6" maxlength="10" class="form-control" placeholder="密码确定" required name="pwd-again"/>
            </div>
          </div>

          <input type="submit" class="btn btn-success pull-right" value="注册">

        </form>
      </div>
    </div>
  </div>
</main>
</main>
<%@include file="WEB-INF/template/footer.jsp" %>
<script src="asset/js/jquery-form.min.js"></script>
<script src="asset/js/register.min.js"></script>
</body>
</html>