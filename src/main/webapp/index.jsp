<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="layout/page_header.jsp">
        <jsp:param name="title" value="Trang chủ tin tức"/>
    </jsp:include>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            background-color: #f4f5f7;
            font-family: 'Roboto', sans-serif;
            transition: background-color 0.3s ease-in-out;
        }

        h1, h2 {
            color: #003366;
            font-weight: bold;
            transition: color 0.3s ease-in-out;
        }

        h1:hover, h2:hover {
            color: #0056b3;
        }

        /* Card Styles */
        .custom-card {
            background-color: white; /* Set a white background for cards */
            border-radius: 8px; /* Round the corners */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Add a subtle shadow */
            transition: transform 0.3s ease-in-out;
            overflow: hidden; /* Hide overflow for better layout */
        }

        .custom-card:hover {
            transform: scale(1.03); /* Slightly scale on hover */
        }

        .card-title, .text-primary {
            color: #ff6347 !important;
            transition: color 0.3s ease-in-out;
        }

        .card-title:hover {
            color: #e60023;
        }

        .card-text {
            color: #5a5a5a;
            font-size: 1rem;
            line-height: 1.5;
        }

        /* Button Styles */
        .btn-primary {
            background-color: #17a2b8;
            border-color: #17a2b8;
            position: relative;
            transition: background-color 0.3s ease-in-out, transform 0.3s ease-in-out;
        }

        .btn-primary:hover {
            background-color: #138496;
            transform: scale(1.05);
        }

        /* Image Styles */
        img {
            object-fit: cover;
            border-radius: 8px;
            transition: transform 0.3s ease-in-out, box-shadow 0.3s ease-in-out;
        }

        img:hover {
            transform: scale(1.1);
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);
        }

        /* Specific Styles for News Card */
        .custom-card {
            height: auto; /* Auto height to fit content */
            max-height: 120px; /* Maximum height of the card */
        }

        .custom-card img {
            height: 80px; /* Set image height */
            object-fit: cover; /* Maintain aspect ratio */
        }

        .custom-card .card-body {
            padding: 10px; /* Reduce padding */
        }

        .custom-card .card-title {
            font-size: 16px; /* Title size */
            margin-bottom: 5px; /* Margin below title */
        }

        .custom-card .card-text {
            font-size: 14px; /* Summary text size */
            line-height: 1.2; /* Line height */
            height: 50px; /* Max height for text */
            overflow: hidden; /* Hide overflow */
        }

        .custom-card .btn {
            font-size: 12px; /* Button text size */
            padding: 5px 10px; /* Button padding */
        }

        /* News Card Specific Styles */
        .news-card img {
            width: 100%;
            height: 150px;
            object-fit: cover;
            border-radius: 8px 8px 0 0; /* Round top corners */
        }

        .news-card h4 {
            font-size: 1.2rem; /* Title size */
            margin: 10px 0; /* Margin above and below */
            color: #333; /* Title color */
        }

        .news-card p {
            font-size: 0.9rem; /* Summary text size */
            color: #777; /* Summary text color */
        }

        /* Read More Button Styles */
        .read-more-btn {
            display: inline-block;
            padding: 8px 12px; /* Button padding */
            margin-top: 10px; /* Margin above button */
            background-color: #007bff; /* Button color */
            color: white; /* Text color */
            border-radius: 4px; /* Round corners */
            text-transform: uppercase; /* Uppercase text */
            transition: background-color 0.3s ease; /* Transition for background */
        }
        .read-more-btn:hover {
            background-color: #0056b3; /* Darker shade on hover */
        }
    </style>
</head>
<body>
<jsp:include page="layout/header.jsp"></jsp:include>
<div class="container-lg">
    <h1 class="text-center my-4">Trang Chủ Tin Tức</h1>

    <div class="row">
        <!-- Main Content Area -->
        <div class="col-md-8">
            <jsp:include page="layout/slider.jsp"/>
            <!-- Newest News Section -->
            <h2 class="my-4 text-center">Tin tức mới</h2>
            <div class="row">
                <%-- Loop to display latest news --%>
                <c:forEach  var="news"  items="${latestNews}">
                    <div class="col-md-12 mb-3 custom-card d-flex align-items-start">
                        <div class="me-3">
                            <img src="${pageContext.request.contextPath}/images/${news.image}" alt="News Image"
                                 class="img-fluid rounded"
                                 style="width: 150px; height: 100px;">
                        </div>
                        <div class="flex-grow-1">
                            <h5><a href="news_detail?id=${news.id}" class="text-primary">${news.title}</a></h5>
                            <p class="mb-2">${fn:substring(news.content, 0, 100)}...</p>
                            <small class="text-muted">Ngày đăng: ${news.postedDate} | Tác giả: ${news.author}</small>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!-- Sidebar Section -->
        <div class="col-md-4">
            <!-- Recent News Section -->
            <section class="mb-5">
                <h2 class="text-center">Tin tức gần đây</h2>
                <div class="row">
                    <%-- Loop for recent news --%>
                        <c:forEach items="${list5currentUser}" var="news">
                    <div class="col-md-12 mb-3">
                        <div class="card custom-card">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/images/${news.image}"
                                 alt="News Image" style="height: 80px;">
                            <div class="card-body">
                                <a href="news_detail?id=${news.id}" class="btn btn-primary"><h5
                                        class="card-title">${news.title}</h5></a>
                            </div>
                        </div>
                    </div>
                        </c:forEach>
                </div>
            </section>

            <!-- Trending News Section -->
            <section class="mb-5">
                <h2 class="text-center">Tin tức nhiều người xem</h2>
                <div class="row">
                     <c:forEach items="${listTop5viewCount}" var="news">
                    <div class="col-md-12 mb-3">
                        <div class="card custom-card">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/images/${news.image}"
                                 alt="News Image" style="height: 80px;">
                            <div class="card-body">
                                <a href="news_detail?id=${news.id}" class="btn btn-primary"><h5 class="card-title">
                                  ${news.title}</h5></a>
                            </div>
                        </div>
                    </div>
                     </c:forEach>
                </div>
<%--            </section>--%>
<%--            <!-- Recently Viewed News Section -->--%>
<%--                        <section class="mb-5">--%>
<%--                            <h2 class="text-center">Tin tức đã xem</h2>--%>
<%--                            <div class="row">--%>
<%--                                <c:forEach items="${list5CurrentNews}" var="news">--%>
<%--                                <div class="col-md-12 mb-3">--%>
<%--                                    <div class="card custom-card">--%>
<%--                                        <img class="card-img-top" src="${pageContext.request.contextPath}/images/${news.image}/"--%>
<%--                                             alt="News Image" style="height: 80px;">--%>
<%--                                        <div class="card-body">--%>
<%--                                            <a href="news_detail?id=${news.id}" class="btn btn-primary"><h5 class="card-title">--%>
<%--                                                    ${news.title}</h5></a>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                                </c:forEach>--%>
<%--                            </div>--%>
<%--                        </section>--%>
        </div>
    </div>
</div>

<jsp:include page="layout/footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
