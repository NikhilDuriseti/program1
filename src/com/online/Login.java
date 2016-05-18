package com.online;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		try{
			Connection con = DBUtil.getConnection();
			
			String query = "select * from employee where username=? and password=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				response.sendRedirect("home.jsp?uname="+uname);
			else
				response.sendRedirect("login.jsp?message=Please enter valid credentials");
			
		}catch(Exception e){e.printStackTrace();}
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
