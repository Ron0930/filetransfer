<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h1>文件上传</h1>
<form method="POST" action="upload" enctype="multipart/form-data" accept-charset="UTF-8">
    <input type="file" name="file" />
    <button type="submit">Upload</button>
</form>
<p>${message}</p>
</body>
</html>
