
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<%
		String no = request.getParameter("eno");
		String name = request.getParameter("ename");
		double sal = Double.parseDouble(request.getParameter("esal"));
		String gender = request.getParameter("gender");
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		%>
		
		<h3 align="center">Editing Employee</h3>

		<form action="edit" method="post">
			<input type="hidden" name="eno" value="<%=no%>">
			<table align="center">
				<tr>
					<td>Number</td>
					<td><input type="text" value="<%=no%>" disabled="disabled"></td>
				</tr>		
				<tr>
					<td>Name</td>
					<td><input type="text" name="ename" value="<%=name%>"></td>
				</tr>		
				<tr>
					<td>Salary</td>
					<td><input type="text" name="esal" value="<%=sal%>"></td>
				</tr>		
				<tr>
					<td>Gender</td>
					<td>
						<% if(gender.equals("Male")) {%>
						<input type="radio" name="gender" value="Male" checked="checked">Male
						<input type="radio" name="gender" value="FeMale">FeMale
						<% } else { %>
						<input type="radio" name="gender" value="Male">Male
						<input type="radio" name="gender" value="FeMale" checked="checked">FeMale						
						<% } %>
						
					</td>
				</tr>		
				<tr>
					<td>User Name</td>
					<td><input type="text" name="uname" value="<%=uname%>"></td>
				</tr>			
				<tr>
					<td>Password</td>
					<td><input type="password" name="pwd" value="<%=pwd%>"></td>
				</tr>			
				<tr>
					<td></td>
					<td><input type="submit" value="Update"></td>
				</tr>			
			</table>
		</form>
		
	</body>
</html>