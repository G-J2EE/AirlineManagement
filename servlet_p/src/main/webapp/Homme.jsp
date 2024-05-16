<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
    <%@include file="all_component/all_css.jsp" %>
    <style type="text/css">
     
        
        
        .button-section {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: row;
        }
        .button-section .btn {
            margin: 10px;
        }
    </style>
</head>
<header>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="<%=request.getContextPath()%>/Homme.jsp">Airline Management</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/passengers">Passengers</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/flights">Flights</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/Tickets">Tickets</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<body>
    <div class="container-fluid back-img">
        <div class="image-section">
        <img src="../image/plane.jpg" width="1250" height="400">
        </div>
        <div class="button-section">
            <button type="button"   class="btn btn-primary"><a href="<%=request.getContextPath()%>/passengers" >Passangers</a></button>
            <button type="button"  class="btn btn-secondary"><a href="<%=request.getContextPath()%>/flights"> Flights</a></button>
            <button type="button"  class="btn btn-success"><a  href="<%=request.getContextPath()%>/Tickets">Tickets</a> </button>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJzvW+ImXKz7XMf3J2Z4xJF5rLqY5bFz5tN5b8te5e9ctuCf4" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-jjSmVgyd0p3pXB1rRibZUAYoIIyLbM5L6bF0s3FpB5JpNvKz7a/g0fFJGOVR4Md" crossorigin="anonymous"></script>
</body>
</html>
