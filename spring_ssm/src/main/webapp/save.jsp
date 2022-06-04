<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/8/13
  Time: 下午 09:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>保持賬戶信息表單</h1>
    <form action="${pageContext.request.contextPath}/account/save" method="post">
        用户名称：<input type="text" name="name" ><br/>
        账户金额：<input type="text" name="money"><br/>
        <input type="submit" value="保存"><br/>
    </form>


</body>
</html>
