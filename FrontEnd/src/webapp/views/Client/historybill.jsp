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
    <title>Lịch Sử Mua Vé </title>
    <style>
        /* Custom CSS */
        body {
            background-color: #fff;
        }
        .table thead th {
            background-color: #337ab7;
            color: white;
        }
        .table tbody tr:nth-child(odd) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="text-left mb-4">Lịch sử mua vé</h2>
        <div class="table-responsive">
            <table class="table table-light">
                <thead>
                <tr>
                    <th scope="col">Tên Phim</th>
                    <th scope="col">Tên Chi Nhánh</th>
                    <th scope="col">Giờ Chiếu</th>
                    <th scope="col">Tên Phòng</th>
                    <th scope="col">Ghế</th>
                    <th scope="col">Giờ Mua</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">Spider-Man: No Way Home</th>
                    <td>CineStar Quốc Thanh</td>
                    <td>19:00, 17/12/2021</td>
                    <td>Rạp 3D</td>
                    <td>A5, A6</td>
                    <td>18:30, 17/12/2021</td>
                </tr>
                <tr>
                    <th scope="row">Spider-Man: No Way Home</th>
                    <td>CineStar Quốc Thanh</td>
                    <td>19:00, 17/12/2021</td>
                    <td>Rạp 3D</td>
                    <td>A5, A6</td>
                    <td>18:30, 17/12/2021</td>
                </tr>
                <tr>
                    <th scope="row">Spider-Man: No Way Home</th>
                    <td>CineStar Quốc Thanh</td>
                    <td>19:00, 17/12/2021</td>
                    <td>Rạp 3D</td>
                    <td>A5, A6</td>
                    <td>18:30, 17/12/2021</td>
                </tr>
                </tbody>
            </table>
        </div>
        <br/>
        <button class="btn btn-primary center-block">Home</button>
</div>


</body>
</html>

