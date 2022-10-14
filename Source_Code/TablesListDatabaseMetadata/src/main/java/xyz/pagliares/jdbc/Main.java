package xyz.pagliares.jdbc;

import xyz.pagliares.jdbc.beans.Admin;
import xyz.pagliares.jdbc.tables.AdminController;
import xyz.pagliares.jdbc.util.KeyboardInput;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        ResultSet rsTables = null;

        try  {

            DatabaseMetaData metadata = conn.getMetaData();
            String[] tableTypes = {"TABLE"};
            rsTables = metadata.getTables("hostelapp_jdbc", "%", "%", tableTypes);

            // Uncomment the line below if you want to list the tables of ALL databases you have permision
            // rsTables = metadata.getTables(null, "%", "%", tableTypes);

            while (rsTables.next()) {
                System.out.println(rsTables.getString("TABLE_NAME"));
            }

        } catch (Exception e) {
            System.err.println(e);
        }
        finally {
            rsTables.close();
        }

        ConnectionManager.getInstance().close();
    }
}














