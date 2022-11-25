package xyz.pagliares.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        ResultSet rsTables = null;
        ResultSet rsColumns = null;
        List<String> tables = new ArrayList<>();

        try  {

            DatabaseMetaData metadata = conn.getMetaData();
            String[] tableTypes = {"TABLE"};
            rsTables = metadata.getTables("hostelapp_jdbc", "%", "%", tableTypes);

            // Uncomment the line below if you want to list the tables of ALL databases you have permission
            // rsTables = metadata.getTables(null, "%", "%", tableTypes);

            while (rsTables.next()) {
                tables.add(rsTables.getString("TABLE_NAME"));
            }

            for (String tableName : tables) {
                System.out.println("Table: " + tableName);
                System.out.println("_______");

                rsColumns = metadata.getColumns(null, "%", tableName, "%");

                while (rsColumns.next()) {
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(rsColumns.getString("COLUMN_NAME"));
                    buffer.append(": ");
                    buffer.append(rsColumns.getString("TYPE_NAME"));
                    System.out.println(buffer.toString());
                }

                System.out.println("");
            }

        } catch (Exception e) {
            System.err.println(e);
        }
        finally {
            rsTables.close();
            rsColumns.close();
        }

        ConnectionManager.getInstance().close();
    }
}














