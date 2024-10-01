<%--
  Created by IntelliJ IDEA.
  User: Lam
  Date: 25/09/2024
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    #subscribe {
        margin: 50px;
    }
    #subscribe .subscribe-content {
        background-image: url("${pageContext.request.contextPath}/images/subscribtionimg.jpg");
        width: 100%;
        height: 350px;
        background-size: cover; /* Thêm thuộc tính này để ảnh lấp đầy toàn bộ khu vực */
    }
    #subscribe .subscribe-content .entry-content {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100%; /* Điều chỉnh chiều cao để căn giữa nội dung */
        color: #ffffff;
    }
    #subscribe .subscribe-content .section-header {
        width: 45%;
        margin-right: 60px;
    }
    #subscribe .subscribe-content .section-title {
        line-height: 1.1;
        color: #ffffff;
    }
    #subscribe .subscribe-content p {
        font-size: 1.4em;
        font-family: 'Playfair Display';
    }
    form#form {
        width: 371px;
    }
    form#form input[type="text"] {
        width: 100%;
        height: 44px;
        margin-bottom: 15px;
        text-align: center;
        border: none;
    }
    form#form button {
        width: 100%;
        height: 44px;
        border: none;
        background: #000;
        color: #fff;
        font-weight: 600;
        cursor: pointer;
    }
    form#form button:hover {
        background: #e9663c;
    }
    @media (max-width: 1100px) {
        #subscribe .subscribe-content .entry-content {
            width: 100%;
        }
    }
    @media (max-width: 930px) {
        #subscribe .subscribe-content .entry-content {
            flex-wrap: wrap;
            text-align: center;
            margin: 80px auto;
        }
        #subscribe .subscribe-content .section-header {
            width: 100%;
            margin: 20px 60px;
        }
    }
    @media (max-width: 800px) {
        #subscribe .subscribe-content .entry-content {
            margin: 50px auto;
        }
        #subscribe .section-title {
            font-size: 2.5em;
        }
    }
    @media (max-width: 600px) {
        #subscribe .section-title {
            font-size: 2em;
        }
    }
    .navbar-nav {
    }
</style>
<section id="subscribe">
    <div class="container">
        <div class="row">
            <div class="subscribe-content">
                <div class="entry-content">
                    <div class="section-header">
                        <h2 class="section-title">Subscribe us for more life transforming tips and articles</h2>
                        <p>Subscribe us for more life transforming tips</p>
                    </div>
                    <form id="form">
                        <input type="text" name="name" placeholder="Name">
                        <input type="text" name="email" placeholder="Email Address">
                        <button id="button">Send me the link</button>
                    </form>
                </div><!--text-block-->
            </div>
        </div>
    </div>
</section>
<!-- Footer -->
<footer class="text-center py-4">
    <p>&copy; 2024 News Management. All rights reserved.</p>
</footer>
