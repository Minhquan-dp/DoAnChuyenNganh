<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.springframework.ui.Model" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <!-- My JavaScript -->
    <script src="../../../static/js/admin.js"></script>
    <!-- /My JavaScript -->
    <link rel="stylesheet" href="../../../static/css/admin/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../../../static/css/admin/admin.css" type="text/css" media="all">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,900" rel="stylesheet">

    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

    <script>
        $(document).on('submit', '#addMovieForm', function (event) {
            var frm = $('#addMovieForm')
            var data = {};

            $.each(this, function (i, v) {
                var input = $(v);
                data[input.attr("id")] = input.val();
                delete data["undefined"];
            });
            data["duration"] = parseInt(data["duration"]);
            console.log(data);
            $.ajax({
                contentType: "application/json;charset=UTF-8",
                type: frm.attr('method'),
                url: frm.attr('action'),
                data: JSON.stringify(data),
                success: function () {
                    window.location.reload();
                }
            });
        });

        $(document).on('submit', '#updateForm', function (e) {
            var frm = $('#updateForm');
            e.preventDefault();
            var data = {};
            $.each(this, function (i, v) {
                var input = $(v);
                data[input.attr("name")] = input.val();
                delete data["undefined"];
            });
            data["duration"] = parseInt(data["duration"]);
            data["id"] = parseInt(data["id"]);
            console.log(data);
            $.ajax({
                contentType: "application/json;charset=UTF-8",
                type: frm.attr('method'),
                url: frm.attr('action'),
                data: JSON.stringify(data),
                success: function () {
                    window.location.reload();
                }
            });
        });

        $(document).ready(function () {
            // Bắt sự kiện click vào phần tử DELETE
            $(document).on('click', '.delete-movie', function (e) {
                e.preventDefault();

                // Lấy movieId từ thuộc tính data-movie-id
                var movieId = $(this).data('movie-id');

                // Gửi yêu cầu xóa bộ phim
                $.ajax({
                    url: "/admin_home/deleteMovie?movieId=" + movieId,
                    type: "GET",
                    success: function (response) {
                        window.location.reload();
                    }
                });
            });
        });
    </script>


    <title>Manage Movies :: Admin</title>
</head>
<body>

<div class="admin-dashboard">
    <div class="container-fluid">
        <div class="admin-reg">
            <div class="row">
                <div class="col-md-9">
                    <div class="col-md-9">
                        <div class="row">
                            <div class="col-md-12">
                                <nav class="navbar navbar-light navbar-toggleable">
                                    <a class="navbar-brand" href="#">Movies</a>
                                    <div class="collapse navbar-collapse menu" id="navbarSupportedContent">
                                        <ul class="navbar-nav ml-auto menu-nav">
                                            <li>
                                                <a href="#" class="nav-link menu-link" data-toggle="modal"
                                                   data-target="#modalCenter">ADD MOVIE</a>
                                                <div class="modal fade" id="modalCenter" tabindex="-1" role="dialog"
                                                     aria-labelledby="AddCinema" aria-hidden="true">
                                                    <div class="modal-dialog modal-dialog-centered" role="document">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="modalLongTitle">Add
                                                                    Movie</h5>
                                                                <button type="button" class="close" data-dismiss="modal"
                                                                        aria-label="Close">
                                                                    <span aria-hidden="true">&times;</span>
                                                                </button>
                                                            </div>
                                                            <div class="modal-body">
                                                                <form id="addMovieForm" method="post"
                                                                      action="${pageContext.request.contextPath}/admin_home/addMovie"
                                                                      onsubmit="return false">
                                                                    <div class="row">
                                                                        <div class="col-sm-12">
                                                                            <div class="form-group">
                                                                                <input id="name"
                                                                                       class="form-control label"
                                                                                       placeholder="Name"/>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-sm-6">
                                                                            <div class="form-group">
                                                                                <input id="smallImageURl"
                                                                                       class="form-control label"
                                                                                       placeholder="Small imageURL"/>
                                                                            </div>
                                                                        </div>

                                                                        <div class="col-sm-12">
                                                                            <div class="form-group">
                                                                                <textarea id="shortDescription"
                                                                                          form="addMovieForm"
                                                                                          class="form-control label"
                                                                                          rows="3"
                                                                                          placeholder="shortDescription"></textarea>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-sm-12">
                                                                            <div class="form-group">
                                                                                <textarea id="longDescription"
                                                                                          form="addMovieForm"
                                                                                          class="form-control label"
                                                                                          rows="3"
                                                                                          placeholder="longDescription"></textarea>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-sm-6">
                                                                            <div class="form-group">
                                                                                <input id="largeImageURL"
                                                                                       class="form-control label"
                                                                                       placeholder="Large imageURL"/>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-sm-12">
                                                                            <div class="form-group">
                                                                                <input id="director"
                                                                                       class="form-control label"
                                                                                       placeholder="Director"/>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-sm-12">
                                                                            <div class="form-group">
                                                                                <input id="actors"
                                                                                       class="form-control label"
                                                                                       placeholder="Actors"/>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-sm-12">
                                                                            <div class="form-group">
                                                                                <input id="categories"
                                                                                       class="form-control label"
                                                                                       placeholder="Category"/>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-sm-6">
                                                                            <div class="form-group">
                                                                                <input type="date" id="releaseDate"
                                                                                       class="form-control label"
                                                                                       placeholder="Release Date"/>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-sm-6">
                                                                            <div class="form-group">
                                                                                <input id="duration" type="number"
                                                                                       class="form-control label"
                                                                                       placeholder="Duration"/>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-sm-12">
                                                                            <div class="form-group">
                                                                                <input id="trailerURL"
                                                                                       class="form-control label"
                                                                                       placeholder="trailerURL"/>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-sm-12">
                                                                            <div class="form-group">
                                                                                <input id="language"
                                                                                       class="form-control label"
                                                                                       placeholder="Language"/>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-sm-12">
                                                                            <div class="form-group">
                                                                                <input id="rated"
                                                                                       class="form-control label"
                                                                                       placeholder="Rated"/>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-sm-12">
                                                                            <input type="submit" value="ADD"
                                                                                   class="btn btn-primary form-control label"/>
                                                                        </div>
                                                                    </div>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <a href="/admin_home" class="nav-link menu-link">GO BACK</a>
                                            </li>
                                        </ul>
                                    </div>
                                </nav>
                            </div>
                            <div class="col-md-12">
                                <table class="table table-sm">
                                    <thead>
                                    <tr>
                                        <th>MoID</th>
                                        <th>NAMEOFMOVIE</th>
                                        <th>SMALLIMAGEURL</th>
                                        <th>SHORTDESCRIPTION</th>
                                        <th>LONGDESCRIPTION</th>
                                        <th>LARGEIMAGEURL</th>
                                        <th>DIRECTOR</th>
                                        <th>ACTORS</th>
                                        <th>CATEGORY</th>
                                        <th>RELEASEDATE</th>
                                        <th>DURATION</th>
                                        <th>TRAILERURL</th>
                                        <th>LANGUAGE</th>
                                        <th>RATED</th>
                                        <th>UPDATE</th>
                                        <th>DELETE</th>
                                    </tr>
                                    </thead>
                                    <tbody id="movieList">
                                    <c:forEach var="mov" items="${movies}">
                                        <tr>
                                            <form id="updateForm" method="POST" onsubmit="return false"
                                                  action="${pageContext.request.contextPath}/admin_home/updateMovie">
                                                <td>
                                                    <input class="form-control" name="id" type="text"
                                                           value="${mov.id}"/>
                                                </td>
                                                <td><input name="name" class="form-control" type="text"
                                                           value="${mov.name}"/></td>
                                                <td>
                                                    <input class="form-control" name="smallImageURl" type="text"
                                                           value="${mov.smallImageURl}"/>
                                                </td>
                                                <td><input name="shortDescription" class="form-control" type="text"
                                                           value="${mov.shortDescription}"/>
                                                </td>
                                                <td><input name="longDescription" class="form-control" type="text"
                                                           value="${mov.longDescription}"/>
                                                </td>
                                                <td>
                                                    <input class="form-control" name="largeImageURL" type="text"
                                                           value="${mov.largeImageURL}"/>
                                                </td>
                                                <td><input name="director" class="form-control" type="text"
                                                           value="${mov.director}"/>
                                                </td>
                                                <td><input name="actors" class="form-control" type="text"
                                                           value="${mov.actors}"/>
                                                </td>
                                                <td><input name="categories" class="form-control" type="text"
                                                           value="${mov.categories}"/>
                                                </td>
                                                <td><input name="releaseDate" class="form-control" type="date"
                                                           value="${mov.releaseDate}"/>
                                                </td>
                                                <td><input name="duration" class="form-control" type="number"
                                                           value="${mov.duration}"/>
                                                </td>
                                                <td><input name="trailerURL" class="form-control" type="text"
                                                           value="${mov.trailerURL}"/>
                                                </td>
                                                <td><input name="language" class="form-control" type="text"
                                                           value="${mov.language}"/>
                                                </td>
                                                <td><input name="rated" class="form-control" type="text"
                                                           value="${mov.rated}"/>
                                                </td>
                                                <td>
                                                    <button type="submit"
                                                            class="btn btn-success">
                                                        UPDATE
                                                    </button>
                                                </td>
                                            </form>
                                            <td>
                                                <a href="#" class="btn btn-danger delete-movie"
                                                   data-movie-id="${mov.id}">DELETE</a>
                                            </td>

                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>
