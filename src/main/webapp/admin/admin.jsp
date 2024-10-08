<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang Quản Trị</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .content {
            padding: 20px;
        }
    </style>
</head>
<body>
<jsp:include page="/views/adminnavbar.jsp" />
<div class="container content">
    <c:choose>
        <c:when test="${action eq 'manageUsers'}">
            <jsp:include page="/views/usermanage.jsp" />
        </c:when>
        <c:when test="${action eq 'manageNews'}">
            <jsp:include page="/views/newsmanage.jsp" />
        </c:when>
        <c:when test="${action eq 'manageCategory'}">
            <jsp:include page="/views/categorymanage.jsp" />
        </c:when>
        <c:when test="${action eq 'manageNewsletter'}">
            <jsp:include page="/admin/newslettermanage.jsp" />
        </c:when>
        <c:otherwise>
            <p>Chọn một chức năng từ menu để quản lý.</p>
        </c:otherwise>
    </c:choose>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<jsp:include page="/views/admin/adminfooter.jsp" />
</body>
</html>
