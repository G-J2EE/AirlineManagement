<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        /* Navbar */
        .navbar {
            background-color: #000;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .navbar-brand, .nav-link {
            color: #fff !important;
        }

       h3 {
            color: #007bff; /* Primary Color */
        }
        .btn-success {
            background-color: #28a745; /* Success Color */
            border-color: #28a745;
        }
        .btn-success:hover {
            background-color: #218838; /* Darker shade of success color */
        }
        .table th, .table td {
            vertical-align: middle; /* Align table cells vertically centered */
        }
        .table th {
            background-color: #007bff; /* Primary Color */
            color: #fff; /* White text color */
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-md navbar-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="<%= request.getContextPath() %>/Homme.jsp">Airline Management</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<%= request.getContextPath() %>/passengers">Passengers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%= request.getContextPath() %>/flights">Flights</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%= request.getContextPath() %>/Tickets">Tickets</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%= request.getContextPath() %>/login.jsp">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Jumbotron -->
<!-- Jumbotron -->
<br><br><br><br><br><br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:choose>
                <c:when test="${flight != null}">
                    <form action="<%=request.getContextPath()%>/UpdateFlight" method="post">
                </c:when>
                <c:otherwise>
                    <form action="<%=request.getContextPath()%>/InserFlight" method="post">
                </c:otherwise>
            </c:choose>

            <caption>
                <h2>
                    <c:choose>
                        <c:when test="${flight != null}">
                            Edit Flight
                        </c:when>
                        <c:otherwise>
                            Add New Flight
                        </c:otherwise>
                    </c:choose>
                </h2>
            </caption>

            <c:if test="${flight != null}">
                <input type="hidden" name="flightcode" value="<c:out value='${flight.flightcode}' />" />
            </c:if>

            <fieldset class="form-group">
                <label>Flight code</label>
                <input type="text" value="<c:out value='${flight.flightcode}' />" class="form-control" name="flightcode" required>
            </fieldset>

            <fieldset class="form-group">
                <label>Source</label>
                <input type="text" value="<c:out value='${flight.source_l}' />" class="form-control" name="source_l" required>
            </fieldset>

            <fieldset class="form-group">
                <label>Destination</label>
                <input type="text" value="<c:out value='${flight.destination_l}' />" class="form-control" name="destination_l">
            </fieldset>

            <fieldset class="form-group">
                <label>Takeoff date</label>
                <input type="date" value="<c:out value='${flight.takeoffd}' />" class="form-control" name="takeoffd">
            </fieldset>

            <fieldset class="form-group">
                <label>Nb Seats</label>
                <input type="text" value="<c:out value='${flight.nbseats}' />" class="form-control" name="nbseats">
            </fieldset>

            <fieldset class="form-group">
                <label>Amount</label>
                <input type="text" value="<c:out value='${flight.amount}' />" class="form-control" name="amount">
            </fieldset>

            <button type="submit" class="btn btn-success">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>