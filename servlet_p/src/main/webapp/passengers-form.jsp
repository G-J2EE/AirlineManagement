<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
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
				<a href="https://www.xadmin.net" class="navbar-brand"> User Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Passengers</a></li> 
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${passenger != null}"> 
					<form action="update" method="post">
				</c:if>
				<c:if test="${passenger == null}"> 
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${passenger != null}"> 
            			Edit Passenger
            		</c:if>
						<c:if test="${passenger == null}"> 
            			Add New Passenger 
            		</c:if>
					</h2>
				</caption>

				<c:if test="${passenger != null}"> 
					<input type="hidden" name="PI" value="<c:out value='${passenger.PI}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Passenger Name</label> <input type="text"
						value="<c:out value='${passenger.PName}' />" class="form-control" 
						name="PName" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Passenger Nationality</label> <input type="text" 
						value="<c:out value='${passenger.PNat}' />" class="form-control" 
						name="PNat">
				</fieldset>

				<fieldset class="form-group">
					<label>Passenger Gender</label> <input type="text" 
						value="<c:out value='${passenger.PGen}' />" class="form-control"
						name="PGen">
				</fieldset>

				<fieldset class="form-group">
					<label>Passenger Number</label> <input type="text" 
						value="<c:out value='${passenger.PPass}' />" class="form-control"
						name="PPass">
				</fieldset>

				<fieldset class="form-group">
					<label>Passenger Address</label> <input type="text" 
						value="<c:out value='${passenger.PAdd}' />" class="form-control"
						name="PAdd">
				</fieldset>

				

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
