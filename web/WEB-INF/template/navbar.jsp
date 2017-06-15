<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <a href="/" class="navbar-brand text-muted">LOGO</a>
      <button data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"
              class="navbar-toggle collapsed"><span class="sr-only">Toggle navigation</span><span
              class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li class="${param['active'] == 'index' ? 'active': ''}"><a href="/">首页</a></li>
        <li><a href="">2</a></li>
        <li><a href="">3</a></li>
      </ul>


      <ul class="nav navbar-nav navbar-right">
        <c:choose>
          <c:when test="${sessionScope['user']!=null}">
            <%--<li></li>--%>
            <div class="navbar-form">
              <a class="text-muted" style="margin-right: 10px;" href="/user">
                <i class="fa fa-user-circle"></i> ${sessionScope['user'].username}
              </a>
              <button class="btn btn-sm btn-danger" id="logout-btn" href="javascript:;">
                登出 <i class="fa fa-sign-out"></i>
              </button>
            </div>
          </c:when>
          <c:otherwise>
            <li class="${param['active'] == 'login' ? 'active': ''}"><a href="/login.jsp">登录</a></li>
            <li class="${param['active'] == 'register' ? 'active': ''}"><a href="/register.jsp">注册</a></li>
          </c:otherwise>
        </c:choose>

      </ul>
    </div>
  </div>
</nav>