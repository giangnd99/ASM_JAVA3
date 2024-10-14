<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <jsp:include page="../../layout/page_header.jsp"></jsp:include>
    <link rel="stylesheet" href="../../css/new-detail.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
            color: #333;
        }

        main {
            margin-top: 20px;
            margin-bottom: 20px;
        }

        article h1 {

            margin-bottom: 20px;
        }

        article h3 {
            font-size: 1rem;
            color: #007bff;
        }

        img {
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }

        .comment-section {
            background-color: #fff;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .comment-form textarea {
            border-radius: 5px;
            border: 1px solid #ced4da;
        }

        .comment {
            border-bottom: 1px solid #e9ecef;
            padding: 10px 0;
        }

        .comment:last-child {
            border: none;
        }

        aside {
            background-color: #fff;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        aside h3 {
            margin-bottom: 15px;
        }

        aside ul li {
            margin-bottom: 10px;
        }

        aside ul li a {
            text-decoration: none;
            color: #007bff;
        }

        aside ul li a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<jsp:include page="../../layout/header.jsp"/>

<main>
    <div class="row">
        <!-- Nội dung bài báo (80%) -->
        <section class="col-md-8">
            <article>
                <h1>Tiêu đề bài báo: ${news.title}</h1>
                <h3>Tác giả: ${news.author}</h3>
                <h3>Ngày đăng: <fmt:formatDate pattern='dd/MM/yyyy' value='${news.postedDate}'/></h3>
                <img class="img-fluid" src="${pageContext.request.contextPath}/images/${news.image}" alt="Hình ảnh bài báo">
                <p>${news.content}</p>
            </article>
        </section>

        <!-- Cột tin tức cùng loại (20%) -->
        <aside class="col-md-4 mb-4">
            <h3>Tin cùng loại</h3>
            <ul class="list-unstyled">
                <c:forEach var="relatedNews" items="${relatedNewsList}">
                    <li><a href="news_detail?id=${relatedNews.id}">${relatedNews.title}</a></li>
                </c:forEach>
            </ul>
        </aside>
    </div>
</main>

<jsp:include page="../../layout/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
