<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <jsp:include page="../../layout/page_header.jsp"/>
    <link rel="stylesheet" href="../../css/new-detail.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Roboto', sans-serif;
            color: #333;
            font-size: 1.2rem;
        }

        main {
            margin-top: 30px;
            margin-bottom: 30px;
        }

        h1 {
            font-size: 2.7rem;
            font-weight: 700;
            color: #333;
        }

        h3 {
            font-size: 1.4rem;
            color: #007bff;
        }

        .article-meta {
            margin-bottom: 20px;
            color: #6c757d;
        }

        img {
            max-width: 100%;
            height: auto;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-bottom: 40px;
        }

        p {
            font-size: 1.3rem;
            line-height: 2rem;
            margin-bottom: 30px;
        }

        .comment-section {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            margin-top: 30px;
        }

        .comment-form textarea {
            border-radius: 5px;
            border: 1px solid #ced4da;
            margin-bottom: 20px;
            width: 100%;
        }

        .comment-form button {
            display: block;
            width: 100%;
            padding: 10px;
        }

        .comment {
            border-bottom: 1px solid #e9ecef;
            padding: 15px 0;
            margin-bottom: 20px;
        }

        .related-news ul {
            padding-left: 0;
        }

        .related-news ul li {
            list-style-type: none;
            margin-bottom: 20px;
        }

        .related-news ul li a {
            text-decoration: none;
            font-size: 1.2rem;
            color: #007bff;
            transition: color 0.3s ease;
        }

        .related-news ul li a:hover {
            text-decoration: underline;
            color: #0056b3;
        }
    </style>
</head>
<body>
<jsp:include page="../../layout/header.jsp"/>

<main>
    <div class="container">
        <div class="row">
            <!-- Nội dung bài báo (65%) -->
            <section class="col-md-8">
                <article>
                    <h1>${news.title}</h1>
                    <div class="article-meta">
                        <h3>Tác giả: ${user.fullname}</h3>
                        <h3>Ngày đăng: <fmt:formatDate pattern='dd/MM/yyyy' value='${news.postedDate}'/></h3>
                    </div>
                    <img class="img-fluid" src="${pageContext.request.contextPath}/images/${news.image}"
                         alt="Hình ảnh bài báo">
                    <p>${news.content}</p>
                </article>

                <!-- Bình luận -->
                <div class="comment-section">
                    <h3>Bình luận</h3>
                    <form class="comment-form" action="submitComment" method="post">
                        <textarea class="form-control" rows="3" name="content"
                                  placeholder="Viết bình luận của bạn..."></textarea>
                        <button type="submit" class="btn btn-primary mt-3">Gửi bình luận</button>
                    </form>
                    <div class="comments mt-4">
                        <c:forEach var="comment" items="${comments}">
                            <div class="comment">
                                <p><strong>${comment.username}:</strong> ${comment.content}</p>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </section>

            <!-- Cột tin tức cùng loại (30%) -->
            <aside class="col-md-4 related-news">
                <h3>Tin cùng loại</h3>
                <ul>
                    <c:forEach var="relatedNews" items="${relatedNewsList}">
                        <li><a href="news_detail?id=${relatedNews.id}">${relatedNews.title}</a></li>
                    </c:forEach>
                </ul>
            </aside>
        </div>
    </div>
</main>

<jsp:include page="../../layout/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
