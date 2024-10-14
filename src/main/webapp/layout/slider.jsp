<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${not empty listByHome}">
    <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <c:forEach var="news" items="${listByHome}" varStatus="status">
                <button type="button" data-bs-target="#carouselExampleDark"
                        data-bs-slide-to="${status.index}"
                        class="${status.first ? 'active' : ''}"
                        aria-current="true"
                        aria-label="Slide ${status.index + 1}">
                </button>
            </c:forEach>
        </div>
        <!-- Carousel Items -->
        <div class="carousel-inner">
            <c:forEach var="news" items="${listByHome}" varStatus="status">
                <div class="carousel-item ${status.first ? 'active' : ''}" data-bs-interval="10000">
                    <img src="${pageContext.request.contextPath}/images/${news.image}"
                         class="d-block w-100"
                         alt="${news.title}"
                         style="height: 500px;">
                    <div class="carousel-caption d-none d-md-block caption-bg">
                        <h5 class="text-white">${news.title}</h5>
                        <c:set var="maxLength" value="100"/> <!-- Độ dài tối đa cho nội dung -->
                        <c:choose>
                            <c:when test="${fn:length(news.content) > maxLength}">
                                <p class="text-light">
                                        ${fn:substring(news.content, 0, maxLength)}...
                                </p>
                            </c:when>
                            <c:otherwise>
                                <p class="text-light">${news.content}</p>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </c:forEach>
        </div>
        <!-- Carousel Controls -->
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</c:if>


<style>
    .caption-bg {
        background: rgba(0, 0, 0, 0.6);
        border-radius: 10px;
        padding: 20px;
        backdrop-filter: blur(5px);
    }
    .carousel-item img {
        object-fit: cover;
        width: 100%;
        height: 500px;
    }
</style>
