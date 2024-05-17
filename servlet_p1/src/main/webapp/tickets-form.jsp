
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
    <title>Ticket Management Application</title>
    <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
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
                        <a class="nav-link" href="<%=request.getContextPath()%>/Flight">Flights</a>
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
<br>

<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${ticket != null}"> 
                <form action="<%=request.getContextPath()%>/UpdateTicketServlet" method="post">
            </c:if>
            <c:if test="${ticket == null}"> 
                <form action="<%=request.getContextPath()%>/InsertTicketServlet" method="post">
            </c:if>

            <caption>
                <h2>
                    <c:if test="${ticket != null}"> 
                        Edit Ticket
                    </c:if>
                    <c:if test="${ticket == null}"> 
                        Add New Ticket 
                    </c:if>
                </h2>
            </caption>

            <c:if test="${ticket != null}"> 
                <input type="hidden" name="ticketId" value="<c:out value='${ticket.ticketId}' />" />
            </c:if>

            <fieldset class="form-group">
                <label>Passenger Name</label> 
                <input type="text" value="<c:out value='${ticket.PName}' />" class="form-control" name="pName" required="required">
            </fieldset>

            <fieldset class="form-group">
                <label>Flight Code</label> 
                <input type="text" value="<c:out value='${ticket.flCode.flightcode}' />" class="form-control" name="flightCode">
            </fieldset>

            <fieldset class="form-group">
                <label>Passenger Gender</label> 
                <input type="text" value="<c:out value='${ticket.PGen}' />" class="form-control" name="pGen">
            </fieldset>

            <fieldset class="form-group">
                <label>Passport Number</label> 
                <input type="text" value="<c:out value='${ticket.PPass}' />" class="form-control" name="pPass">
            </fieldset>

            <fieldset class="form-group">
                <label>Amount</label> 
                <input type="text" value="<c:out value='${ticket.amount}' />" class="form-control" name="amount">
            </fieldset>

            <fieldset class="form-group">
                <label>Nationality</label> 
                <input type="text" value="<c:out value='${ticket.nationality}' />" class="form-control" name="nationality">
            </fieldset>

            <button type="submit" class="btn btn-success">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
