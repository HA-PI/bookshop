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
<main class="row">
  <div class="center-block col-sm-6 no-float ">
    <div class="panel panel-success">
      <div class="panel-body">

        <form class="">

          <div class="form-group">
            <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i> <span
                                    class="hidden-xs">用户帐号</span></span>
              <input type="text" class="form-control" placeholder="用户名" id="user"/>
            </div>
          </div>

          <div class="form-group">
            <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock"></i> <span
                                    class="hidden-xs"> 输入密码</span></span>
              <input type="text" class="form-control" placeholder="密码" id="pwd"/>
            </div>
          </div>

          <div class="form-group">
            <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock"></i> <span
                                    class="hidden-xs"> 确定密码</span></span>
              <input type="text" class="form-control" placeholder="密码确定" id="pwd-again"/>
            </div>
          </div>

          <input type="button" class="btn btn-success pull-right" value="注册">

        </form>
      </div>
    </div>
  </div>
</main>
</main>

<%@include file="WEB-INF/template/footer.jsp" %>
</body>
</html>