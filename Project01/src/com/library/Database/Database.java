package com.library.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private static String DB_SERVER = "localhost";
	private static String DB_USER = "root";
	private static String DB_PASS = "";
	private static String DB_NAME = "mydatabase";

	private static Connection connection;
	private static String URL = "jdbc:mysql://" + DB_SERVER + "/" + DB_NAME;

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, DB_USER, DB_PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
