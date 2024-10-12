<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../layout/page_header.jsp">
        <jsp:param name="title" value="Đăng Ký Tài Khoản"/>
    </jsp:include>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<!-- Include Header -->


<div class="container my-5">
    <jsp:include page="../layout/header.jsp"></jsp:include>
    <h2 class="text-center">Đăng Ký Tài Khoản</h2>
    <form action="register" method="POST" class="row g-3 needs-validation" novalidate>
        <!-- Email -->
        <div class="col-md-6">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" required>
            <div class="invalid-feedback">Vui lòng nhập email hợp lệ.</div>
        </div>

        <!-- Password -->
        <div class="col-md-6">
            <label for="password" class="form-label">Mật Khẩu</label>
            <input type="password" class="form-control" id="password" name="password" required>
            <div class="invalid-feedback">Vui lòng nhập mật khẩu.</div>
        </div>

        <!-- Full Name -->
        <div class="col-md-6">
            <label for="fullName" class="form-label">Họ Và Tên</label>
            <input type="text" class="form-control" id="fullName" name="fullname" required>
            <div class="invalid-feedback">Vui lòng nhập họ tên.</div>
        </div>

        <!-- Birthday -->
        <div class="col-md-6">
            <label for="birthday" class="form-label">Ngày Sinh</label>
            <input type="date" class="form-control" id="birthday" name="birthday">
        </div>

        <!-- Phone -->
        <div class="col-md-6">
            <label for="phone" class="form-label">Số Điện Thoại</label>
            <input type="text" class="form-control" id="phone" name="phone" pattern="^(\d{10}|\d{11})$">
            <div class="invalid-feedback">Vui lòng nhập số điện thoại hợp lệ (10 hoặc 11 số).</div>
        </div>

        <!-- Gender -->
        <div class="col-md-6">
            <label for="gender" class="form-label">Giới Tính</label>
            <select class="form-select" id="gender" name="gender" required>
                <option value="" selected disabled>Chọn giới tính</option>
                <option value="true">Nam</option>
                <option value="false">Nữ</option>
            </select>
            <div class="invalid-feedback">Vui lòng chọn giới tính.</div>
        </div>

        <!-- Role -->
        <div class="col-md-6">
            <label for="role" class="form-label">Vai Trò</label>
            <select class="form-select" id="role" name="role" required>
                <option value="" selected disabled>Chọn vai trò</option>
                <option value="true">Quản trị viên</option>
                <option value="false">Người dùng</option>
            </select>
            <div class="invalid-feedback">Vui lòng chọn vai trò.</div>
        </div>

        <!-- Submit Button -->
        <div class="col-12 text-center">
            <button class="btn btn-primary" type="submit">Đăng Ký</button>
        </div>
    </form>
</div>

<!-- Include Footer -->
<jsp:include page="../layout/footer.jsp"></jsp:include>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
