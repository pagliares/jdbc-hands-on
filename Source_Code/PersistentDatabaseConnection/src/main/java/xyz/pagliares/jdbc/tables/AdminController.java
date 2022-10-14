package xyz.pagliares.jdbc.tables;

import java.sql.*;

import xyz.pagliares.jdbc.ConnectionManager;
import xyz.pagliares.jdbc.DatabaseUtility;
import xyz.pagliares.jdbc.RDBMS;
import xyz.pagliares.jdbc.beans.Admin;

public class AdminController {

	private static Connection conn = ConnectionManager.getInstance().getConnection();

	public static void getAllAdmins() throws SQLException {
		
		String sql = "SELECT ADMIN_ID, USERNAME, PASSWORD FROM ADMIN";
		try (
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

	public static boolean insert(Admin bean) throws Exception {

		String sql = "INSERT into admin (userName, password) " +
				"VALUES (?, ?)";
		ResultSet keys = null;
		try (
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		) {

			stmt.setString(1, bean.getUserName());
			stmt.setString(2, bean.getPassword());
			int affected = stmt.executeUpdate();

			if (affected == 1) {
				keys = stmt.getGeneratedKeys();
				keys.next();
				int newKey = keys.getInt(1);
				bean.setAdminId(newKey);
			} else {
				System.err.println("No rows affected");
				return false;
			}

		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally{
			if (keys != null) keys.close();
		}
		return true;
	}

	public static boolean update(Admin bean) throws Exception {

		String sql = "SELECT * FROM ADMIN WHERE ADMIN_ID = ?";

		ResultSet rs = null;

		try (
				PreparedStatement stmt = conn.prepareStatement(
						sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
		){

			stmt.setInt(1, bean.getAdminId());
			rs = stmt.executeQuery();

			if (rs.next()) {
				rs.updateString("userName", bean.getUserName());
				rs.updateString("password", bean.getPassword());
				rs.updateRow();
				return true;
			} else {
				return false;
			}
		}
		catch(SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			if (rs != null) rs.close();
		}
	}

	public static boolean delete(int adminId) throws Exception {

		String sql = "DELETE FROM ADMIN WHERE ADMIN_ID = ?";
		try (
				PreparedStatement stmt = conn.prepareStatement(sql);
		){

			stmt.setInt(1, adminId);
			int affected = stmt.executeUpdate();

			if (affected == 1) {
				return true;
			} else {
				return false;
			}

		}
		catch(SQLException e) {
			System.err.println(e);
			return false;
		}
	}
}
