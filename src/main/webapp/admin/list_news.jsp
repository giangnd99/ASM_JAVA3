<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../layout/page_header.jsp">
        <jsp:param name="title" value="Trang Quản Trị Admin"/>
    </jsp:include>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .header-title {
            color: #007bff;
        }
        table {
            background-color: #fff;
            width: 100%;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div class="container-lg">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="row">
        <div class="col-lg-9">
            <section class="mt-4">
                <h5 class="header-title">Danh sách tin tức</h5>
                <div class="card">
                    <div class="card-body">
                        <table class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Tiêu đề</th>
                                <th>Tác giả</th>
                                <th>Ngày đăng</th>
                                <th>Nội dung</th>
                                <th>Hành động</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>1</td>
                                <td>Những thay đổi trong năm 2024</td>
                                <td>Thạch</td>
                                <td>25/09/2024</td>
                                <td>Đoạn mở đầu của bài báo sẽ giới thiệu về những thay đổi quan trọng trong năm 2024...</td>
                                <td>
                                    <a href="edit_news?id=1" class="btn btn-warning btn-sm">Sửa</a>
                                    <a href="edit_news?id=1" class="btn btn-danger btn-sm">Xóa</a>
                                </td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Sự kiện nổi bật trong tháng 9</td>
                                <td>Minh</td>
                                <td>20/09/2024</td>
                                <td>Bài viết nêu rõ những sự kiện quan trọng đã diễn ra trong tháng 9...</td>
                                <td>
                                    <a href="edit_news?id=2" class="btn btn-warning btn-sm">Sửa</a>
                                    <a href="edit_news?id=2" class="btn btn-danger btn-sm">Xóa</a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>
        </div>
    </div>


</div>
<br>
<br>
<br>
<hr>
<jsp:include page="footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
