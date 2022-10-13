package xyz.pagliares.jdbc;

import xyz.pagliares.jdbc.beans.Admin;
import xyz.pagliares.jdbc.tables.AdminController;
import xyz.pagliares.jdbc.util.KeyboardInput;

import java.sql.*;

public class Main {

    private static final String SQL = "SELECT * FROM GUEST WHERE STATE = ?";

    public static void main(String[] args) throws SQLException {

        System.out.println("\n--- Printing all rows in the ADMIN table ---\n");
        AdminController.getAllAdmins();

        System.out.println("\n--- Printing details of an ADMIN by its ID ---\n");

        int adminId = KeyboardInput.getIntegerInput("Type the ADMIN ID: ");

        Admin bean = AdminController.getAdmin(adminId);

        if (bean == null) {
            System.err.println("No rows were found");
        } else {
            System.out.println("Admin id: " + bean.getAdminId());
            System.out.println("User name: " + bean.getUserName());
            System.out.println("Password: " + bean.getPassword());
        }

    }
}
















