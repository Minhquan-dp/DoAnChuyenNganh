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
    <link href="../../static/css/style/Seats.css" rel="stylesheet" type="text/css">

    <title>Chọn Chỗ Ngồi</title>
</head>

<body>

<jsp:include page="header.jsp"/>

<div class="container">
    <h1>Chọn Chỗ Ngồi</h1>
</div>
<div class="screen-container">
    <h2>Màn Hình</h2>
    <div class="screen"></div>
    <br><br><br>
    <p style="color: red">
        ${bookedError}
    </p>
    <div class="container">
        <form action="bill" method="post">
            <table style="width:100%">
                <tr>
                    <th></th>
                    <th>1</th>
                    <th>2</th>
                    <th>3</th>
                    <th>4</th>
                    <th>5</th>
                    <th>6</th>
                    <th>7</th>
                    <th>8</th>
                </tr>

                <tr>
                    <th>A</th>
                    <c:forEach items="${listA}" var="seat">
                        <c:choose>
                            <c:when test="${seat.isOccupied eq 1}">
                                <th><input type="checkbox" class="largerCheckbox" name="seats" value="${seat.id}" checked disabled>
                                </th>
                            </c:when>
                            <c:otherwise>
                                <th><input type="checkbox" class="largerCheckbox" name="seats" value="${seat.id}">
                                </th>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tr>

                <tr>
                    <th>B</th>
                    <c:forEach items="${listB}" var="seat">
                        <c:choose>
                            <c:when test="${seat.isOccupied eq 1}">
                                <th><input type="checkbox" class="largerCheckbox" name="seats" value="${seat.id}" checked disabled>
                                </th>
                            </c:when>
                            <c:otherwise>
                                <th><input type="checkbox" class="largerCheckbox" name="seats" value="${seat.id}">
                                </th>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tr>

                <tr>
                    <th>C</th>
                    <c:forEach items="${listC}" var="seat">
                        <c:choose>
                            <c:when test="${seat.isOccupied eq 1}">
                                <th><input type="checkbox" class="largerCheckbox" name="seats" value="${seat.id}" checked disabled>
                                </th>
                            </c:when>
                            <c:otherwise>
                                <th><input type="checkbox" class="largerCheckbox" name="seats" value="${seat.id}">
                                </th>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tr>
                <tr>
                    <th>D</th>
                    <c:forEach items="${listD}" var="seat">
                        <c:choose>
                            <c:when test="${seat.isOccupied eq 1}">
                                <th><input type="checkbox" class="largerCheckbox" name="seats" value="${seat.id}" checked disabled>
                                </th>
                            </c:when>
                            <c:otherwise>
                                <th><input type="checkbox" class="largerCheckbox" name="seats" value="${seat.id}">
                                </th>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                </tr>
                <tr>
                    <th>E</th>
                    <c:forEach items="${listE}" var="seat">
                        <c:choose>
                            <c:when test="${seat.isOccupied eq 1}">
                                <th><input type="checkbox" class="largerCheckbox" name="seats" value="${seat.id}" checked disabled>
                                </th>
                            </c:when>
                            <c:otherwise>
                                <th><input type="checkbox" class="largerCheckbox" name="seats" value="${seat.id}">
                                </th>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tr>
            </table>
            <br>
            <br>
            <input type="submit" class="btn btn-outline-danger btn-block" value="Tiếp Tục">
        </form>
    </div>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>