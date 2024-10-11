<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <jsp:include page="../../layout/page_header.jsp"></jsp:include>
    <link rel="stylesheet" href="../../css/new-detail.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
            color: #333;
        }

        main {
            margin-top: 20px;
            margin-bottom: 20px;
        }

        article h1 {
            font-size: 2.5rem;
            margin-bottom: 20px;
        }

        article h3 {
            color: #007bff;
        }

        img {
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }

        .comment-section {
            background-color: #fff;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .comment-form textarea {
            border-radius: 5px;
            border: 1px solid #ced4da;
        }

        .comment {
            border-bottom: 1px solid #e9ecef;
            padding: 10px 0;
        }

        .comment:last-child {
            border: none;
        }

        aside {
            background-color: #fff;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        aside h3 {
            margin-bottom: 15px;
        }

        aside ul li {
            margin-bottom: 10px;
        }

        aside ul li a {
            text-decoration: none;
            color: #007bff;
        }

        aside ul li a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<main class="container-lg">
    <jsp:include page="../../layout/header.jsp"/>

    <div class="row">
        <!-- Nội dung bài báo (80%) -->
        <section class="col-md-8">
            <article>
                <h1>Tiêu đề bài báo: Những thay đổi về phiên bản JDK trong năm 2000000</h1>
                <h3>Tác giả: ...</h3>
                <h3>Ngày đăng: 25/09/2024</h3>
                <img class="img-fluid" src="https://via.placeholder.com/800x400" alt="Hình ảnh bài báo">
                <p>Đoạn mở đầu của bài báo sẽ giới thiệu về những thay đổi quan trọng trong năm 2024...</p>
                <p>Bên cạnh đó, bài viết cũng sẽ nêu lên một số quan điểm khác nhau từ các chuyên gia trong lĩnh vực
                    này...</p>
                <p>Cuối cùng, bài viết sẽ tóm tắt những điểm chính...</p>

                <!-- Phần bình luận -->
                <div class="comment-section">
                    <h3>Bình luận</h3>
                    <form class="comment-form mb-3">
                        <textarea class="form-control" rows="3" placeholder="Viết bình luận của bạn..."></textarea>
                        <button type="submit" class="btn btn-primary mt-2">Gửi bình luận</button>
                    </form>
                    <div class="comments">
                        <div class="comment mb-2">
                            <p><strong>Người dùng 1:</strong> Đây là một bài viết rất hữu ích!</p>
                        </div>
                        <div class="comment mb-2">
                            <p><strong>Người dùng 2:</strong> Cảm ơn tác giả đã chia sẻ thông tin!</p>
                        </div>
                    </div>
                </div>
            </article>
        </section>

        <!-- Cột tin tức cùng loại (20%) -->
        <aside class="col-md-4 mb-4">
            <h3>Tin cùng loại</h3>
            <ul class="list-unstyled">
                <li><a href="#">Sự kiện việc làm IT Job nổi bật trong tháng 9</a></li>
                <li><a href="#">Các chính sách mới của ngành CNTT năm 2024</a></li>
                <li><a href="#">Xu hướng công nghệ hiện nay</a></li>
                <li><a href="#">Ảnh hưởng của AI với nghành CNTT</a></li>
                <li><a href="#">Cập nhật các xu hướng công nghệ quốc tế tháng 10</a></li>
            </ul>
        </aside>
    </div>
</main>

<jsp:include page="../../layout/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
