package com.hexaware.finance.util;

import java.sql.*;


public class DBUtil {
	 private static final String URL = "jdbc:mysql://localhost:3306/financeManagement";
	    private static final String USER = "root";
	    private static final String PASSWORD = "saravana";

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
	/*public static Connection con;
	public static Connection getConnection() {
		if(con==null) {
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/financeManagement","root","saravana");
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return con;
		
		
	}
	public static void closeConnection() {
		try {
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	}


