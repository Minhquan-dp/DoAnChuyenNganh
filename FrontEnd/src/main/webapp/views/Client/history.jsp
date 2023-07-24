<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link href="../../style/History.css" rel="stylesheet" type="text/css">
    <title>Lịch sử thanh toán</title>

</head>

<body>

<jsp:include page="header.jsp"/>

<div class="container-fluid mt-5 pt-5">
    <h2>Lịch sử mua vé </h2>
    <div>
        <table style="width:100%">
            <tr>
                <th>Tên Phim</th>
                <th>Tên Chi Nhánh</th>
                <th>Giờ Chiếu</th>
                <th>Tên Phòng</th>
                <th>Ghế</th>
                <th>Giờ Mua</th>

            </tr>
<%--            dùng for duyệt data đẩy lên FE--%>
<%--            data được lưu trong listTickets--%>
<%--            lấy giá trị theo từng bảng--%>
            <c:forEach items="${listTickets}" var="ticket">
                <tr>
                    <td>${ticket.schedule.movie.name}</td>
                    <td>${ticket.schedule.branch.name}</td>
                    <td>${ticket.schedule.startTime} ${ticket.schedule.startDate}</td>
                    <td>${ticket.schedule.room.name}</td>
                    <td>${ticket.seat.name}</td>
                    <td>${ticket.bill.createdTime}</td>

                </tr>
            </c:forEach>


        </table>

    </div>
    <br>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>