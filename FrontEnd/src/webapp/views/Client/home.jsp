<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <link href="../../style/Home.css" rel="stylesheet" type="text/css">

  <style>
    .search-container {
      position: relative;
    }

    .suggestion-list {
      position: absolute;
      width: 100%;
      background-color: white;
      border: 1px solid #ddd;
      border-top: none;
      display: none;
      z-index: 100;
    }

    .suggestion-list-item {
      padding: 8px 12px;
      cursor: pointer;
    }

    .suggestion-list-item:hover {
      background-color: #f1f1f1;
    }
  </style>
  <script>
    function getSuggestions() {
      const keyword = document.getElementById("movie-name").value;
      const suggestionList = document.getElementById("suggestion-list");

      if (keyword.trim() === "") {
        suggestionList.style.display = "none";
        return;
      }

      // Gửi yêu cầu AJAX đến endpoint /suggestion
      const xhr = new XMLHttpRequest();
      xhr.open("GET", "/suggestion?keyword=" + encodeURIComponent(keyword), true);
      xhr.onload = function () {
        if (xhr.status === 200) {
          const suggestions = JSON.parse(xhr.responseText);

          console.log(suggestions); // In suggestions ra console

          // Hiển thị danh sách gợi ý
          let suggestionHTML = "";
          for (let i = 0; i < suggestions.length; i++) {
            suggestionHTML += "<div class='suggestion-list-item'>" + suggestions[i] + "</div>";
          }
          suggestionList.innerHTML = suggestionHTML;
          suggestionList.style.display = "block";
        } else {
          suggestionList.style.display = "none";
        }
      };
      xhr.send();
    }

    // Xử lý sự kiện khi người dùng chọn một gợi ý
    document.addEventListener("click", function (event) {
      const clickedElement = event.target;
      if (clickedElement.classList.contains("suggestion-list-item")) {
        document.getElementById("movie-name").value = clickedElement.textContent;
        document.getElementById("suggestion-list").style.display = "none";
        updateMovieList(); // Cập nhật danh sách phim khi người dùng chọn gợi ý
      }
    });
    // Xử lý sự kiện khi người dùng chọn một gợi ý
    document.addEventListener("click", function (event) {
      const clickedElement = event.target;
      if (clickedElement.classList.contains("suggestion-list-item")) {
        document.getElementById("movie-name").value = clickedElement.textContent;
        document.getElementById("suggestion-list").style.display = "none";
        updateMovieList(); // Cập nhật danh sách phim khi người dùng chọn gợi ý
      }
    });

    function updateMovieList() {
      const keyword = document.getElementById("movie-name").value;
      const movies = document.getElementsByClassName("movie-item");

      for (let i = 0; i < movies.length; i++) {
        const movieName = movies[i].querySelector(".card-title").textContent;
        if (movieName.toLowerCase().includes(keyword)) {
          movies[i].style.display = "block";
        } else {
          movies[i].style.display = "none";
        }
      }
    }
  </script>

  <title>Trang chủ</title>
</head>

<body>
<!-- Content -->
<div class="container">
  <jsp:include page="header.jsp"/>
  <h1>Phim Mới Chiếu</h1>
  <div id="demo" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ul class="carousel-indicators">
      <li data-target="#demo" data-slide-to="0" class="active"></li>
      <li data-target="#demo" data-slide-to="1"></li>
      <li data-target="#demo" data-slide-to="2"></li>
      <li data-target="#demo" data-slide-to="3"></li>
      <li data-target="#demo" data-slide-to="4"></li>
    </ul>
    <!-- The slideshow -->
    <div class="carousel-inner">
      <c:forEach items="${movies}" var="movie" varStatus="count">
        <c:choose>
          <c:when test="${count.index eq 0}">
            <div class="carousel-item active">
              <img src="${movie.largeImageURL}" alt="Los Angeles" width="1100" height="500">
            </div>
          </c:when>
          <c:otherwise>
            <div class="carousel-item">
              <img src="${movie.largeImageURL}" alt="Los Angeles" width="1100" height="500">
            </div>
          </c:otherwise>
        </c:choose>
      </c:forEach>
    </div>

    <!-- Left and right controls -->
    <a class="carousel-control-prev" href="#demo" data-slide="prev">
      <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#demo" data-slide="next">
      <span class="carousel-control-next-icon"></span>
    </a>
  </div>

  <!-- Movie List-->
  <div class='search-box d-flex justify-content-between'>
    <h2>PHIM ĐANG CHIẾU</h2>
    <div class="search-container">
      <form action="/" class="search-bar" method="post" autocomplete="off">
        <input type="search" name="movie-name" id="movie-name" pattern=".*\S.*" required oninput="getSuggestions(); updateMovieList();">
        <button class="search-btn" type="submit">
          <span>Tìm</span>
        </button>
      </form>
      <div id="suggestion-list" class="suggestion-list"></div>
    </div>
  </div>

  <div class="d-flex justify-content-between flex-wrap">
    <c:forEach items="${movies}" var="movie">
      <div class="card movie-item" style="width:300px">
        <img class="card-img-top img-movie" src="${movie.smallImageURl}" alt="Card image" style="width:100%">
        <div class="card-body">
          <h4 class="card-title">${movie.name}</h4>
          <p class="card-text">${movie.shortDescription}</p>
          <a href="movie-details?movieId=${movie.id}" class="btn btn-outline-warning" style="margin-right:70px">Chi tiết</a>
            <%--Nếu chưa đăng nhập mà đã click vào nút mua vé thì trả về trang
            có nút có class btn-buy-ticket-not-signed-in để toggle cái form đăng nhập--%>
          <c:choose>
            <c:when test="${sessionScope.jwtResponse eq null}">
              <button class="btn btn-outline-danger btn-buy-ticket-not-signed-in">Mua vé</button>
            </c:when>
            <c:otherwise>
              <a href="/branches?movieId=${movie.id}" class="btn btn-outline-danger">Mua vé</a>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </c:forEach>
  </div>
</div>



  <c:choose>
  <c:when test="${sessionScope.jwtResponse eq null}">
    <script>
      $(document).ready(function () {
        $('.btn-buy-ticket-not-signed-in').on('click', function () {
          $('#modalLoginForm').modal('show');
        })
      })
    </script>
  </c:when>
  <c:otherwise>

  </c:otherwise>
</c:choose>

<c:choose>
  <c:when test="${hasErrors eq null}">

  </c:when>
  <c:otherwise>
    <script>
      $(window).on('load', function () {
        $('#modalRegisterForm').modal('show');
      });
    </script>
  </c:otherwise>
</c:choose>

<c:choose>
  <c:when test="${hasLoginErrors eq null}">

  </c:when>
  <c:otherwise>
    <script>
      $(window).on('load', function () {
        $('#modalLoginForm').modal('show');
      });
    </script>
  </c:otherwise>
</c:choose>

<br>

<jsp:include page="footer.jsp"/>
</body>

</html>
