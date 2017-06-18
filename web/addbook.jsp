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
    <jsp:param name="title" value="添加图书" />
    <jsp:param name="subTitle" value="图书添加后可以被销售" />
  </jsp:include>

  <div class="row">
    <div class="center-block col-lg-8 col-md-8 no-float ">
      <div class="panel panel-default">
        <div class="panel-body">
          <div role="alert" id="alert" class="alert alert-success" style="display: none;">
            <button data-dismiss="alert" aria-label="Close" class="close"><span aria-hidden="true">×</span></button>
            <span role="text"></span>
          </div>
          <form id="form" action="/api/book/add" method="post" enctype="multipart/form-data" class="form-horizontal">
            <div class="form-group">
              <label for="name" class="col-sm-2 control-label">书名</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" placeholder="书名" id="name" name="name" required/>
              </div>
            </div>
            <div class="form-group">
              <label for="author" class="col-sm-2 control-label">作者</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" placeholder="作者" id="author" name="author" required/>
              </div>
            </div>
            <div class="form-group">
              <label for="press" class="col-sm-2 control-label">出版社</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" placeholder="出版社" id="press" name="press" required/>
              </div>
            </div>
            <div class="form-group">
              <label for="price" class="col-sm-2 control-label">价格</label>
              <div class="col-sm-10">
                <div class="input-group">
                <input type="number" class="form-control" min="0" step="0.1" placeholder="价格" id="price" name="price"
                       required/>
                <span class="input-group-addon">元</span>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label for="number" class="col-sm-2 control-label">数量</label>
              <div class="col-sm-10">
                <div class="input-group">
                <input type="number" class="form-control" min="0" step="1" placeholder="数量" id="number" name="number"
                       required/>
                <span class="input-group-addon">个</span>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label for="img" class="col-sm-2 control-label">封面</label>
              <div class="col-sm-5">
                <input type="file" class="form-control" id="img" name="img" accept="image/*" required/>
              </div>
              <div class="col-sm-5">
                <img id="thumbnail" src="" alt="">
              </div>
            </div>

            <div class="col-sm-offset-2 col-sm-10">
              <div class="text-right"><input type="submit" value="确认" class="btn btn-primary"></div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</main>


<jsp:include page="WEB-INF/template/footer.jsp"/>
<script src="asset/js/jquery-form.min.js"></script>
<script src="asset/js/addbook.min.js"></script>
</body>
</html>