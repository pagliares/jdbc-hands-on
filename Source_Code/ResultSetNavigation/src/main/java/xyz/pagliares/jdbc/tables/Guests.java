package xyz.pagliares.jdbc.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class Guests {

    public static void displayData(ResultSet rs) throws SQLException {
        while (rs.next()) {
            StringBuffer buffer = new StringBuffer();

            buffer.append("Guest ID......: " + rs.getInt("GUEST_ID") + "\n");
            buffer.append("Full name.....: " + rs.getString("FIRST_NAME") + " ");
            buffer.append(rs.getString("LAST_NAME") + "\n");
            buffer.append("Email.........: " + rs.getString("EMAIL_ADDRESS") + "\n");
            buffer.append("Address.......: " + rs.getString("ADDRESS") + "\n");
            buffer.append("Country.......: " + rs.getString("COUNTRY") + "\n");
            buffer.append("State.........: " + rs.getString("STATE") + "\n");
            buffer.append("Phone number..: " + rs.getString("PHONE_NUMBER"));

            System.out.println(buffer.toString());
            System.out.println("------------------------------------------------");

        }
    }
}