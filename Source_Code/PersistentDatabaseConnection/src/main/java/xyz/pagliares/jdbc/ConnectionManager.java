package xyz.pagliares.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static ConnectionManager instance = null;

	private final String USERNAME = "florentino";
	private final String PASSWORD = "123456";

	private static final String CONNECTION_STRING ="jdbc:mysql://localhost:3306/hostelapp_jdbc";

	private RDBMS rdbms = RDBMS.MYSQL;

	private Connection conn = null;

	private ConnectionManager() {
	}

	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

	public void setDBType(RDBMS rdbms) {
		this.rdbms = rdbms;
	}

	private boolean openConnection() {
		try {
			switch (rdbms) {

			case MYSQL:
				conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
				return true;

			default: 
				return false;
			}
		}
		catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

	public Connection getConnection() {
		if (conn == null) {
			if (openConnection()) {
				System.out.println("Connection opened");
				return conn;
			} else {
				return null;
			}
		}
		return conn;
	}

	public void close() {
		System.out.println("Closing connection...");
		try {
			conn.close();
			conn = null;
			System.out.println("Connection closed");
		} catch (Exception e) {
		}
	}
}