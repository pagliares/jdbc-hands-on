package xyz.pagliares.jdbc;

import java.sql.*;

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
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
			System.out.println("Successfully connected to MySQL!");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			System.out.println("Executing the query SELECT * FROM admin");
			rs = stmt.executeQuery("SELECT * FROM admin");
			rs.last();
			System.out.println("Number of rows returned: " + rs.getRow());

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
}










