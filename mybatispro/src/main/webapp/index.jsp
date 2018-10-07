<%@ page import="java.util.List" %>
<%@ page import="com.bingo.entity.Users" %><%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2018/10/7
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理中心</title>
    <link rel="stylesheet" href="lib/bootstrap-3.3.7/css/bootstrap.min.css">
    <script
            src="https://code.jquery.com/jquery-2.2.4.min.js"
            integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
            crossorigin="anonymous"></script>
    <script src="lib/bootstrap-3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
    <%--<%!--%>
        <%--List usersList1;--%>

    <%--%>--%>
    <%--<%--%>
        <%--System.out.println("abcd");--%>
        <%--System.out.println(request.getAttribute("usersList").toString());--%>
        <%--usersList1 = (List) request.getAttribute("usersList");--%>

    <%--%>--%>
    <%

    %>
    <div class="container">
        <div class="row">
            <div class="page-header">
                <h1>后台管理系统 <small>用户数据管理中心</small></h1>
            </div>
        </div>
        <div class="row">
            <div class="jumbotron">
                <h1>Mybatis基础入门课程</h1>
                <p>通过一个项目来完成基础部分的学习</p>
                <p><a href="#" class="btn btn-primary btn-lg" role="button">查看更多</a></p>
            </div>
        </div>
        <div class="row">
            <table class="table table-striped table-hover">
                <tr>
                    <th>用户编号</th>
                    <th>登陆账号</th>
                    <th>用户昵称</th>
                    <%--<th>用户年龄</th>--%>
                    <th>用户性别</th>
                    <th>邮箱</th>
                    <th>联系方式</th>
                    <th>账号创建时间</th>
                    <%--<th>最后修改时间</th>--%>
                    <%--<th>最后登陆时间</th>--%>
                    <th>用户状态</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="user" items="${sessionScope.usersList}">
                <tr>
                    <td>${user.id}</td>
                    <td>admin</td>
                    <td>xiaobin</td>
                    <%--<td>18</td>--%>
                    <td>男</td>
                    <td>xiaobin@qq.com</td>
                    <td>12838282828</td>
                    <td>2018-09-20</td>
                    <%--<td>2018-09-20</td>--%>
                    <%--<td>2018-09-20</td>--%>
                    <td>正常</td>
                    <td>
                        <a href="">查看</a>
                        <a href="">修改</a>
                        <a href="">删除</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
