<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
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
                        <h1 class="mt-4">Product</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                            <li class="breadcrumb-item active">Product</li>
                        </ol>
                        <div class="mt-5">
                            <div class="row">
                                <div class="col-md-6 col-12 mx-auto">
                                    <h3>Create a Product</h3>
                                    <hr/>
                                    <form:form method="post" action="/admin/product/create"
                                               enctype="multipart/form-data" modelAttribute="product">
                                        <c:set var="errorName">
                                            <form:errors path="name" cssClass="invalid-feedback"/>
                                        </c:set>
                                        <c:set var="errorPrice">
                                            <form:errors path="price" cssClass="invalid-feedback"/>
                                        </c:set>
                                        <div class="mb-3 col-12">
                                            <label class="form-label">Name:</label>
                                            <form:input type="text" path="name"
                                                        cssClass="form-control ${not empty errorName ? 'is-invalid' : ''}"/>
                                                ${errorName}
                                        </div>
                                        <div class="mb-3 col-12 ">
                                            <label class="form-label">Price:</label>
                                            <form:input type="number"
                                                        class="form-control ${not empty errorPrice ? 'is-invalid' : ''}"
                                                        path="price"/>
                                                ${errorPrice}
                                        </div>
                                        <div class="mb-3 col-12">
                                            <label class="form-label">Short description:</label>
                                            <form:textarea type="text"
                                                           class="form-control"
                                                           path="shortDescription"/>
                                        </div>
                                        <div class="mb-3 col-12">
                                            <label class="form-label">Detail description:</label>
                                            <form:textarea type="text"
                                                           class="form-control"
                                                           path="description"/>

                                        </div>
                                        <div class="mb-3 col-12">
                                            <label class="form-label">Link Source:</label>
                                            <form:textarea type="text"
                                                           class="form-control"
                                                           path="linkPreview"/>

                                        </div>
                                        <div class="mb-3 col-12">
                                            <label class="form-label">Link Preview:</label>
                                            <form:textarea type="text"
                                                           class="form-control"
                                                           path="linkSource"/>

                                        </div>
                                        <div class="mb-3 col-12 col-md-6">
                                            <label for="inputFile" class="form-label">Image:</label>
                                            <input class="form-control" type="file" id="inputFile"
                                                   accept=".png, .jpg, .jpeg" name="file"/>
                                        </div>
                                        <div class="col-12 mb-3">
                                            <img style="max-height: 250px; display: none;" alt="avatar preview"
                                                 id="imgPreview"/>
                                        </div>
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
        <script>
            $(document).ready(() => {
                const imgPreviewEl = $("#imgPreview");
                const inputFileEl = $("#inputFile");
                inputFileEl.change(function(e) {
                    const file = e.target.files[0];
                    const imgURL = URL.createObjectURL(file);
                    imgPreviewEl.attr("src", imgURL);
                    imgPreviewEl.css({"display": "block"});
                })
            });
        </script>
    </body>
</html>