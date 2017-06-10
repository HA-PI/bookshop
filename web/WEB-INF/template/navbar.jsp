<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <li class="${param['active'] == 'login' ? 'active': ''}"><a href="/login.jsp">登录</a></li>
        <li class="${param['active'] == 'register' ? 'active': ''}"><a href="/register.jsp">注册</a></li>
      </ul>
    </div>
  </div>
</nav>