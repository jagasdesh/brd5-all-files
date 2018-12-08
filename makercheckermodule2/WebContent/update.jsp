<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>updatedata</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		request.getAttribute("updateresult");
	%>
	<div class="container">
		<h1>UPDATE DATA FORM</h1>
		<form name="insert" action="updatedatadb" method="service">

			<div class="form-group">
				<label for="Customer Code">Customer Code:</label> <input type="text"
					class="form-control" id="Customer Code" name="CustomerCode"
					value="${updateresult.getString(1)}">
			</div>

			<div class="form-group">
				<label for="Customer Name">Customer Name:</label> <input type="text"
					class="form-control" id="Customer Name" name="CustomerName"
					value="${updateresult.getString(2)}">
			</div>

			<div class="form-group">
				<label for="Customer Address 1 ">Customer Address 1:</label>
				<textarea class="form-control" rows="5" id="comment"
					class="form-control" id="Customer Address 1"
					name="CustomerAddress1">${updateresult.getString(3)}</textarea>

			</div>
			<div class="form-group">
				<label for="Customer Address 2 ">Customer Address 2:</label>
				<textarea class="form-control" rows="5" id="comment"
					class="form-control" id="Customer Address 2 "
					name="CustomerAddress2">${updateresult.getString(4)}</textarea>
			</div>
			<div class="form-group">
				<label for="Customer Pin Code">Customer Pin Code:</label> <input
					type="text" class="form-control" id="Customer Pin Code"
					name="CustomerPinCode" value="${updateresult.getString(5)}">
			</div>
			<div class="form-group">
				<label for=" E-mail address"> E-mail address:</label> <input
					type="text" class="form-control" id=" E-mail address"
					name="Emailaddress" value="${updateresult.getString(6)}">
			</div>
			<div class="form-group">
				<label for="Contact Number">Contact Number:</label> <input
					type="text" class="form-control" id="Contact Number"
					name="ContactNumber" value="${updateresult.getString(7)}">
			</div>
			<div class="form-group">
				<label for="Primary Contact Person ">Primary Contact Person
					:</label> <input type="text" class="form-control"
					id="Primary Contact Person " name="PrimaryContactPerson"
					value="${updateresult.getString(8)}">
			</div>
			<div class="form-group">
				<label for="Active/Inactive Flag">Active/Inactive Flag: <select
					name="status" id="status" value="${updateresult.getString(9)}">
						<option value='none' selected>Choose a type</option>
						<option value="a" name="a">active</option>
						<option value="i" name="i">inactive</option>

				</select>
			</div>
			<center>
				<button type="submit">Submit</button>
			</center>

		</form>
	</div>


</body>
</html>