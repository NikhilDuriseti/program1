package com.online;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("eno"));
		String name = request.getParameter("ename");
		double sal = Double.parseDouble(request.getParameter("esal"));
		String gender = request.getParameter("gender");
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		try{
			Connection con = DBUtil.getConnection();
			
			String query = "update employee set ename=?, esal=?, gender=?, username=?, password=? where eno=?";
			PreparedStatement  ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setDouble(2, sal);
			ps.setString(3, gender);
			ps.setString(4, uname);
			ps.setString(5, pwd);
			ps.setInt(6, no);

			int status = ps.executeUpdate();
			
			if(status > 0){				
				response.sendRedirect("getEmployees");
			}
			
		}catch(Exception e){e.printStackTrace();}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
