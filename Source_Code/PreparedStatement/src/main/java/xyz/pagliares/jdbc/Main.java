package xyz.pagliares.jdbc;

import xyz.pagliares.jdbc.tables.Guests;
import xyz.pagliares.jdbc.util.KeyboardInput;

import java.sql.*;

public class Main {

    private static final String SQL = "SELECT * FROM GUEST WHERE STATE = ?";

    public static void main(String[] args) throws SQLException {

        String state = KeyboardInput.readInputAsString("Enter the State with two Upper Letters (e.g. CA)...:  ");
        ResultSet rs = null;
        System.out.println("--------- LISTING GUESTS FROM " + state.toUpperCase() +  "---------------");

        try (
                Connection conn = DatabaseUtility.getConnection(RDBMS.MYSQL);
                PreparedStatement preStmt = conn.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ) {
            preStmt.setString(1, state.toUpperCase());
            rs = preStmt.executeQuery();

            Guests.displayData(rs);

        } catch (SQLException e) {
            DatabaseUtility.processException(e);
        } finally {
            if (rs != null)
                rs.close();
        }
    }
}
















