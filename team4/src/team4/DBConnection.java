package team4;

import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/***********************************************************
/* DBConnection : 데이터베이스에 연결하는 역할
/***********************************************************/
public class DBConnection {

	final String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";	// 연동할 오라클 주소
	final String db_id = "team4";									// 오라클 계정 아이디	
	final String db_password = "1234";								// 오라클 계정 비밀번호
	//DB연결 관련
	private Connection conn = null;									// 연결된 데이터베이스 정보
	private Statement stmt = null;									// 데이터베이스
	
	public DBConnection() {
		// 데이터베이스 연결 생성
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbc_url, db_id, db_password);
			stmt = conn.createStatement();
		} 
		// 데이터베이스 연결 오류 검출
		catch (SQLException ex) {
			System.out.println("계정 관리 시스템 DB연결 오류");
		} 
		// jdbc 로드 오류 검출
		catch (ClassNotFoundException ex) {
			System.out.println("JDBC 드라이버 로드 오류");
		}
	}
	/***********************************************************
     * Statement db_connect() : 데이터베이스 연결하여 리턴하는 함수
	 * @return 연결된 데이터베이스 정보
    /***********************************************************/
	public Statement db_connect() { 
		return stmt; 
	}
	/***********************************************************
     * void db_close() : 데이터베이스 연결을 끊는 함수
    /***********************************************************/
	public void db_close() {
		try {
			conn.close();
		} catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
