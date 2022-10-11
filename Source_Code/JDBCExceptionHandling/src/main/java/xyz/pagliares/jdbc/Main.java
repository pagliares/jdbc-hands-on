package xyz.pagliares.jdbc;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {

		try (Connection conn = DatabaseUtility.getConnection(RDBMS.MYSQL);
			 Statement	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			 ResultSet rs = stmt.executeQuery("SELECT * FROM GUEST");
		){

			System.out.println("Successfully connected to MySQL!");
			System.out.println("Executing the query SELECT * FROM GUEST");
			rs.last();
			System.out.println("Number of rows returned: " + rs.getRow());

		} catch (SQLException e) {
			System.err.println(e);
		}
	}
}










