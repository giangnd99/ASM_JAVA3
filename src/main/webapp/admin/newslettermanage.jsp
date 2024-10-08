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
    <title>Newsletter Manage</title>
</head>
<body>
<div class="container">
    <h2>Quản lý Newsletter</h2>
    <form action="NewsletterServlet?action=create" method="post">
        <label for="email">Email đăng ký:</label>
        <input type="email" id="email" name="email" required>
        <button type="submit">Thêm Email</button>
    </form>
    <h3>Danh sách email đăng ký</h3>
    <table class="table">
        <thead>
        <tr>
            <th>Email</th>
            <th>Hủy đăng ký</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="newsletter" items="${newsletterList}">
            <tr>
                <td>${newsletter.email}</td>
                <td><a href="NewsletterServlet?action=delete&id=${newsletter.id}">Hủy</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
