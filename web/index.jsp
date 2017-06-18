<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<html>
<head>
  <%@include file="WEB-INF/template/head.jsp" %>
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

  <div class="row">
    <div class="col-md-8">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">看看有什么书吧
            <!--a.btn-link.pull-right.btn-sm#more-others(href='javascript:;' type='button',style='padding:0') 换一批--></h3>
        </div>
        <div class="panel-body">
          <div class="row">
            <c:forEach begin="0" items="${requestScope['books']}" varStatus="loop">
              <div class="col-sm-6">
                <div class="media">
                  <div class="pull-left">
                      <img src="/image/book/" alt="BK23469" style="width: 80px; height: 80px;"/>
                  </div>
                  <div style="position:relative;" class="media-body">
                    <h4 class="media-heading">${loop.current['title']}</h4>
                    <span>作者 余聪</span><br>
                    <span>价格 39元</span><br>
                    <span class="hidden-xs">上架 2016-06-18</span>
                    <a style="position:absolute;bottom:0;right:0;" href="/trade/books/BK23469" class="btn btn-primary vertical-bottom">查看</a>
                    <br>
                  </div>
                  <%--<c:when test="${loop.index}">--%>
                  <hr>
                  <%--</c:when>--%>
                </div>
              </div>
            </c:forEach>
          </div>
        </div>
      </div>
    </div>

    <div class="col-md-4 hidden-xs hidden-sm">
      <div class="panel panel-default">
        <div class="panel-heading"><h3 class="panel-title"><a data-toggle="collapse" href="#buyinfo"
                                                              aria-expanded="true">我的买书记录</a></h3></div>
        <div id="buyinfo" class="panel-collapse collapse in">
          <div class="panel-body">
            <c:choose>
              <c:when test="${sessionScope['user']!=null}">
              </c:when>
              <c:otherwise>
                <div class="text-danger">对不起，你还没有<a href="/login" class="btn-link">登录</a></div>
              </c:otherwise>
            </c:choose>
          </div>
        </div>
      </div>
      <div class="panel panel-default">
        <div class="panel-heading"><h3 class="panel-title"><a data-toggle="collapse" href="#mybooks"
                                                              aria-expanded="true">我最近上架图书</a></h3></div>
        <div id="mybooks" class="panel-collapse collapse in">
          <div class="panel-body">
            <c:choose>
              <c:when test="${sessionScope['user']!=null}">
              </c:when>
              <c:otherwise>
                <div class="text-danger">对不起，你还没有<a href="/login" class="btn-link">登录</a></div>
              </c:otherwise>
            </c:choose>
          </div>
        </div>
      </div>
    </div>
  </div>
</main>


<jsp:include page="WEB-INF/template/footer.jsp"/>
<script src="asset/js/a.min.js"></script>
</body>
</html>