<%--
  Created by IntelliJ IDEA.
  User: Lam
  Date: 25/09/2024
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý  loại tin</title>
</head>
<body>
<div class="container">
    <h2>Quản lý loại tin</h2>
    <form action="CategoryServlet?action=create" method="post">
        <label for="name">Tên loại tin:</label>
        <input type="text" id="name" name="name">
        <button type="submit">Tạo loại tin</button>
    </form>
    <h3>Danh sách loại tin</h3>
    <table class="table">
        <thead>
        <tr>
            <th>Tên</th>
            <th>Chỉnh sửa</th>
            <th>Xóa</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${categoryList}">
            <tr>
                <td>${category.name}</td>
                <td><a href="CategoryServlet?action=edit&id=${category.id}">Sửa</a></td>
                <td><a href="CategoryServlet?action=delete&id=${category.id}">Xóa</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
