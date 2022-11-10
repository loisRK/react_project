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
	// one user 데이터 불러오기
	public static userDTO getOneUser(String userNickName) throws SQLException{
		userDTO user = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
//			step 02
//			DB 연결
			con = DBUtil.getConnection();
			System.out.println("con : " + con);
//			step03
//			SQL 문장 객체
			stmt = con.createStatement();
			System.out.println("stmt : " + stmt);
//			step04
//			SQL 문장 실행 객체 - 실행 및 결과 반환
			rset = stmt.executeQuery("SELECT * FROM user WHERE user_nickname = '" + userNickName + "\'");
			System.out.println("rest : " + rset);
//			step05
//			데이터 활용(CRUD)
			if(rset.next()) {
				user = new userDTO(rset.getString(1),
								   rset.getString(2),
								   rset.getString(3),
								   rset.getString(4),
								   rset.getDate(5),
								   rset.getInt(6),
								   rset.getInt(7),
								   rset.getInt(8),
								   rset.getString(9)								   
								   );
			}
			System.out.println(user);
		} finally {
//			step06
//			DB 종료
//			참조한 역순으로 close를 해 주어야 한다.
			DBUtil.close(con, stmt, rset);
		}
		
		return user;
	}
	
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
	

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
