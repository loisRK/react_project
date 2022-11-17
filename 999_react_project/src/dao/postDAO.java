package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.joinDTO;
import dto.postDTO;
import util.DBUtil;

public class postDAO {
	// 조인문
	public static ArrayList<joinDTO> joinPost() throws SQLException {
		Connection con = null;
	    Statement stmt = null;
	    ResultSet rset = null;
	    ArrayList<joinDTO> joinPost = null;
	      
	      try {
	         con = DBUtil.getConnection();
	         stmt = con.createStatement();
	         rset = stmt.executeQuery(
	        		 "SELECT u.user_nickname, u.user_mbti, p.post_id, p.user_id, p.post_contents, p.post_date FROM post as p JOIN user as u ON p.user_id = u.user_email");
	         joinPost = new ArrayList<joinDTO> ();
	         
	         while (rset.next()) {
	        	 joinPost.add(new joinDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getDate(6)));
	         }
	      } finally {
	         DBUtil.close(con, stmt, rset);;
	      }
//	      System.out.println(joinPost);
	      return joinPost;
	   }
	      
	      
	
	// 모든 게시글 조회
   public static ArrayList<postDTO> AllPost() throws SQLException {
      Connection con = null;
      Statement stmt = null;
      ResultSet rset = null;
      ArrayList<postDTO> allPost = null;
      
      try {
         con = DBUtil.getConnection();
         stmt = con.createStatement();
         rset = stmt.executeQuery("SELECT * FROM post");
         allPost = new ArrayList<postDTO> ();
         
         while (rset.next()) {
            allPost.add(new postDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getInt(5), rset.getDate(6)));
         }
      } finally {
         DBUtil.close(con, stmt, rset);;
      }
      return allPost;
   }
	   
   // 특정 사용자의 게시글 모두 조회
   public static ArrayList<joinDTO> getAllpost(String userEmail) throws SQLException {
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rset = null; 
      ArrayList<joinDTO> userAllPost = null;

      
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("SELECT u.user_nickname, u.user_mbti, p.post_id, p.user_id, p.post_contents, p.post_date  FROM post as p JOIN user as u ON p.user_id = u.user_email WHERE user_id = ?");         
         pstmt.setString(1, userEmail);
         rset = pstmt.executeQuery();
         
         userAllPost = new ArrayList<joinDTO> ();
         
         while (rset.next()) {
            userAllPost.add(new joinDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getDate(6)));
         }
      } finally {
         DBUtil.close(con, pstmt, rset);
      }
      System.out.println("ssssss"+userAllPost);
      return userAllPost;
   }
   
   // post_id로 게시글 조회
   
   public static ArrayList<postDTO> getAllpost(int postId) throws SQLException {
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rset = null; 
      ArrayList<postDTO> postIdAll = null;

      
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("SELECT * FROM post WHERE post_id = ?");         
         pstmt.setInt(1, postId);
         rset = pstmt.executeQuery();
         
         postIdAll = new ArrayList<postDTO> ();
         
         while (rset.next()) {
            postIdAll.add(new postDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getInt(5), rset.getDate(6)));
         }
      } finally {
         DBUtil.close(con, pstmt, rset);
      }
      return postIdAll;
   }
   
   // 새로운 포스트 작성
   public static boolean createPost(String userId, String postContents) throws SQLException {
      Connection con = null;
      PreparedStatement pstmt = null;
      
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("INSERT INTO post VALUES (NULL, ?, ?, 0, 0, now())");         
         pstmt.setString(1, userId);
         pstmt.setString(2, postContents);
         
         int result = pstmt.executeUpdate();
         if (result != 0) {
            return true;
         }
      } finally {
         DBUtil.close(con, pstmt);
      }
      return false;
   }
   
   // 포스트 수정
   public static boolean fixedPost(String postContents, int postId) throws SQLException {
      Connection con = null;
      PreparedStatement pstmt = null;
      
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("UPDATE post set post_contents = ? WHERE post_id = ?");         
         pstmt.setString(1, postContents);
         pstmt.setInt(2, postId);
         
         int updateResult = pstmt.executeUpdate();
         if (updateResult != 0) {
            return true;
         }
      } finally {
         DBUtil.close(con, pstmt);
      }
      return false;
   }

   
   // 삭제
   public static boolean deletePost(int postId) throws SQLException {
      Connection con = null;
      PreparedStatement pstmt = null;
      
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("DELETE FROM post WHERE post_id=?");         
         pstmt.setInt(1, postId);
         
         int deleteResult = pstmt.executeUpdate();
         if (deleteResult != 0) {
            return true;
         }
      } finally {
         DBUtil.close(con, pstmt);
      }
      return false;
   }
}