package com.online;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	static Connection con;
	
	public static Connection getConnection(){
		try{
			
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "system";
			String password = "manager";
			con = DriverManager.getConnection(url, username, password);
			
		}catch(Exception e){e.printStackTrace();}
		
		return con;
	}
	

}
