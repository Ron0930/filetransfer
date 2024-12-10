<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Download Files</title>
</head>
<body>
<h1>Download Files</h1>

<!-- 如果文件列表不为空，则显示文件 -->
<c:if test="${not empty files}">
    <ul>
        <!-- 遍历文件数组，显示每个文件名 -->
        <c:forEach var="file" items="${files}">
            <li>
                <a href="/download-file?filename=${file.getName()}">${file.getName()}</a>
            </li>
        </c:forEach>
    </ul>
</c:if>

<!-- 如果没有文件，则显示消息 -->
<p>${message}</p>
</body>
</html>
