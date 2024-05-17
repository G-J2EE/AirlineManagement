<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Airline management</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        /* Custom CSS Styles */
        .navbar {
            background-color: #007bff; /* Bootstrap Primary Color */
        }
        .navbar-brand {
            color: #fff; /* White text color */
        }
        .container {
            margin-top: 20px; /* Add space above the container */
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
                        <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp">logout</a>
                    </li>
                   
                </ul>
            </div>
        </div>
    </nav>
</header>
<br>

<div class="row">
    <div class="container">
        <h3 class="text-center">List of Flights</h3>
        <hr>
        <div class="container text-left">
            <a href="flight-form.jsp" class="btn btn-success">Add New flight</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Flight code</th>
                    <th>Source</th>
                    <th>Destination</th>
                    <th>Take off date</th>
                    <th>nb Seats</th>
                    <th>Amount</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            
                <c:forEach var="flight" items="${listFlights}">
                    <tr>
                        <td><c:out value="${flight.flightcode}" /></td>
                        <td><c:out value="${flight.source_l}" /></td>
                        <td><c:out value="${flight.destination_l}" /></td>
                        <td><c:out value="${flight.takeoffd}" /></td>
                        <td><c:out value="${flight.nbseats}" /></td>
                        <td><c:out value="${flight.amount}" /></td>
                       <td>
                            <c:set var="flightcode" value="${flight.flightcode}" />
                            <form action="EditFlight" method="get">
                                <input type="hidden" name="flightcode" value="${flightcode}" />
                                <button type="submit" class="btn btn-primary">Edit</button>
                            </form>
                         </td>
                         <td>
                         
                            <c:set var="flightcode" value="${flight.flightcode}" />
                            <form action="DeleteFlight" method="get">
                                <input type="hidden" name="flightcode" value="${flightcode}" />
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                           </td>
                        
                    </tr>
                </c:forEach>
            
        </table>
    </div>
</div>

</body>
</html>