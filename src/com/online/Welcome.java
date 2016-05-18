package com.online;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")	// URL
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
		System.out.println("Init is called");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet is called");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost is called");
		
	}

	public void destroy() {
		System.out.println("Destroy is called");
	}

}
