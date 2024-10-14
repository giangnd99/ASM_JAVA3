<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../../layout/page_header.jsp">
        <jsp:param name="title" value="Tin Tức Theo Danh Mục"/>
    </jsp:include>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        .category-title {
            background-color: #f8f9fa;
            padding: 15px;
            margin-bottom: 20px;
            border-radius: 8px;
        }
        .news-card {
            transition: transform 0.3s ease;
        }
        .news-card:hover {
            transform: translateY(-10px);
        }
        .news-image {
            height: 200px;
            object-fit: cover;
        }
        .news-description {
            color: #6c757d;
        }
    </style>
</head>
<body>

<!-- Include Header -->
<jsp:include page="../../layout/header.jsp"></jsp:include>

<div class="container my-5">
    <!-- Category Title -->
    <div class="category-title text-center">
        <h1>Tin tức trong danh mục: <span style="color: #007bff;">${categoryName}</span></h1>
    </div>

    <div class="row">
        <%-- <c:forEach items="${categoryNewsList}" var="newsItem"> --%>
        <!-- Example of one news item, repeated for each news in category -->
        <div class="col-md-4 mb-4">
            <div class="card news-card h-100 shadow-sm">
                <img src="images/news-image.jpg" class="card-img-top news-image" alt="News Image">
                <div class="card-body">
                    <h5 class="card-title">Tiêu đề bài báo</h5>
                    <p class="news-description">Tóm tắt ngắn về bài báo, thông tin nổi bật và một số nội dung chính...</p>
                    <a href="/news_detail?id=1" class="btn btn-primary">Xem thêm</a>
                </div>
            </div>
        </div>
        <%-- </c:forEach> --%>
    </div>

    <!-- Pagination (if needed) -->
    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
    </nav>
</div>

<!-- Include Footer -->
<jsp:include page="../../layout/footer.jsp"></jsp:include>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
