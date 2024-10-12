<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active" data-bs-interval="10000">
            <img src="${pageContext.request.contextPath}/images/news1.jpg" class="d-block w-100" alt="First news on Java" style="height: 500px;">
            <div class="carousel-caption d-none d-md-block caption-bg">
                <h5 class="text-white">Tin công nghệ thứ 1</h5>
                <p class="text-light">Đây là thông tin về Java</p>
            </div>
        </div>
        <div class="carousel-item" data-bs-interval="2000">
            <img src="${pageContext.request.contextPath}/images/news2.jpg" class="d-block w-100" alt="Second news on Data" style="height: 500px;">
            <div class="carousel-caption d-none d-md-block caption-bg">
                <h5 class="text-white">Tin công nghệ thứ 2</h5>
                <p class="text-light">Đây là trang tin tức về data</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="${pageContext.request.contextPath}/images/news3.jpg" class="d-block w-100" alt="Third news on Cloud" style="height: 500px;">
            <div class="carousel-caption d-none d-md-block caption-bg">
                <h5 class="text-white">Tin công nghệ thứ 3</h5>
                <p class="text-light">Đây là trang tin tức về cloud</p>
            </div>
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Về sau</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Tiếp</span>
    </button>
</div>

<style>
    .caption-bg {
        background: rgba(0, 0, 0, 0.6);
        border-radius: 10px;
        padding: 20px;
        backdrop-filter: blur(5px);
    }
    .carousel-item img {
        object-fit: cover;
        width: 100%;
        height: 500px;
    }
</style>
