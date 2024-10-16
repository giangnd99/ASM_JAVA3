<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý Danh Mục</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css">

    <style>
        body {
            background-color: #f8f9fa;
        }

        /* Style cho tiêu đề trang */
        .header-title {
            color: #007bff;
            font-size: 2rem;
            font-weight: bold;
        }

        /* Style cho nút thêm category */
        .create-category-btn {
            background-color: #17a2b8;
            border-color: #17a2b8;
            color: #fff;
            transition: all 0.3s ease;
        }

        .create-category-btn:hover {
            background-color: #138496;
            border-color: #117a8b;
        }

        /* Căn chỉnh bảng và các nút hành động */
        .table th, .table td {
            vertical-align: middle;
            text-align: center;
        }

        .action-btns a {
            margin-right: 5px;
        }

        /* Căn chỉnh input và button cho đẹp */
        .form-inline-custom {
            display: flex;
            flex-wrap: nowrap;
        }

        .form-inline-custom input {
            flex: 1; /* Chiếm toàn bộ chiều rộng trừ phần nút */
        }

        .form-inline-custom button {
            flex-shrink: 0; /* Không thu hẹp nút */
        }
    </style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>

<div class="container-lg mt-5">
    <c:set var="baseUri" value="${pageContext.request.contextPath}/admin"/>
    <!-- Title Section with Create Form -->
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h1 class="header-title">List Newsletter</h1>
        <form action="${baseUri}/create_newsletter" method="POST" class="form-inline-custom">
            <input type="text" class="form-control me-2" placeholder="Nhập email" name="email" required>
            <button type="submit" class="btn create-category-btn btn-lg">Thêm Newsletter</button>
        </form>
    </div>

    <!-- Table Section -->
    <div class="card shadow-sm">
        <div class="card-body">
            <table class="table table-hover table-bordered table-striped text-center">
                <thead class="table-dark">
                <tr>
                    <th>Email</th>
                    <th>Tình Trạng</th>
                    <th>Hành Động</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="newsletters" items="${listNewsletters}">
                <tr>
                    <td>${newsletters.email}</td>
                    <td>${newsletters.enabled ?'Đăng kí':'Đã hủy'}</td>
                    <td class="text-center action-btns">
                        <a href="${baseUri}/update_newsletter?id=${newsletters.email}" class="btn btn-warning btn-sm">
                            <i class="bi bi-pencil"></i> Sửa
                        </a>
                        <a href="${baseUri}/delete_newsletter?id=${newsletters.email}" class="btn btn-danger btn-sm">
                            <i class="bi bi-trash"></i> Xóa
                        </a>
                    </td>
                </tr>
                </c:forEach>
                <!-- Thêm nhiều dòng category khác tại đây -->
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Footer -->
<hr class="mt-5">
<jsp:include page="../footer.jsp"/>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
