package xyz.pagliares.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	private static final String USERNAME = "florentino";
	private static final String PASSWORD = "123456";
	private static final String CONNECTION_STRING ="jdbc:mysql://localhost:3306/hostelapp_jdbc";

	// If you are configuring a connection pool (not shown in this course) in an app server (e.g Glassfish, Payara)
	// and are getting an error with the connection String, try to include ?useSSL=true as shown below:
    // private static final String CONNECTION_STRING ="jdbc:mysql://localhost:3306/hostelapp_jdbc?useSSL=true";

	public static void main(String[] args) throws SQLException {

		// The commented line below was necessary until Java SE 5 in order to load the driver in memory
		// Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
			System.out.println("Successfully connected to MySQL!");
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
