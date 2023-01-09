package ssk3408.project.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {

	private static String hostname = "localhost";
	private static int port = 3306;
	private static String db = "budget_tracker";
	private static final String URL = "jdbc:mysql://"+hostname+":"+port+"/"+db;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	private static Connection connection = null;

	public static Connection openConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				//connection.setAutoCommit(false); 
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
	}
	
}