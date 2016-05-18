package com.online;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/remove")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int no = Integer.parseInt(request.getParameter("eno"));
		
		try{
			Connection con = DBUtil.getConnection();
			
			String query = "delete from employee where eno = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, no);
			
			int status = ps.executeUpdate();
			if(status > 0)
				response.sendRedirect("getEmployees");
			
			
		}catch(Exception e){e.printStackTrace();}
		
		
	}


}
