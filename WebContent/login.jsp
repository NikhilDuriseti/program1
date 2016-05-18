
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		 <link href="style.css" type="text/css" rel="stylesheet"/>
          <link href="bootstrap.css" type="text/css" rel="stylesheet"/>
        <link rel="icon" href="./10.ico" type="image/ico"/>
	</head>
	<body>
	<div id="main">
            <div id="container">

                <div id="header">
                    <img src="mtm.png"  />
                </div>
                <div id="content">

                    <div id="content_rt" style="width:900px;">
	
		<% String msg = request.getParameter("message"); %>
		
		<h3 align="center">Login Page</h3>
		
		<% if(msg != null){ %>
			<h5 align="center" style="color: red"><%= msg %></h5>	
		<% } %>
		
		<form action="check" method="post">
			<table align="center">
				<tr>
					<td>User Name</td>
					<td><input type="text" name="uname"></td>
				</tr>			
				<tr>
					<td>Password</td>
					<td><input type="password" name="pwd"></td>
				</tr>			
				<tr>
					<td></td>
					<td><input type="submit" value="Login"></td>
				</tr>	
				<tr>
					<td></td>
					<td><a href="createEmployee.html">New Employee</a></td>
				</tr>		
			</table>
		</form>
		 </div>
                </div>
                <div id="clear"></div>
                <div id="footer">
                </div>
            </div>
        </div>
	
	</body>
</html>