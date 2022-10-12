package xyz.pagliares.jdbc;

import xyz.pagliares.jdbc.tables.Guests;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {

		try (Connection conn = DatabaseUtility.getConnection(RDBMS.MYSQL);
			 Statement	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			 ResultSet rs = stmt.executeQuery("SELECT * FROM GUEST");
		){

			Guests.displayData(rs);

		} catch (SQLException e) {
			DatabaseUtility.processException(e);
		}
	}
}










