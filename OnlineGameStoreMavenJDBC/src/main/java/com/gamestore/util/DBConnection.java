package com.gamestore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
	static Connection connection;
	public static Connection openConnection() {
		String url = "jdbc:mysql://localhost:3306/mysql";
		String username = "root";
		String password ="admin@123";
		try { 
			connection = DriverManager.getConnection(url, username, password);
				PreparedStatement statement=connection.prepareStatement(Queries.CREATEQUERY);
				PreparedStatement userStatement=connection.prepareStatement(Queries.CREATEUSERQUERY);
				PreparedStatement purchaseStatement=connection.prepareStatement(Queries.CREATEPURCHASEQUERY);
			//create table query
			statement.execute();
			userStatement.execute();
			purchaseStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		return connection;
		}
	public static void closeConnection() {
		try {
			if(connection!=null)
				connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
