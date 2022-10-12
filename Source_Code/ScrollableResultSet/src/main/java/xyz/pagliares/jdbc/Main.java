package xyz.pagliares.jdbc;

import xyz.pagliares.jdbc.tables.Guests;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {

		try (Connection conn = DatabaseUtility.getConnection(RDBMS.MYSQL);
			 Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			 // The statement below call the createStatement method without arguments.
			 // In this way it is defined by the database engine whether by default the
			 // ResultSet obtained is scrollable of forward only.
			 // If the default is forward only, this example code will throw an exception
			 // Good practice : explicitly indicate a scrollable ResultSet with the constant
			 // ResultSet.TYPE_SCROLL_INSENSITIVE when creating a Statement
			 //	Statement stmt = conn.createStatement();

			 ResultSet rs = stmt.executeQuery("SELECT * FROM GUEST");
		) {

			rs.last();
			System.out.println("Number of rows: " + rs.getRow());

			rs.first();
			System.out.println("The first guest is " + rs.getString("FIRST_NAME"));

			rs.last();
			System.out.println("The last guest is " + rs.getString("FIRST_NAME"));

			rs.absolute(5);
			System.out.println("The 5th guest is " + rs.getString("FIRST_NAME"));

		} catch (SQLException e) {
			DatabaseUtility.processException(e);
		}
	}
}
















