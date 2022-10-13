package xyz.pagliares.jdbc.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class Guests {

    public static void displayData(ResultSet rs) throws SQLException {

        rs.last();
        int numberOfRows = rs.getRow();
        if (numberOfRows == 0) {
            System.out.println("No guests were found");
        } else {
            System.out.println("Number of guests: " + numberOfRows);
            rs.beforeFirst();

            while (rs.next()) {
                StringBuffer buffer = new StringBuffer();

                buffer.append("Guest ID......: " + rs.getObject("GUEST_ID", String.class) + "\n");
                buffer.append("Full name.....: " + rs.getObject("FIRST_NAME", String.class) + " ");
                buffer.append(rs.getObject("LAST_NAME", String.class) + "\n");
                buffer.append("Email.........: " + rs.getObject("EMAIL_ADDRESS", String.class) + "\n");
                buffer.append("Address.......: " + rs.getObject("ADDRESS", String.class) + "\n");
                buffer.append("Country.......: " + rs.getObject("COUNTRY", String.class) + "\n");
                buffer.append("State.........: " + rs.getObject("STATE", String.class) + "\n");
                buffer.append("Phone number..: " + rs.getObject("PHONE_NUMBER", String.class));

                System.out.println(buffer.toString());
                System.out.println("------------------------------------------------");

            }
        }
    }
}