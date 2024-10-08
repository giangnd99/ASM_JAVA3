<%--
  Created by IntelliJ IDEA.
  User: Lam
  Date: 08/10/2024
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<html>
<head>
    <title>Create user</title>
</head>
<body>
<jsp:include page="adminnavbar.jsp"/>
<div class="container h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-lg-12 col-xl-11">
            <div class="card text-black" style="border-radius: 25px;">
                <div class="card-body p-md-5">
                    <div class="row justify-content-center">
                        <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                            <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>
                            <form action="Register" method="POST" class="mx-1 mx-md-4">
                                <label class="form-label" for="form3Example1c">Your Name</label>
                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                    <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                        <input type="text" id="form3Example1c" class="form-control" />
                                    </div>
                                </div>
                                <div style="margin:20px;padding-left:20px">
                                    <h6>Gender:</h6>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="femaleGender"
                                               value="option1" checked />
                                        <label class="form-check-label" for="femaleGender">Female</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="maleGender"
                                               value="option2" />
                                        <label class="form-check-label" for="maleGender">Male</label>
                                    </div>

                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="otherGender"
                                               value="option3" />
                                        <label class="form-check-label" for="otherGender">Other</label>
                                    </div>
                                </div>
                                <label class="form-label" for="form3Example3c">Your Email</label>
                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                    <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                        <input type="email" id="form3Example3c" class="form-control" />
                                    </div>
                                </div>
                                <label class="form-label" for="form3Example4c">Password</label>
                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                    <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                        <input type="password" id="form3Example4c" class="form-control" />

                                    </div>
                                </div>
                                <label class="form-label" for="form3Example4cd">Repeat your password</label>
                                <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                    <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                        <input type="password" id="form3Example4cd" class="form-control" />

                                    </div>
                                </div>
                                <div style="margin:20px;padding-left:20px">
                                    <h6>Vai trò:</h6>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="adminRole"
                                               value="option1" checked />
                                        <label class="form-check-label" for="femaleGender">Admin</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="writerRole"
                                               value="option3" />
                                        <label class="form-check-label" for="otherGender">Nhà báo</label>
                                    </div>
                                </div>
                                <div class="form-check d-flex justify-content-center mb-5">
                                    <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3c" />
                                    <label class="form-check-label">
                                        I agree all statements in <a href="#!">Terms of service</a>
                                    </label>
                                </div>
                                <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                    <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-lg">Register</button>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="adminfooter.jsp"/>
</body>
</html>
