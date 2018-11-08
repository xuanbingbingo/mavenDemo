<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>商品首页</title>
    <!-- Bootstrap core CSS -->
    <%-- c:url 标签的作用：
    	1.自动在URL的前面加上context path
    	2.如果客户端禁用了Cookie，自动使用URL重写技术，把jsessionid放到url的分号后面
    	/taobao/resources/bootstrap/css/bootstrap.css;jsessionid=xxxxx
     --%>
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/resources/css/taobao.css" rel="stylesheet" />

</head>

<body>

<!-- 横幅导航条开始 -->
<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value="/list?method=getAll"/>">电商系统,卖家系统-商品管理</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<c:url value="/logout"/>">退出</a></li>
            </ul>
        </div>

    </div>
</nav>
<!-- 横幅导航条结束 -->

<div class="container">

    <div class="row row-offcanvas row-offcanvas-right">
        <fieldset style="width:700px;"><legend>修改物品</legend>
            <span style="color: red">${tip}</span>
            <form name="articleform" class="form-horizontal" action="${pageContext.request.contextPath}/list?method=updateArticle"
                  method="post" enctype="multipart/form-data">
                <!-- 隐藏表单用来传输要修改的物品编号 -->
                <input type="hidden" name="id" value="${article.id}"/>
                <!-- 保留商品当前的图片地址：如果不修改图片依然会使用这个图片地址 -->
                <input type="hidden" name="picUrl" value="${article.image}"/>

                <div class="form-group">
                    <label class="col-sm-3 control-label">类型编号：</label>
                    <div class="col-sm-3">
                        <select value   class="form-control" name="code" id="addTypeCode">
                            <c:forEach items="${types}" var="type">
                                <option value="${type.code}">${type.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <label class="col-sm-3 control-label">标题：</label>
                    <div class="col-sm-3">
                        <input type=text value="${article.title}" class="form-control" name="titleStr" size="50">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">供应商：</label>
                    <div class="col-sm-3">
                        <input type=text value="${article.supplier}" class="form-control" name="supplier" size="50">
                    </div>
                    <label class="col-sm-3 control-label">地区：</label>
                    <div class="col-sm-3">
                        <input type=text class="form-control" value="${article.locality}" name="locality" size="50">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">价格：</label>
                    <div class="col-sm-3">
                        <input type=text class="form-control" value="${article.price}" name="price" size="50">
                    </div>
                    <label class="col-sm-3 control-label">库存数量：</label>
                    <div class="col-sm-3">
                        <input type=text class="form-control" value="${article.storage}" name="storage" size="50">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">上架日期：</label>
                    <div class="col-sm-3">
                        <input type=text class="form-control" value="${article.putawayDate}" name="putawayDate" id="putawayDate" size="50">
                    </div>
                    <label class="col-sm-3 control-label">物品封面：</label>
                    <div class="col-sm-3">
                        <input type="file" class="form-control"  name="image" size="40" />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">书面描述：</label>
                    <div class="col-sm-6">
                        <textarea rows="5" cols="60"  class="form-control" name="description">${article.description}</textarea>
                    </div>
                </div>
                <table align="center">
                    <tr>
                        <td><input type="submit" class="btn btn-success btn-sm" value="提交" /></td>
                        <td>&nbsp;&nbsp;<input type="button" onclick="window.location = 'list?method=getAll' ; " class="btn btn-danger btn-sm" data-dismiss="modal" value="返回" /></td>
                    </tr>
                </table>
            </form>
        </fieldset>
            </div>
    </div>
    <hr>

</div>
<script src="${pageContext.request.contextPath }/resources/jquery/jquery.js"></script>
<script src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/taobao.js"></script>
<script type="text/javascript">
    $(function(){
         $("#addTypeCode").val("${article.articleType.code}");
    });

</script>
</body>
</html>