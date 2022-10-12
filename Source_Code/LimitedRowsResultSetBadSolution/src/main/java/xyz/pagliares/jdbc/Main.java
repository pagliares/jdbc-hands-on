package xyz.pagliares.jdbc;

import xyz.pagliares.jdbc.tables.Guests;

import java.sql.*;

public class Main {

    /**
     * Drawbacks of this solution (Based on JDBC API, not SQL specification
     * 1 - Need to move ResultSet instantiation from try with resources to the try body
     * 2 - A consequence of the drawback 1 is the need to include a finally block to close the ResultSet,
     * without benefits provided by auto closing of the resource introduced in Java 7
     * 3 - See next example for a better solution (using SQL, not JDBC API)
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {

        ResultSet rs = null;
        try (
                Connection conn = DatabaseUtility.getConnection(RDBMS.MYSQL);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ) {
            stmt.setMaxRows(10);
            rs = stmt.executeQuery("SELECT * FROM GUEST");
            Guests.displayData(rs);

        } catch (SQLException e) {
            DatabaseUtility.processException(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
    }
}
















