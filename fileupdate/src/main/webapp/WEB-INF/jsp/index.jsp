<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>hello</title>
</head>

<body>
<h1>加油！</h1>
</body>
<body>
<form action="${pageContext.request.contextPath}/registerServlet" method="post" enctype="multipart/form-data">
    姓名：<input type="text" name="name"/><br>
    年龄：<input type="text" name="age"/><br>
    附件：<input type="file" name="appendix"/><br>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
