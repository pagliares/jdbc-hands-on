package xyz.pagliares.jdbc;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {

		// The commented line below was necessary until Java SE 5 in order to load the driver in memory
		// Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
			conn = DatabaseUtility.getConnection(RDBMS.MYSQL);

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










