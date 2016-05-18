<%@page import="com.online.Employee"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
	
		<% List<Employee> listOfEmployees  = (List<Employee>)request.getAttribute("listOfEmployees"); %>
		
		<h4 align="center">List of Employees</h4>
		
		<table align="center" border="1"> 
			<tr>
				<th>Number</th>
				<th>Name</th>
				<th>Salary</th>
				<th>Gender</th>
				<th>User Name</th>
				<th> Actions</th>
				
			</tr>
			<% for(Employee emp : listOfEmployees){ %>
				<tr>
					<td><%= emp.getEno() %></td>
					<td><%= emp.getEname() %></td>
					<td><%= emp.getEsal() %></td>
					<td><%= emp.getGender() %></td>
					<td><%= emp.getUsername() %></td>
					<td><a href="edit.jsp?eno=<%=emp.getEno()%>&ename=<%=emp.getEname()%>&esal=<%=emp.getEsal()%>&gender=<%=emp.getGender()%>&uname=<%=emp.getUsername()%>&pwd=<%=emp.getPassword()%>">Edit</a></td>
					<td><a href="remove?eno=<%=emp.getEno()%>" onclick="return confirm('Do you want to delete?')">Delete</a></td>
				</tr>
			<%} %>
		</table>
		
	</body>
</html> 