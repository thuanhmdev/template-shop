<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    </head>
    <body class="sb-nav-fixed">
        <jsp:include page="../layout/header.jsp" />
        <div id="layoutSidenav">
            <jsp:include page="../layout/sidebar.jsp" />
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Products</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                            <li class="breadcrumb-item"><a href="/admin/product">Product</a></li>
                            <li class="breadcrumb-item active">View detail</li>
                        </ol>
                        <div class="container mt-5">
                            <div class="row">
                                <div class="col-12 mx-auto">
                                    <div class="d-flex justify-content-between">
                                        <h3>Product detail with id = ${id}</h3>
                                    </div>

                                    <hr />

                                    <div class="card" style="width: 60%">
                                        <img class="card-img-top" src="/images/product/${product.image}"
                                             alt="Card image cap" style="width: 300px">

                                        <div class="card-header">
                                            Product information
                                        </div>
                                        <ul class="list-group list-group-flush">
                                            <li class="list-group-item">ID: ${product.id}</li>
                                            <li class="list-group-item">Name: ${product.name}</li>
                                            <li class="list-group-item">Price: ${product.price}</li>
                                            <li class="list-group-item">Link Preview: <a href="${product.linkPreview}">Here</a></li>
                                            <li class="list-group-item">Link Source: <a href="${product.linkSource}">Here</a></li>
                                        </ul>
                                    </div>
                                    <a href="/admin/product" class="btn btn-success mt-3">Back</a>

                                </div>

                            </div>

                        </div>
                    </div>
                </main>
                <jsp:include page="../layout/footer.jsp" />
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                crossorigin="anonymous"></script>
        <script src="/js/admin/scripts.js"></script>
    </body>
</html>

