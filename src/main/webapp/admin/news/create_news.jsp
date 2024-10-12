<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
        }
        h1 {
            color: #007bff;
        }
        .form-control, .form-select {
            border-radius: 0.5rem;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
        }
        .btn-secondary {
            background-color: #6c757d;
            border: none;
        }
        .card {
            border: none;
            border-radius: 0.5rem;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container-lg">
    <h1 class="text-center my-4">Bài viết mới</h1>
    <!-- Form for Writing News -->
    <div class="container my-5">
        <div class="card p-4">
            <form action="submit_news" method="post" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="title" class="form-label">Tiêu đề</label>
                    <input type="text" class="form-control" id="title" name="title" required>
                </div>

                <div class="mb-3">
                    <label for="content" class="form-label">Nội dung</label>
                    <textarea class="form-control" id="content" name="content" rows="5" required></textarea>
                </div>

                <div class="mb-3">
                    <label for="image" class="form-label">Hình ảnh</label>
                    <input type="file" class="form-control" id="image" name="image">
                </div>

                <div class="mb-3">
                    <label for="category" class="form-label">Danh mục</label>
                    <select class="form-select" id="category" name="category_id" required>
                        <option value="1">Công nghệ</option>
                        <option value="2">Khoa học</option>
                        <option value="3">Xã hội</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="author" class="form-label">Tác giả</label>
                    <select class="form-select" id="author" name="author_id" required>
                        <option value="1">Nguyễn Văn A</option>
                        <option value="2">Trần Thị B</option>
                        <option value="3">Lê Văn C</option>
                    </select>
                </div>

                <div class="mb-3 form-check">
                    <input type="checkbox" class="form-check-input" id="home" name="home">
                    <label class="form-check-label" for="home">Hiển thị trên trang chủ</label>
                </div>

                <button type="submit" class="btn btn-primary">Gửi Bài</button>
                <button type="reset" class="btn btn-secondary">Xóa</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="../footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
