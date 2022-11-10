package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import dto.userDTO;
import util.DBUtil;

public class userDAO {
	// 모든 user 데이터 불러오기
	public static ArrayList<userDTO> getAlluser() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<userDTO> all = null;

		
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();			
			rset = stmt.executeQuery("SELECT * FROM user");
			all = new ArrayList<userDTO> ();
			
			while (rset.next()) {
				all.add(new userDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getDate(5), rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getString(9)));
			}
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return all;
	}
	
	// 회원가입
	public static ArrayList<userDTO> createUser(String userEmail, String userNickname, String userPw, String userName, Date userBirth, String userMbti) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<userDTO> all = null;

		
		try {
			con = DBUtil.getConnection();
			pstmt = con.PreparedStatement();			
			rset = pstmt.executeQuery("INSERT INTO user VALUES ");
			all = new ArrayList<userDTO> ();
			
			while (rset.next()) {
				all.add(new userDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getDate(5), rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getString(9)));
			}
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return all;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
