package xyz.pagliares.jdbc.tables;

import java.sql.*;

import xyz.pagliares.jdbc.DatabaseUtility;
import xyz.pagliares.jdbc.RDBMS;
import xyz.pagliares.jdbc.beans.Admin;

public class AdminController {

	public static void getAllAdmins() throws SQLException {
		
		String sql = "SELECT ADMIN_ID, USERNAME, PASSWORD FROM ADMIN";
		try (
				Connection conn = DatabaseUtility.getConnection(RDBMS.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){

			while (rs.next()) {
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append(rs.getInt("ADMIN_ID") + ": ");
				stringBuffer.append(rs.getString("USERNAME") +", ");
				stringBuffer.append(rs.getString("PASSWORD"));
				System.out.println(stringBuffer.toString());
			}
		}
	}

	public static Admin getAdmin(int adminId) throws SQLException {

		String sql = "SELECT * FROM ADMIN WHERE ADMIN_ID = ?";
		ResultSet rs = null;

		try (
				Connection conn = DatabaseUtility.getConnection(RDBMS.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(sql);
		){
			stmt.setInt(1, adminId);
			rs = stmt.executeQuery();

			if (rs.next()) {
				Admin bean = new Admin();
				bean.setAdminId(adminId);
				bean.setUserName(rs.getString("userName"));
				bean.setPassword(rs.getString("password"));
				return bean;
			} else {
				return null;
			}

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
	}

}
