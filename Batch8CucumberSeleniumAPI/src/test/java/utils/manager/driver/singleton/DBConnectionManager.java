package utils.manager.driver.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * Author: Akash
 * Date: 23Jun2019
 */
public class DBConnectionManager {
	
	private static DBConnectionManager instance;
	private Connection conn;
	
	
	private DBConnectionManager(String url) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return this.conn;
	}
	
	public static DBConnectionManager getInstance(String url) throws SQLException {
		if (instance==null) {
			instance= new DBConnectionManager(url);
		}else if (instance.getConnection().isClosed()) {
			instance= new DBConnectionManager(url);
		}
	return instance;
	}
}
