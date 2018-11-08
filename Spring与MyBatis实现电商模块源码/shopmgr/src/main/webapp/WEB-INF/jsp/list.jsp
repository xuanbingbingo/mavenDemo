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
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/My97DatePicker/WdatePicker.js"></script>
</head>

<body>

<!-- 横幅导航条开始 -->
<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a  class="navbar-brand " style="color: red" href="<c:url value="/list?method=getAll"/>">电商系统,卖家系统-商品管理</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<c:url value="/logout"/>">退出</a></li>
            </ul>
        </div>

    </div>
</nav>
<!-- 横幅导航条结束 -->

<!--  横幅下方的主体开始 -->
<div class="container">

    <div class="row row-offcanvas row-offcanvas-right">

        <!-- 侧边导航开始
           一级类型的
        -->
        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
            <div class="list-group">
                <c:forEach items="${requestScope.firstArticleTypes }" var="type">
                    <a href="<c:url value="/list?method=getAll&typeCode=${type.code }"/>" class="list-group-item <c:if test="${type.code eq param.typeCode or top.code eq fn:substring(param.typeCode, 0, 4) }">active</c:if>">${type.name }</a>
                </c:forEach>
            </div>
        </div>
        <!--  侧边导航结束 -->
        <!-- 内容主体开始 -->
        <div class="col-xs-12 col-sm-9">
            <p class="pull-right visible-xs">
                <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">显示导航条</button>
            </p>


            <div class="alert alert-info" role="alert">
                <div>
                    <form action="<c:url value="/list?method=getAll"/>" method="post">
                        <table class="table-condensed">
                            <tbody>
                            <tr>
                                <td>
                                <select class="btn btn-default" placeholder="类型" id="secondType"
                                        name="secondType">
                                    <option value="">==请选择类型==</option>
                                    <c:forEach items="${requestScope.secondTypes }" var="t">
                                        <option value="${t.code}">${t.name}</option>
                                    </c:forEach>
                                </select>
                                </td>
                                <td>
                                <!-- 如果当前选择了商品的类型，仅在该类型下面进行搜索 -->
                                <input type="hidden" name="typeCode" value="${typeCode }" />
                                <div class="input-group">
                                    <input type="text" name="title" value="${title}"
                                           class="form-control" placeholder="搜索商品的标题" />
                                    <div class="input-group-btn">
                                        <button class="btn" type="submit">
                                            <span class="glyphicon glyphicon-search"></span>
                                        </button>
                                    </div>
                                </div>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="添加商品">添加商品</button>
                                   <span style="color: red;">${tip}</span>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>

            <!-- 展示商品数据 -->
            <div class="row">
         <c:forEach items="${articles }" var="a">
                    <div class="col-xs-6 col-lg-4">
            	<span class="thumbnail">
                    <a class="label label-danger" href="<c:url value="/list?method=deleteById&id=${a.id }&typeCode=${typeCode}&secondType=${secondType}&title=${title}"/>">删除</a>
                    <a class="label label-success" href="<c:url value="/list?method=showUpdate&id=${a.id }&typeCode=${typeCode}&secondType=${secondType}&title=${title}"/>">修改</a>
				    <a href="<c:url value="/list?method=preArticle&id=${a.id }"/>">
				      <img src="<c:url value="/resources/images/article/${a.image }"/>" alt="...">
		              <p style="height: 20px; overflow: hidden;">${a.title }</p>
				    </a>
		              <p>
		              	<span class="price">${a.price }</span>
		              	<c:if test="${not empty a.discount }">
                            <span class="discountPrice">惊爆价: <fmt:formatNumber value="${a.price * a.discount / 10 }" pattern="0.00"></fmt:formatNumber>(${a.discount }折)</span>
                        </c:if>
		              </p>
              </span>
                    </div>
                </c:forEach>
            </div>
            <div class="row"  >
                <!-- 分页标签 -->
                <nav>
                    <ul class="pagination">
                        <li><a href="${pageContext.request.contextPath}/list?method=getAll&typeCode=${typeCode}&secondType=${secondType}&title=${title}&pageIndex=1">首页</a></li>
                        <li><a href="${pageContext.request.contextPath}/list?method=getAll&typeCode=${typeCode}&secondType=${secondType}&title=${title}&pageIndex=${pager.pageIndex -1}">上一页</a></li>
                        <li><a href="${pageContext.request.contextPath}/list?method=getAll&typeCode=${typeCode}&secondType=${secondType}&title=${title}&pageIndex=${pager.pageIndex + 1}">下一页</a></li>
                        <li><a href="${pageContext.request.contextPath}/list?method=getAll&typeCode=${typeCode}&secondType=${secondType}&title=${title}&pageIndex=${pager.totalPages}">尾页</a></li>
                        <li>
                            <a>总数据量${pager.totalCount}，当前<span style="color: red;">${pager.pageIndex}</span>/${pager.totalPages}</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>

    </div>

    <hr>

    <footer>
        <p>&copy; 版权所有，欢迎借鉴</p>
    </footer>
</div>

<!-- 弹出框 -->
<div class="modal fade" id="exampleModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">添加物品</h4>
            </div>
            <div class="modal-body ">
                <div align="center">
                    <span style="color:red;"></span>
                    <form name="articleform" class="form-horizontal" action="<c:url value="/list?method=addArticle&typeCode=${typeCode}&secondType=${secondType}&title=${title} "/>" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">类型编号：</label>
                            <div class="col-sm-4">
                                <select class="form-control" name="code" id="addTypeCode">
                                    <c:forEach items="${articleTypes}" var="type">
                                        <option value="${type.code}">${type.name}</option>
                                     </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">标题：</label>
                            <div class="col-sm-4">
                                <input type=text class="form-control" name="titleStr" size="50">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">供应商：</label>
                            <div class="col-sm-4">
                                <input type=text class="form-control" name="supplier" size="50">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">地区：</label>
                            <div class="col-sm-4">
                                <input type=text class="form-control" name="locality" size="50">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">价格：</label>
                            <div class="col-sm-4">
                                <input type=text class="form-control" name="price" size="50">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">库存数量：</label>
                            <div class="col-sm-4">
                                <input type=text class="form-control" name="storage" size="50">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">上架日期：</label>
                            <div class="col-sm-4">
                                <input  class="form-control" name="putawayDate" id="putawayDate"
                                       style="width: 180px;"  type="text" class="Wdate"
                                       onclick="WdatePicker({'lang':'zh-cn','skin':'whyGreen','dateFmt':'yyyy-MM-dd HH:mm:ss'})" size="50">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">物品封面：</label>
                            <div class="col-sm-4">
                                <input type="file" class="form-control" name="image" size="40" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">书面描述：</label>
                            <div class="col-sm-6">
                                <textarea rows="5" cols="60" class="form-control" name="description"></textarea>
                            </div>
                        </div>
                        <table>
                            <tr>
                                <td><input type="submit" class="btn btn-success btn-sm" value="提交" /></td>
                                <td>&nbsp;&nbsp;<input type="button" class="btn btn-danger btn-sm" data-dismiss="modal" value="取消" /></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>


<!--  横幅下方的主体结束 -->
<!-- 一般来讲，css必须在head里面引入，因为页面加载完成，就需要显示正确的样式 -->
<!-- js一般在页面最后面加载，等页面布局都完成以后，再来处理js文件！ -->
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath }/resources/jquery/jquery.js"></script>
<script src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/taobao.js"></script>
<script type="text/javascript">
        // 等整个加载完成以后为二级类型绑定切换事件
        $(function(){
            $("#secondType").change(function(){
                    window.location = "${pageContext.request.contextPath}/list?method=getAll&typeCode=${typeCode}&secondType="+this.value;
            }) ;

            // 把二级类型选中
            $("#secondType").val("${secondType}");
        });
</script>
</body>
</html>