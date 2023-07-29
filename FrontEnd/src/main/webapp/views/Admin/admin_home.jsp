<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../../../static/css/admin/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../../../static/css/admin/admin.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,900" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/static/js/admin.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>

    <title>Dashboard :: Admin </title>
</head>
<body onload="startTime()">

<div class="admin-dashboard">
    <div class="container-fluid">
        <nav class="navbar navbar-light bg-light justify-content-end">
            <a class="btn btn-primary ml-auto" href="/">Trở về trang chủ</a>
        </nav>


        <div class="admin-rg">
            <div class="row">
                <div class="col-md-8 admin-box">
                    <!-- Nội dung hiển thị 5 hình ảnh theo dạng 3 cột -->
                </div>
            </div>
        </div>


        <div class="admin-rg">
            <div class="row">
                <div class="col-md-8 admin-box">
                    <div class="row">
                        <div class="col-md-4">
                            <a href="/admin_home/manage_movie">
                                <div class="option-box">
                                    <div class="option-box-img">
                                        <img src="<%=request.getContextPath()%>/static/images/admin/manage-movies.png" width="100%">
                                    </div>
                                    <h5>MANAGE MOVIES</h5>
                                </div>
                            </a>
                        </div>
<%--                        <div class="col-md-4">--%>
<%--                            <a href="/api/manage_schedule">--%>
<%--                                <div class="option-box">--%>
<%--                                    <div class="option-box-img">--%>
<%--                                        <img src="<%=request.getContextPath()%>/static/images/admin/manage-schedule.png" width="100%">--%>
<%--                                    </div>--%>
<%--                                    <h5>MANAGE SCHEDULES</h5>--%>
<%--                                </div>--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-4">--%>
<%--                            <a href="/admin_home/manage_room">--%>
<%--                                <div class="option-box">--%>
<%--                                    <div class="option-box-img">--%>
<%--                                        <img src="<%=request.getContextPath()%>/static/images/admin/manage-cinemas.png" width="100%">--%>
<%--                                    </div>--%>
<%--                                    <h5>MANAGE ROOM</h5>--%>
<%--                                </div>--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="row">--%>
<%--                        <div class="col-md-4">--%>
<%--                            <a href="/api/manage_branch">--%>
<%--                                <div class="option-box">--%>
<%--                                    <div class="option-box-img">--%>
<%--                                        <img src="<%=request.getContextPath()%>/static/images/admin/manage-branch.png" width="100%">--%>
<%--                                    </div>--%>
<%--                                    <h5>MANAGE BRANCH</h5>--%>
<%--                                </div>--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-4">--%>
<%--                            <a href="/api/manage_ticket">--%>
<%--                                <div class="option-box">--%>
<%--                                    <div class="option-box-img">--%>
<%--                                        <img src="<%=request.getContextPath()%>/static/images/admin/manage-ticket.png" width="100%">--%>
<%--                                    </div>--%>
<%--                                    <h5>MANAGE TICKET</h5>--%>
<%--                                </div>--%>
<%--                            </a>--%>
<%--                        </div>--%>
                    </div>
                </div>
            </div>
        </div>


    </div>
</div>
</body>
</html>
