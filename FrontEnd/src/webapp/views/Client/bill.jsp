<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
<%--    <link href="../../style/Home.css" rel="stylesheet" type="text/css">--%>
    <title>Thanh toán vé xem phim</title>
</head>
<body>
<div class="container my-4">
    <h2 class="text-left mb-4">Thanh toán hóa đơn</h2>
    <div class="row">
        <div class="col-md-8">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-6">
                            <h4 class="card-title">Thông tin phim</h4>
                            <div class="film-info">
                                <p>Đạo diễn: Jon Watts</p>
                                <p>Diễn viên: Tom Holland, Zendaya</p>
                                <p>Ngày khởi chiếu: 13 tháng 12 năm 2021</p>
                                <p>Thể loại: Phim Hành Động </p>
                                <p>Thời lượng: 148 Phút</p>
                                <p>Ngôn ngữ: Tiếng Anh</p>
                                <p>Note: phim hành động hay nhất 2021 </p>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-body">
                                    <div class="video-container">
<%--                                        <iframe src="https://www.youtube.com/embed/Oh6T_iMvoRs?start=11"--%>
<%--                                                frameborder="0"--%>
<%--                                                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"--%>
<%--                                                allowfullscreen></iframe>--%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h3 class="card-title">Chi nhánh rạp phim</h3>
                    <div class="cinema-address">
                        <!-- Chèn ảnh chi nhánh rạp phim tại đây -->
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="d-flex justify-content-center mt-4">
            <button type="submit" class="btn btn-primary">Thanh toán</button>
    </div>
</div>

</body>
</html>
