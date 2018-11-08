<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登陆</title>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet" />

    <link href="${pageContext.request.contextPath }/resources/css/taobao.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath }/resources/jquery/jquery.js"></script>
    <script type="text/javascript">
        $(function(){

            // 给登录按钮绑定点击事件
            $("#loginBtn").click(function(){
                var loginName = $("#loginName").val();
                var passWord = $("#passWord").val() ;
                // 定义一个变量存储校验信息
                var msg  = "" ;
                if(!/^\w{5,}$/.test(loginName)){
                    msg = "登录名必须5个字符以上";
                }else if(!/^\w{6,}$/.test(passWord)){
                    msg = "请输入6位以上合法的密码";
                }

                if(msg!=""){
                    // 触发弹出框
                    $('#myModal').modal('show');
                    $("#tip").html("<span style='color:red;'>"+msg+"</span>");
                    return;
                }
                // 提交表单
                $(".form-horizontal").submit();
            });
        })
    </script>

</head>

<body>
<%-- 	<jsp:include page="/WEB-INF/jsp/commons/banner.jsp"></jsp:include> --%>
<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value="/shop/index.action"/>">电商系统,卖家系统-商品管理</a>
        </div>
    </div>
</nav>

<!--  横幅下方的主体开始 -->
<div class="container text-center">
    <!-- 入门-->
    <!-- 登录界面 -->
    <div class="page-header">
        <h1>用户登录</h1>
    </div>
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath }/login?method=login">
        <div style="color: red;">${msg}</div>
        <div class="form-group">
            <div class="col-sm-4 col-sm-push-4">
                <input class="form-control" value="${loginName }" placeholder="用户名/邮箱"  type="text"  id="loginName" name="loginName"/>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-4 col-sm-push-4">
                <input class="form-control" placeholder="密码" id="passWord"  type="password" name="passWord"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-4 col-sm-push-4">
                <span style="color: red;">${result}</span>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-4 col-sm-push-4">
                <div class="btn-group btn-group-justified" role="group" aria-label="...">
                    <div class="btn-group" role="group">
                        <button type="button" id="loginBtn" class="btn btn-success">
                            <span class="glyphicon glyphicon-log-in"></span>&nbsp;登录</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-edit"></span>注册</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <hr>

    <!-- 彈出框-->
    <div id="myModal" class="modal bs-example-modal-sm fade">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" ><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">登录提示</h4>
                </div>
                <div class="modal-body">
                    <p id="tip"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button id="sure" type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
                </div>
            </div>
        </div>
    </div>

    <footer>
        <p>&copy; 版权所有，欢迎借鉴</p>
    </footer>

</div><!--/.container-->
<!--  横幅下方的主体结束 -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

<script src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap.js"></script>

<script src="${pageContext.request.contextPath }/resources/js/taobao.js"></script>
</body>
</html>