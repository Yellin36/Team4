package team4;

import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 데이터베이스에 연결하는 역할을 한다.
 * @author KAJ
 */
public class DBConnection {
	final String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	final String db_id = "team4";
	final String db_password = "1234";
	//DB연결 관련
	private Connection conn = null;
	private Statement stmt = null;
	
	DBConnection() {
		try {
			// 연결 생성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbc_url, db_id, db_password);
			stmt = conn.createStatement();
		} 
		catch (SQLException ex) {
			System.out.println("계정 관리 시스템 DB연결 오류");
		} 
		catch (ClassNotFoundException ex) {
			System.out.println("JDBC 드라이버 로드 오류");
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
