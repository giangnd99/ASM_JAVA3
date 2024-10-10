<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../layout/page_header.jsp">
        <jsp:param name="title" value="Đăng Nhập"/>
    </jsp:include>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container-lg">
    <jsp:include page="../layout/header.jsp"></jsp:include>
    <h1 class="text-center my-4">Đăng Nhập</h1>

    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="login_process" method="POST">
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Mật khẩu</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <div class="form-check mb-3">
                    <input type="checkbox" class="form-check-input" id="rememberMe" name="rememberMe">
                    <label class="form-check-label" for="rememberMe">Nhớ tài khoản</label>
                </div>
                <button type="submit" class="btn btn-primary w-100">Đăng Nhập</button>
            </form>

            <div class="text-center my-3">
                <a href="forgot_password.jsp" class="text-decoration-none">Quên mật khẩu?</a>
            </div>

            <div class="text-center">
                <span>Chưa có tài khoản?</span> <a href="register.jsp" class="text-decoration-none">Đăng ký ngay</a>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../layout/footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
