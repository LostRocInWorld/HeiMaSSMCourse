<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/7/22
  Time: 下午 09:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick14" method="post">
<%--        表明是第几个user对象的username,age--%>
    第一个用户username：<input type="text" name="userList[0].username"/><br/>
    第一个用户age：<input type="text" name="userList[0].age"/><br/>
    第二个用户username：<input type="text" name="userList[1].username"/><br/>
    第二个用户age：<input type="text" name="userList[1].age"/><br/>
    <input type="submit" value="提交"/>
    </form>
</body>
</html>
