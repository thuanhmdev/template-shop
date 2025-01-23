<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>TemplateShop</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Template free, template giá rẻ" name="keywords">
        <meta content="Template Shop giá rẻ" name="description">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap"
              rel="stylesheet">
        <!-- Icon Font Stylesheet -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
        <!-- Customized Bootstrap Stylesheet -->
        <link href="/css/client/bootstrap.min.css" rel="stylesheet">
        <!-- Template Stylesheet -->
        <link href="/css/client/style.css" rel="stylesheet">
    </head>

    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header">
                                        <h3 class="text-center font-weight-light my-4">Create Account</h3>
                                    </div>
                                    <div class="card-body">
                                        <form:form action="/register" method="post" modelAttribute="registerUser">
                                            <c:set var="errorEmail">
                                                <form:errors path="email" cssClass="invalid-feedback" />
                                            </c:set>
                                            <c:set var="errorFullName">
                                                <form:errors path="fullName" cssClass="invalid-feedback" />
                                            </c:set>
                                            <c:set var="errorPassword">
                                                <form:errors path="password" cssClass="invalid-feedback" />
                                            </c:set>
                                            <c:set var="errorConfirmPassword">
                                                <form:errors path="confirmPassword" cssClass="invalid-feedback" />
                                            </c:set>

                                            <div class="form-floating mb-3">
                                                <form:input path="email" type="email" cssClass="form-control ${not empty errorEmail ? 'is-invalid' : ''}"/>
                                                <label>Email address</label>
                                                    ${errorEmail}
                                            </div>
                                            <div class="form-floating mb-3">
                                                <form:input path="fullName" type="text" cssClass="form-control ${not empty errorFullName ? 'is-invalid' : ''}" />
                                                <label>Full Name</label>
                                                ${errorFullName}
                                            </div>
                                            <div class="form-floating mb-3">
                                                <form:input path="password" type="password" cssClass="form-control ${not empty errorPassword ? 'is-invalid' : ''}" />
                                                <label>Password</label>
                                                    ${errorPassword}
                                            </div>
                                            <div class="form-floating mb-3">
                                                <form:input path="confirmPassword" type="password" cssClass="form-control ${not empty errorConfirmPassword ? 'is-invalid' : ''}" />
                                                <label>Confirm Password</label>
                                                    ${errorConfirmPassword}
                                            </div>
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid">
                                                    <button class="btn btn-primary btn-block">
                                                        Create Account
                                                    </button>
                                                </div>
                                            </div>
                                        </form:form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="/login">Have an account? Go to login</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                crossorigin="anonymous"></script>
        <script src="/js/client/main.js"></script>
    </body>

</html>