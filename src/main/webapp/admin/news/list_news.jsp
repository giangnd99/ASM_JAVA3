<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../../layout/page_header.jsp">
        <jsp:param name="title" value="Quản Lý Tin Tức"/>
    </jsp:include>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .header-title {
            color: #007bff;
        }

        table {
            background-color: #fff;
            width: 100%;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div class="container-lg">
    <jsp:include page="../header.jsp"></jsp:include>
    <div class="row">
        <div class="col-lg-12">
            <section class="mt-4">
                <h5 class="header-title">Danh sách tin tức</h5>
                <div class="card">
                    <div class="card-body">
                        <table class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Tiêu đề</th>
                                <th>Tác giả</th>
                                <th>Ngày đăng</th>
                                <th>Nội dung</th>
                                <th>Hành động</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="news" items="${listNews}">
                                <tr>
                                    <td>${news.id}</td>
                                    <td>${news.title}</td>
                                    <td><c:forEach var="user" items="${listUser}">
                                        <c:if test="${user.id == news.author}">
                                            ${user.fullname}
                                        </c:if>
                                    </c:forEach></td>
                                    <td><fmt:formatDate pattern='dd/MM/yyyy' value='${news.postedDate}'/></td>
                                    <td>${fn:substring(news.content, 0, 50)}...</td>
                                    <td>
                                        <a href="update_news?id=${news.id}" class="btn btn-warning btn-sm">Sửa</a>
                                        <a href="delete_news?id=${news.id}" class="btn btn-danger btn-sm"
                                           onclick="return confirm('Bạn có chắc muốn xóa tin này?');">Xóa</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <a href="create_news" class="btn btn-primary">Viết Bài Mới</a>
                    </div>
                </div>
            </section>
        </div>
    </div>
</div>

<br>
<hr>
<jsp:include page="../footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
