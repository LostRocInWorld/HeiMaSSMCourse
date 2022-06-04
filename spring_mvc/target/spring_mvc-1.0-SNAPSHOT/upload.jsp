<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/7/23
  Time: 上午 03:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/user/quick21" method="post">
    名称：<input type="text" name="username"><br/>
    上传的文件1：<input type="file" name="upload" ><br/>
    上传的文件2：<input type="file" name="upload"><br/>
    上传的文件3：<input type="file" name="upload" ><br/>
    上传的文件4：<input type="file" name="upload"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
