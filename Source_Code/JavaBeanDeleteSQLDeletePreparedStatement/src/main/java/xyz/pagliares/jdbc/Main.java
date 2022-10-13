package xyz.pagliares.jdbc;

import xyz.pagliares.jdbc.tables.AdminController;
import xyz.pagliares.jdbc.util.KeyboardInput;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("\n--- Printing all rows in the ADMIN table ---\n");
        AdminController.getAllAdmins();

        int adminId = KeyboardInput.readInputAsInteger("\nEnter the id of the ADMIN to delete his/her data: ");

        if (AdminController.delete(adminId)) {
            System.out.println("Success!");
        } else {
            System.err.println("Nothing to delete!");
        }

        System.out.println("\n--- Printing all rows in the ADMIN table ---\n");
        AdminController.getAllAdmins();
    }
}
















