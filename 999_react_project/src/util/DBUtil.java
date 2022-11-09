package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
static DataSource ds;
	
	static {
		 Context initContext = null;
		 try {
			 initContext = new InitialContext();
			 Context envContext = (Context)initContext.lookup("java:/comp/env");	// 필요한 환경설정을 불러오는 과정
			 ds = (DataSource)envContext.lookup("jdbc/mysql");	// 데이터소스에 모두 저장하고 사용하기 위한 과정
		 } catch(NamingException e) {
			 e.printStackTrace();
		 }
	}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	// 자원반환
		public static void close(Connection con, Statement stmt, ResultSet rset) {
			try {
				if (rset != null) {
					rset.close();
					rset = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 자원반환
		public static void close(Connection con, Statement stmt) {
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
