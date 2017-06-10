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

<main class="row">
  <div class="center-block col-lg-4 col-md-5 no-float ">
    <div class="panel panel-success">
      <div class="panel-body">

        <form class="">

          <div class="form-group">
            <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i> <span
                                    class="hidden-xs"> 用户</span></span>
              <input type="text" class="form-control" placeholder="用户名" id="user"/>
            </div>
          </div>

          <div class="form-group">
            <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock"></i> <span
                                    class="hidden-xs"> 密码</span></span>
              <input type="text" class="form-control" placeholder="密码" id="pwd"/>
            </div>
          </div>

          <input type="button" class="btn btn-success pull-right" value="登录">

        </form>
      </div>
    </div>
  </div>
</main>


<jsp:include page="WEB-INF/template/footer.jsp"/>
</body>
</html>