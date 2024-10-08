<%--
  Created by IntelliJ IDEA.
  User: Lam
  Date: 24/09/2024
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>>
    <title>List News</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
<jsp:include page="../layout/navbar.jsp" />
<div class="container mt-5">
    <h2 class="mb-4">Latest News</h2>
    <ul class="list-group">
        <!-- News Item 1 -->
        <li class="list-group-item">
            <div class="row">
                <div class="col-md-4">
                    <img src="https://via.placeholder.com/150" class="img-fluid rounded" alt="News Image">
                </div>
                <div class="col-md-8">
                    <h5 class="mt-2">Tin tức 1</h5>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque viverra arcu non dui scelerisque, nec dictum enim feugiat.</p>
                    <a href="#" class="btn btn-primary btn-sm">Read More</a>
                </div>
            </div>
        </li>
        <!-- News Item 2 -->
        <li class="list-group-item">
            <div class="row">
                <div class="col-md-4">
                    <img src="https://via.placeholder.com/150" class="img-fluid rounded" alt="News Image">
                </div>
                <div class="col-md-8">
                    <h5 class="mt-2">Tin tức 2</h5>
                    <p>Donec accumsan tellus et mi scelerisque, eget congue risus pretium. Sed luctus mauris sit amet turpis laoreet laoreet.</p>
                    <a href="#" class="btn btn-primary btn-sm">Read More</a>
                </div>
            </div>
        </li>
        <!-- News Item 3 -->
        <li class="list-group-item">
            <div class="row">
                <div class="col-md-4">
                    <img src="https://via.placeholder.com/150" class="img-fluid rounded" alt="News Image">
                </div>
                <div class="col-md-8">
                    <h5 class="mt-2">Tin tức 3</h5>
                    <p>Phasellus imperdiet massa at ex sodales, sit amet tempor augue fermentum. Fusce tincidunt turpis et augue facilisis elementum.</p>
                    <a href="#" class="btn btn-primary btn-sm">Read More</a>
                </div>
            </div>
        </li>
    </ul>
</div>
<jsp:include page ="../layout/footer.jsp"></jsp:include>
</body>
</html>
