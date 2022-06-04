<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/8/13
  Time: 下午 10:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>展示賬戶數據列表</h1>
<table border="1">
    <tr>
        <th>賬戶id</th>
        <th>賬號名稱</th>
        <th>賬戶金額</th>
    </tr>
    <c:forEach items="${accountList}" var="account">
        <tr>
            <th>${account.id}</th>
            <th>${account.name}</th>
            <th>${account.money}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
