package team4;

import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * �����ͺ��̽��� �����ϴ� ������ �Ѵ�.
 * @author KAJ
 */
public class DBConnection {
	final String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	final String db_id = "team4";
	final String db_password = "1234";
	//DB���� ����
	private Connection conn = null;
	private Statement stmt = null;
	
	DBConnection() {
		try {
			// ���� ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbc_url, db_id, db_password);
			stmt = conn.createStatement();
		} 
		catch (SQLException ex) {
			System.out.println("���� ���� �ý��� DB���� ����");
		} 
		catch (ClassNotFoundException ex) {
			System.out.println("JDBC ����̹� �ε� ����");
		}
	}
	public Statement db_connect() { return stmt; }
	public void db_close() {
		try {
			conn.close();
		} catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
