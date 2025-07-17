
<%@page import="com.ps.StudentApp.DTO.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.heading {
	color: #000080;
}

.sub {
	color: #1e90ff;
}

.success {
	color: green;
}

.failure {
	color: red;
}
</style>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body bgcolor='#add8e6'>

	<div align="center">
		<h1 class="heading">Pentagon Space</h1>
		<h3 class="sub">Update your account</h3>
		<!-- Calling student object from session object -->
		<%
		Student s = (Student) session.getAttribute("student");
		%>

		<form action="updateAccount" method="post">
			<table>
				<tr>
					<td><b>Enter your Name:</b></td>
					<td><input type="text" name="name" value="<%=s.getName()%>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the Phone number:</b></td>
					<td><input type="tel" name="phone" value="<%=s.getPhone()%>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the Mail ID:</b></td>
					<td><input type="email" name="mail" value="<%=s.getMail()%>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the Branch:</b></td>
					<td><input type="text" name="branch"
						value="<%=s.getBranch()%>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the Location:</b></td>
					<td><input type="text" name="loc" value="<%=s.getLoc()%>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><input class="btn btn-success" type="submit"
						value="update account"></td>
					<td><a class="btn btn-primary" href="Dashboard.jsp">Back</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>