<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Passenger Management Application</title>
    <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
</head>
<body>

    <header>
        <nav class="navbar navbar-expand-md navbar-dark"
            style="background-color: blue">
            <div>
                <a href="https://www.xadmin.net" class="navbar-brand"> Passenger Management Application </a>
            </div>

            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Passengers</a></li>
            </ul>
        </nav>
    </header>
    <br>

    <div class="row">
        <div class="container">
            <h3 class="text-center">List of Passengers</h3>
            <hr>
            <div class="container text-left">
                <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Passenger</a>
            </div>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Nationality</th>
                        <th>Gender</th>
                        <th>Passport Number</th>
                        <th>Address</th>
                        
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="passenger" items="${listPassengers}">
                        <tr>
                            <td><c:out value="${passenger.PI}" /></td>
                            <td><c:out value="${passenger.PName}" /></td>
                            <td><c:out value="${passenger.PNat}" /></td>
                            <td><c:out value="${passenger.PGen}" /></td>
                            <td><c:out value="${passenger.PPass}" /></td>
                            <td><c:out value="${passenger.PAdd}" /></td>
                            
                            
                            <td>
                                <a href="edit?id=<c:out value='${passenger.PI}' />">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="delete?id=<c:out value='${passenger.PI}' />">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
