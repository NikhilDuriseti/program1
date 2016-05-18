package com.online;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getEmployees")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			Connection con = DBUtil.getConnection();
			
			String query = "select * from employee";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			List<Employee> employees = new ArrayList<Employee>();
			while(rs.next()){
				Employee emp = new Employee();
				emp.setEno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setEsal(rs.getDouble(3));
				emp.setGender(rs.getString("gender"));
				emp.setUsername(rs.getString(5));
				emp.setPassword(rs.getString(6));
				
				employees.add(emp);
			}
			
			request.setAttribute("listOfEmployees", employees);
			RequestDispatcher rd = request.getRequestDispatcher("viewEmployees.jsp");
			rd.forward(request, response);
			
		}catch(Exception e){e.printStackTrace();}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
