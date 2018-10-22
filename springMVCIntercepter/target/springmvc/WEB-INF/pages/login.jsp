<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/26
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>

    <h1>登录页面</h1>
    <div>
        <form action="logined" method="post">
            <p>账户：<input type="text" name="account"></p>
            <p>密码：<input type="password" name="password"></p>
            <p><input type="submit" value="登录"></p>
        </form>
    </div>
</body>
</html>
