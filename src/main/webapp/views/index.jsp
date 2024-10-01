<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>News Management</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container mt-4">
    <div class="row">
        <div class="col-md-8">
            <div class="card mb-4">
                <div class="card-header">
                    <h5>BAI VIET MOI NHAT</h5>
                </div>
                <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner">
                        <div class="carousel-item active" data-bs-interval="10000">
                            <img src="${pageContext.request.contextPath}/images/post2.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>First slide label</h5>
                                <p>Some representative placeholder content for the first slide.</p>
                            </div>
                        </div>
                        <div class="carousel-item" data-bs-interval="2000">
                            <img src="${pageContext.request.contextPath}/images/post1.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Second slide label</h5>
                                <p>Some representative placeholder content for the second slide.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="${pageContext.request.contextPath}/images/post3.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Third slide label</h5>
                                <p>Some representative placeholder content for the third slide.</p>
                            </div>
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card mb-4">
                <div class="card-header">
                    <h5>TIN MỚI</h5>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">5 BAI DC XEM NHIEU NHAT<span class="badge bg-primary float-end"> New</span></li>
                    <li class="list-group-item">5 BÀI TIN MƠ NHẤT <span class="badge bg-primary float-end"> New</span></li>
                    <li class="list-group-item">5 BẢN TIN GẦN NHẤT ĐÃ XEM <span class="badge bg-primary float-end"> New</span></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="container mt-5">
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
<!-- Advertisement Section -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
