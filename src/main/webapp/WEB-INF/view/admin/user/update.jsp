<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <meta name="description" content="Themeshop"/>
        <meta name="author" content="ThuanHM"/>
        <title>Admin-Themeshop</title>
        <link href="/css/admin/styles.css" rel="stylesheet"/>
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    </head>

    <body class="sb-nav-fixed">
        <jsp:include page="../layout/header.jsp"/>
        <div id="layoutSidenav">
            <jsp:include page="../layout/sidebar.jsp"/>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Manage Users</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                            <li class="breadcrumb-item active">Users</li>
                        </ol>
                        <div class="mt-5">
                            <div class="row">
                                <div class="col-md-6 col-12 mx-auto">
                                    <h3>Create a user</h3>
                                    <hr/>

                                    <%--@elvariable id="userUpdate" type=""--%>
                                    <form:form method="post" action="/admin/user/update"
                                               modelAttribute="userUpdate" class="row" enctype="multipart/form-data">
                                        <div class="mb-3 col-12 col-md-6">

                                            <label class="form-label">ID:</label>
                                            <form:input type="text"
                                                        class="form-control"
                                                        path="id" readonly="true"/>
                                                ${errorEmail}
                                        </div>
                                        <div class="mb-3 col-12 col-md-6">
                                            <c:set var="errorEmail">
                                                <form:errors path="email" cssClass="invalid-feedback"/>
                                            </c:set>
                                            <label class="form-label">Email:</label>
                                            <form:input type="email"
                                                        class="form-control ${not empty errorEmail ? 'is-invalid' : ''}"
                                                        path="email" readonly="true"/>
                                                ${errorEmail}
                                        </div>
                                        <div class="mb-3 col-12 col-md-6">
                                            <c:set var="errorPassword">
                                                <form:errors path="password" cssClass="invalid-feedback"/>
                                            </c:set>
                                            <label class="form-label">Password:</label>
                                            <form:input type="password"
                                                        class="form-control ${not empty errorPassword ? 'is-invalid' : ''}"
                                                        path="password"/>
                                                ${errorPassword}

                                        </div>
                                        <div class="mb-3 col-12 col-md-6">
                                            <label class="form-label">Phone number:</label>
                                            <form:input type="text" class="form-control" path="phone"/>
                                        </div>
                                        <div class="mb-3 col-12 col-md-6">
                                            <c:set var="errorFullName">
                                                <form:errors path="fullName" cssClass="invalid-feedback"/>
                                            </c:set>
                                            <label class="form-label">Full Name:</label>
                                            <form:input type="text"
                                                        class="form-control ${not empty errorFullName ? 'is-invalid' : ''}"
                                                        path="fullName"/>
                                                ${errorFullName}
                                        </div>
                                        <div class="mb-3 col-12">
                                            <label class="form-label">Address:</label>
                                            <form:input type="text" class="form-control" path="address"/>
                                        </div>

                                        <div class="mb-3 col-12 col-md-6">
                                            <label class="form-label">Role:</label>
                                            <form:select class="form-select" path="role.id">
                                                <form:option value="-" label="--Please Select"/>
                                                <form:options items="${roles}" itemValue="id" itemLabel="name"/>
                                            </form:select>
                                        </div>
<%--                                        <div class="mb-3 col-12 col-md-6">--%>
<%--                                            <label for="avatarFile" class="form-label">Avatar:</label>--%>
<%--                                            <input class="form-control" type="file" id="avatarFile"--%>
<%--                                                   accept=".png, .jpg, .jpeg" name="file"/>--%>
<%--                                        </div>--%>
<%--                                        <div class="col-12 mb-3">--%>
<%--                                            <img style="max-height: 250px; display: none;" alt="avatar preview"--%>
<%--                                                 id="avatarPreview"/>--%>
<%--                                        </div>--%>
                                        <div class="col-12 mb-5">
                                            <button type="submit" class="btn btn-primary">Create</button>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
                <jsp:include page="../layout/footer.jsp"/>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                crossorigin="anonymous"></script>
        <script src="/js/admin/scripts.js"></script>
<%--        <script>--%>
<%--            $(document).ready(() => {--%>
<%--                const avatarFileEl = $("#avatarFile");--%>
<%--                const previewFileEl = $("#avatarPreview");--%>
<%--                avatarFileEl.change(function (e) {--%>
<%--                    const file = e.target.files[0];--%>
<%--                    const imgURL = URL.createObjectURL(file);--%>
<%--                    previewFileEl.attr("src", imgURL);--%>
<%--                    previewFileEl.css({"display": "block"});--%>
<%--                })--%>
<%--            })--%>
<%--        </script>--%>
    </body>
</html>