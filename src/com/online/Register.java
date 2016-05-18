package com.online;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("eno"));
		String name = request.getParameter("ename");
		double sal = Double.parseDouble(request.getParameter("esal"));
		String gender = request.getParameter("gender");
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		try{
			Connection con = DBUtil.getConnection();
			
			String query = "insert into employee values(?,?,?,?,?,?)";
			PreparedStatement  ps = con.prepareStatement(query);
			ps.setInt(1, no);
			ps.setString(2, name);
			ps.setDouble(3, sal);
			ps.setString(4, gender);
			ps.setString(5, uname);
			ps.setString(6, pwd);
			
			int status = ps.executeUpdate();
			
			//PrintWriter out = response.getWriter();
			if(status > 0){
				//out.println("Employee "+no+ " created...");
				
				response.sendRedirect("login.jsp");
			}
			
		}catch(Exception e){e.printStackTrace();}
		
		
	}

}
