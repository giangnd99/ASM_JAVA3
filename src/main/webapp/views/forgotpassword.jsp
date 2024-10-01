<%--
  Created by IntelliJ IDEA.
  User: Lam
  Date: 23/09/2024
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>ForgotPassword</title>
</head>
<body>
<form method="post" action="Forgotpassword">
    <div class="card text-center" style="width:50%;">
        <div class="card-header h5 text-white bg-primary">Password Reset</div>
        <div class="card-body px-5">
            <p class="card-text py-2">
                Enter your email address and we'll send you an email with instructions to reset your password.
            </p>
            <div data-mdb-input-init class="form-outline">
                <input type="email" id="typeEmail" class="form-control my-3" />
                <label class="form-label" for="typeEmail">Email input</label>
            </div>
            <a href="#" data-mdb-ripple-init class="btn btn-primary w-100">Reset password</a>
            <div class="d-flex justify-content-between mt-4">
            </div>
        </div>
    </div>
</form>
</body>
</html>
