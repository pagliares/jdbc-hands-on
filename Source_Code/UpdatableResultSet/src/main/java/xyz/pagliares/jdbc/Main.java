package xyz.pagliares.jdbc;

import xyz.pagliares.jdbc.beans.Admin;
import xyz.pagliares.jdbc.tables.AdminController;
import xyz.pagliares.jdbc.util.KeyboardInput;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("\n--- Printing all rows in the ADMIN table ---\n");
        AdminController.getAllAdmins();

        int adminId = KeyboardInput.readInputAsInteger("\nEnter the id of the ADMIN to update his/her data: ");

        Admin bean = AdminController.getAdmin(adminId);
        if (bean == null) {
            System.err.println("Admin not found");
            return;
        }

        String password = KeyboardInput.readInputAsString("Enter new password: ");
        bean.setPassword(password);

        if (AdminController.update(bean)) {
            System.out.println("Success!");
        } else
        {
            System.err.println("whoops!");
        }

        System.out.println("\n--- Printing all rows in the ADMIN table ---\n");
        AdminController.getAllAdmins();
    }
}
















