<%--
  Created by IntelliJ IDEA.
  User: Lam
  Date: 24/09/2024
  Time: 12:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail News</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
<jsp:include page="navbar.jsp" />
<div class="container mt-5">
    <!-- Chi tiết bài viết -->
    <div class="row">
        <div class="col-md-8">
            <h1 class="mb-3">Tiêu đề bài viết</h1>
            <p class="text-muted">Ngày đăng: 25/09/2024</p>
            <img src="https://via.placeholder.com/800x400" alt="Ảnh bài viết" class="img-fluid mb-4">
            <p class="lead">Đoạn giới thiệu hoặc mô tả ngắn về bài viết.</p>
            <p>Nội dung chính của bài viết sẽ được hiển thị tại đây. Đây là nơi bạn có thể đặt văn bản, hình ảnh, và các nội dung khác liên quan đến bài viết.</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            <p>...</p>
        </div>
        <!-- Sidebar danh sách các bài viết liên quan -->
        <div class="col-md-4">
            <h5 class="mb-4">Bài viết liên quan</h5>
            <div class="card mb-3">
                <img src="https://via.placeholder.com/150x100" class="card-img-top" alt="Bài viết 1">
                <div class="card-body">
                    <h6 class="card-title">Tiêu đề bài viết liên quan 1</h6>
                    <p class="card-text">Mô tả ngắn cho bài viết liên quan 1.</p>
                    <a href="#" class="btn btn-primary btn-sm">Xem chi tiết</a>
                </div>
            </div>
            <div class="card mb-3">
                <img src="https://via.placeholder.com/150x100" class="card-img-top" alt="Bài viết 2">
                <div class="card-body">
                    <h6 class="card-title">Tiêu đề bài viết liên quan 2</h6>
                    <p class="card-text">Mô tả ngắn cho bài viết liên quan 2.</p>
                    <a href="#" class="btn btn-primary btn-sm">Xem chi tiết</a>
                </div>
            </div>
            <div class="card mb-3">
                <img src="https://via.placeholder.com/150x100" class="card-img-top" alt="Bài viết 3">
                <div class="card-body">
                    <h6 class="card-title">Tiêu đề bài viết liên quan 3</h6>
                    <p class="card-text">Mô tả ngắn cho bài viết liên quan 3.</p>
                    <a href="#" class="btn btn-primary btn-sm">Xem chi tiết</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Danh sách các bài viết liên quan ở dưới (thêm) -->
    <div class="mt-5">
        <h3 class="mb-4">Bài viết khác bạn có thể thích</h3>
        <div class="row row-cols-1 row-cols-md-3 g-4">
            <div class="col">
                <div class="card">
                    <img src="https://via.placeholder.com/150x100" class="card-img-top" alt="Bài viết 4">
                    <div class="card-body">
                        <h5 class="card-title">Tiêu đề bài viết 4</h5>
                        <p class="card-text">Mô tả ngắn cho bài viết 4.</p>
                        <a href="#" class="btn btn-primary btn-sm">Xem chi tiết</a>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card">
                    <img src="https://via.placeholder.com/150x100" class="card-img-top" alt="Bài viết 5">
                    <div class="card-body">
                        <h5 class="card-title">Tiêu đề bài viết 5</h5>
                        <p class="card-text">Mô tả ngắn cho bài viết 5.</p>
                        <a href="#" class="btn btn-primary btn-sm">Xem chi tiết</a>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card">
                    <img src="https://via.placeholder.com/150x100" class="card-img-top" alt="Bài viết 6">
                    <div class="card-body">
                        <h5 class="card-title">Tiêu đề bài viết 6</h5>
                        <p class="card-text">Mô tả ngắn cho bài viết 6.</p>
                        <a href="#" class="btn btn-primary btn-sm">Xem chi tiết</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page ="footer.jsp"/>
</body>
</html>
