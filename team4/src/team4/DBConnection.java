package team4;

import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/***********************************************************
/* DBConnection : �����ͺ��̽��� �����ϴ� ����
/***********************************************************/
public class DBConnection {

	final String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";	// ������ ����Ŭ �ּ�
	final String db_id = "team4";									// ����Ŭ ���� ���̵�	
	final String db_password = "1234";								// ����Ŭ ���� ��й�ȣ
	//DB���� ����
	private Connection conn = null;									// ����� �����ͺ��̽� ����
	private Statement stmt = null;									// �����ͺ��̽�
	
	public DBConnection() {
		// �����ͺ��̽� ���� ����
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbc_url, db_id, db_password);
			stmt = conn.createStatement();
		} 
		// �����ͺ��̽� ���� ���� ����
		catch (SQLException ex) {
			System.out.println("���� ���� �ý��� DB���� ����");
		} 
		// jdbc �ε� ���� ����
		catch (ClassNotFoundException ex) {
			System.out.println("JDBC ����̹� �ε� ����");
		}
	}
	/***********************************************************
     * Statement db_connect() : �����ͺ��̽� �����Ͽ� �����ϴ� �Լ�
	 * @return ����� �����ͺ��̽� ����
    /***********************************************************/
	public Statement db_connect() { 
		return stmt; 
	}
	/***********************************************************
     * void db_close() : �����ͺ��̽� ������ ���� �Լ�
    /***********************************************************/
	public void db_close() {
		try {
			conn.close();
		} catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
