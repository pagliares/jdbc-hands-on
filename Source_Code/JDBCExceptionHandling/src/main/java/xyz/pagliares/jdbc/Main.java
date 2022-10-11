package xyz.pagliares.jdbc;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DatabaseUtility.getConnection(RDBMS.MYSQL);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("SELECT GUEST_ID, FIRST_NAME FROM GUEST");

			rs.last();
			System.out.println("Number of rows: " + rs.getRow());

		} catch (SQLException e) {
			DatabaseUtility.processException(e);
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










