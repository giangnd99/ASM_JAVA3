<%--
  Created by IntelliJ IDEA.
  User: Lam
  Date: 25/09/2024
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý user</title>
</head>
<body>
<div class="container">
    <h2>Quản lý người dùng</h2>
    <form action="" method="post">
        <label for="username">Tên đăng nhập:</label>
        <input type="text" id="username" name="username" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <label for="role">Vai trò:</label>
        <select id="role" name="role">
            <option value="user">User</option>
            <option value="admin">Admin</option>
        </select>

        <button type="submit">Tạo người dùng</button>
    </form>

    <h3>Danh sách người dùng</h3>
    <table class="table" style="border:1px solid">
        <thead>
        <tr>
            <th>Tên đăng nhập</th>
            <th>Email</th>
            <th>Vai trò</th>
            <th>Chỉnh sửa</th>
            <th>Xóa</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.role}</td>
                <td><a href="UserServlet?action=edit&id=${user.id}">Sửa</a></td>
                <td><a href="UserServlet?action=delete&id=${user.id}">Xóa</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
