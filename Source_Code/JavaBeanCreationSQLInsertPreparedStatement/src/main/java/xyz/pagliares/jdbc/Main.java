package xyz.pagliares.jdbc;

import xyz.pagliares.jdbc.beans.Admin;
import xyz.pagliares.jdbc.tables.AdminController;
import xyz.pagliares.jdbc.util.KeyboardInput;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("\n--- Creating a new Admin bean to be inserted in the ADMIN table ---\n");

        Admin bean = new Admin();
        bean.setUserName(KeyboardInput.readInputAsString("User name: "));
        bean.setPassword(KeyboardInput.readInputAsString("Password: "));

        boolean result = AdminController.insert(bean);

        if (result) {
            System.out.println("New row with primary key " + bean.getAdminId() + " was inserted!");

        }

        System.out.println("\n--- Printing all rows in the ADMIN table ---\n");
        AdminController.getAllAdmins();
    }
}
















