<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.List" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Kết quả tìm kiếm</title>
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Roboto', sans-serif;
        }

        .container {
            margin-top: 30px;
        }

        h1 {
            font-size: 2rem;
            color: #333;
        }

        .result-section {
            margin-top: 20px;
        }

        .no-results {
            margin-top: 20px;
            font-size: 1.2rem;
            color: #6c757d;
        }
    </style>
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
<div class="container">

    <h1>Kết quả tìm kiếm cho: <c:out value="${keyword}"/></h1>

    <div class="result-section">
        <h3>Tin tức:</h3>
        <c:if test="${not empty resultNews}">
            <ul class="list-group">
                <c:forEach var="news" items="${resultNews}">
                    <li class="list-group-item">
                        <a href="news_detail?id=${news.id}" class="text-decoration-none">${news.title}</a>
                        <div>${fn:substring(news.content, 0, 100)}...</div>
                        <small class="text-muted">Ngày đăng: <fmt:formatDate value="${news.postedDate}"
                                                                             pattern="dd/MM/yyyy"/></small>
                    </li>
                </c:forEach>
            </ul>
        </c:if>
        <c:if test="${empty resultNews}">
            <div class="no-results">Không tìm thấy tin tức nào phù hợp.</div>
        </c:if>
    </div>

    <div class="result-section">
        <h3>Danh mục:</h3>
        <c:if test="${not empty resultCategories}">
            <ul class="list-group">
                <c:forEach var="category" items="${resultCategories}">
                    <li class="list-group-item">
                        <a href="category?id=${category.id}" class="text-decoration-none">${category.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </c:if>
        <c:if test="${empty resultCategories}">
            <div class="no-results">Không tìm thấy danh mục nào phù hợp.</div>
        </c:if>
    </div>

    <a href="${pageContext.request.contextPath}" class="btn btn-primary mt-4">Quay lại tìm kiếm</a>

</div>
<jsp:include page="../layout/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
