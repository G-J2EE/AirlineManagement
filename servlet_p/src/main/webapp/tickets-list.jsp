<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Airline management</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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

<div class="row">
    <div class="container">
        <h3 class="text-center">List of Tickets</h3>
        <hr>
        <div class="container text-left">
            <a href="tickets-form.jsp" class="btn btn-success">Add New Ticket</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Ticket ID</th>
                    <th>Passenger Name</th>
                    <th>Flight Code</th>
                    <th>Gender</th>
                    <th>Passport Number</th>
                    <th>Amount</th>
                    <th>Nationality</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ticket" items="${listTickets}">
                    <tr>
                        <td><c:out value="${ticket.ticketId}" /></td>
                        <td><c:out value="${ticket.PName}" /></td>
                        <td><c:out value="${ticket.flCode.flightcode}" /></td>
                        <td><c:out value="${ticket.PGen}" /></td>
                        <td><c:out value="${ticket.PPass}" /></td>
                        <td><c:out value="${ticket.amount}" /></td>
                        <td><c:out value="${ticket.nationality}" /></td>
                        <td>
                            <c:set var="ticketId" value="${ticket.ticketId}" />
                            <form action="EditTicketServlet" method="GET">
                                <input type="hidden" name="ticketId" value="${ticketId}" />
                                <button type="submit" class="btn btn-primary">Edit</button>
                            </form>
                        </td>
                        <td>
                            <c:set var="ticketId" value="${ticket.ticketId}" />
                            <form action="DeleteTicketServlet" method="GET">
                                <input type="hidden" name="ticketId" value="${ticketId}" />
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
