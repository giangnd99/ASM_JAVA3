<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- Header Section -->
<style>
    .header-container {
        background: linear-gradient(45deg, #1e3c72, #2a5298);
        padding: 20px 0;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }

    .header-logo h1 {
        font-size: 2.5rem;
        font-weight: 700;
        color: #fff;
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
    }

    .navbar {
        background-color: rgba(0, 0, 0, 0.8);
    }

    .navbar-nav .nav-link {
        color: #fff;
        font-size: 1.1rem;
        margin: 0 10px;
        transition: color 0.3s ease;
    }

    .navbar-nav .nav-link:hover {
        color: #f9c74f;
    }

    .form-control {
        border-radius: 20px;
    }

    .btn-outline-light {
        border-radius: 20px;
    }
</style>
<div class="header-container">
    <div class="header-logo text-center">
        <a href="${pageContext.request.contextPath}/" class="text-decoration-none">
            <h1 class="display-4 text-light">Báo Đời</h1>
        </a>
    </div>
</div>

<!-- Navigation Bar -->
<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#topNavbar"
                aria-controls="topNavbar" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="topNavbar">
            <form action="search" method="get" class="d-flex me-auto">
                <input type="search" name="keyword" class="form-control me-2" placeholder="Tìm kiếm" required/>
                <button type="submit" class="btn btn-outline-light">Tìm</button>
            </form>
            <ul class="navbar-nav ms-auto">
                <!-- Kiểm tra nếu người dùng chưa đăng nhập thì hiển thị Đăng nhập/Đăng ký -->
                <c:if test="${loggedUser == null}">
                    <li class="nav-item">
                        <a href="login" class="nav-link">Đăng Nhập</a>
                    </li>
                    <li class="nav-item">
                        <a href="register" class="nav-link">Đăng Ký</a>
                    </li>
                </c:if>

                <!-- Kiểm tra nếu người dùng đã đăng nhập -->
                <c:if test="${loggedUser != null}">
                    <li class="nav-item">
                        <a href="view_profile" class="nav-link">Xin Chào, ${loggedUser.fullname}</a>
                    </li>
                    <li class="nav-item">
                        <a href="logout" class="nav-link">Đăng Xuất</a>
                    </li>

                    <!-- Hiển thị ô Admin nếu người dùng có vai trò Admin -->
                    <c:if test="${loggedUser.role == true}">
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/admin" class="nav-link">Admin</a>
                        </li>
                    </c:if>
                    <c:if test="${loggedUser.role == false}">
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/admin/list_news" class="nav-link">Tin tức của tôi</a>
                        </li>
                    </c:if>
                </c:if>
            </ul>
        </div>
    </div>
</nav>

<div class="my-4"></div>
<!-- Categories Section -->
<div class="container mb-4">
    <div class="row justify-content-center">
        <c:forEach var="cat" items="${listCategory}">
            <div class="col-auto">
                <a href="list_by_category?id=${cat.id}" class="category-link btn btn-outline-primary mx-1">${cat.name}</a>
            </div>
        </c:forEach>
    </div>
</div>
