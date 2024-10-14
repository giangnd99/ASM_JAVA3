<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<style>
    .footer {
        background: linear-gradient(135deg, #4b79a1, #283e51);
        color: #fff;
        padding: 40px 0;
    }
    .footer h5 {
        font-size: 1.5rem;
        font-weight: bold;
    }
    .footer p {
        font-size: 0.9rem;
        margin-bottom: 10px;
    }
    .footer .btn-success {
        background-color: #28a745;
        border-color: #28a745;
    }
    .footer .btn-primary {
        background-color: #007bff;
        border-color: #007bff;
    }
    .footer .text-muted {
        opacity: 0.8;
        color: #fff !important;
    }
    .footer .social-links i {
        font-size: 1.5rem;
        margin: 0 10px;
        color: #fff;
    }
    .footer .social-links i:hover {
        color: #f9c74f;
    }
    .footer .navigation-links a {
        color: #f9c74f;
        margin: 0 10px;
    }
    .footer .navigation-links a:hover {
        text-decoration: underline;
    }
</style>
<footer class="footer">
    <div class="container">
        <div class="row align-items-center">
            <!-- Left Section: Logo and Editor Information -->
            <div class="col-md-4 text-center text-md-start mb-3 mb-md-0">
                <img src="images/FPT_Polytechnic.png" alt="Company Logo" class="mb-2" style="max-width: 150px;">
                <p class="mb-1">Tổng biên tập: <strong>Thầy Vỹ</strong></p>
                <p class="mb-1">Thông tin tòa soạn - FPT</p>
            </div>

            <!-- Center Section: Email Subscription Form -->
            <div class="col-md-4 text-center">
                <h5 class="mb-2">Đăng ký nhận tin tức mới nhất</h5>
                <form action="subscribe" method="post" class="d-flex justify-content-center">
                    <input type="email" name="email" class="form-control me-2" placeholder="Nhập email của bạn" required />
                    <button type="submit" class="btn btn-success">Nhận Tin</button>
                </form>
                <small  class="text-muted" style="color:#fff">Đọc giả có thể điền email để nhận thông tin mới nhất.</small>
            </div>

            <!-- Right Section: Contact Information -->
            <div class="col-md-4 text-center text-md-end">
                <p class="mb-1">Địa chỉ: <strong> Đ.Tô Ký, P.1, Q.12, Tp. Hồ Chí Minh</strong></p>
                <p class="mb-1">Hotline: <strong>0918.033.133</strong> - Email: <strong>giangndps38221@fpt.edu.vn</strong></p>
                <p class="mb-1">Phòng Báo Công Nghệ: <strong>0123455231</strong></p>
                <a href="#" class="d-block mt-2 text-decoration-none">
                    <button class="btn btn-primary">Đăng ký tại đây</button>
                </a>
            </div>
        </div>

        <!-- Social Links and Navigation -->
        <div class="row mt-4">
            <div class="col text-center">
                <div class="mb-2 navigation-links">
                    <a href="#" class="text-muted me-3" style="color:#fff">Trang chủ</a>
                </div>
                <div class="social-links">
                    <a href="#" class="me-3 text-muted"><i class="bi bi-facebook fs-4"></i></a>
                    <a href="#" class="text-muted"><i class="bi bi-youtube fs-4"></i></a>
                </div>
            </div>
        </div>

        <!-- Copyright Information -->
        <div class="row mt-4">
            <div class="col text-center text-muted">
                <hr>
                <p class="mb-0" style="color:#fff">© Copyright 2024 FPT-Polytechnic Co., Ltd. All rights reserved.</p>
            </div>
        </div>
    </div>
</footer>
