package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.postDTO;
import util.DBUtil;

public class postDAO {
	public static ArrayList<postDTO> getAllpost() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<postDTO> all = null;

		
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();			
			rset = stmt.executeQuery("SELECT * FROM post");
			all = new ArrayList<postDTO> ();
			
			while (rset.next()) {
				all.add(new postDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getInt(5), rset.getDate(6)));
			}
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return all;
	
	}
}
