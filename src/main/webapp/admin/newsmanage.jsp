<%--
  Created by IntelliJ IDEA.
  User: Lam
  Date: 25/09/2024
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý tin tức</title>
</head>
<body>
<div class="container">
    <h2>Quản lý tin tức</h2>
    <form action="?action=create" method="post">
        <label for="title">Tiêu đề:</label>
        <input type="text" id="title" name="title">

        <label for="content">Nội dung:</label>
        <textarea id="content" name="content"></textarea>

        <button type="submit">Tạo tin tức</button>
    </form>

    <h3>Danh sách tin tức</h3>
    <table class="table">
        <thead>
        <tr>
            <th>Tiêu đề</th>
            <th>Nội dung</th>
            <th>Chỉnh sửa</th>
            <th>Xóa</th>
        </tr>
        </thead>
        <tbody>
        <%-- Dùng EL để hiển thị danh sách tin tức --%>
        <c:forEach var="news" items="${newsList}">
            <tr>
                <td>${news.title}</td>
                <td>${news.content}</td>
                <td><a href="NewsServlet?action=edit&id=${news.id}">Sửa</a></td>
                <td><a href="NewsServlet?action=delete&id=${news.id}">Xóa</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
