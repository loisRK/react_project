package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import dao.postDAO;
import dto.joinDTO;
import dto.postDTO;

@WebServlet("/api/postController")
public class postController extends HttpServlet {
   JSONObject json = new JSONObject();
   ObjectMapper mapper = new ObjectMapper();
      
   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      // 한글 인코딩
      response.setContentType("application/json; charset=UTF-8");
      
      String command = request.getParameter("command");
      
//      System.out.println(command);
      if(command.equals("userAllpost")) {
//         getUserId(request, response);
//      } else if (command.equals("postIdAll")) {
//         getPostId(request, response);
      
      } else if (command.equals("createPost")) {
         createNewPost(request, response);
      } else if (command.equals("fixPost")) {
         fixedPostContent(request, response);
      } else if (command.equals("deletePost")) {
         deletePostAll(request, response);
      } else if (command.equals("joinPost")) {
         joinPost(request, response);
      } else if (command.equals("postByname")) {
    	  getUserId(request, response);
      }
      
//      getUserId(request, response);
//      deletePostAll(request, response);
//      fixedPostContent(request, response);
//      createNewPost(request, response);
//      getPostId(request, response);
//      getUserId(request, response);
//      getAllpost(request, response);
//      joinPost(request, response);
      System.out.println("------------");
      
   }
   // join문 전달
   public void joinPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
         response.setContentType("application/json; charset=UTF-8");
         JSONObject json = new JSONObject();
         System.out.println("JOIN 컨트롤러");
         try {
               ArrayList<joinDTO> all = postDAO.joinPost();
               Gson gson = new Gson();
               String jsonAll = gson.toJson(all);
               
//               System.out.println(all);
               
               json.put("joinPostList", jsonAll);
               System.out.println(json);
               PrintWriter out = response.getWriter();
               out.print(json);
               
           
            } catch (SQLException e) {
               e.printStackTrace();
            }
      }
   public void getAllpost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
         System.out.println("All 컨트롤러");
           
         response.setContentType("application/json; charset=UTF-8");
         JSONObject json = new JSONObject();
         try {
//               ArrayList<postDTO> all = postDAO.AllPost();
               ArrayList<joinDTO> all = postDAO.joinPost();
               System.out.println("print alllllllllll" + all);
               Gson gson = new Gson();
               String jsonAll = gson.toJson(all);
               
//               json.put("postList", jsonAll);
               json.put("joinPostList", jsonAll);
               System.out.println(json);
               PrintWriter out = response.getWriter();
               out.print(json);
               
           
            } catch (SQLException e) {
               e.printStackTrace();
            }
      }
   
   public void deletePostAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//      int postId = Integer.parseInt(request.getParameter("postId"));
      int postId = 25;
      
      try {
         boolean deleteResult = postDAO.deletePost(postId);
         String deletePostResult = Boolean.toString(deleteResult);
         PrintWriter out = response.getWriter();
         if (deleteResult == true) {
            json.put("deletePostResult", deletePostResult);
            
//            request.setAttribute("deleteResult", deleteResult);
//            request.getRequestDispatcher("postView.jsp").forward(request, response);
         } else {
            json.put("message", "fail");
            System.out.println("실패");
            
//            response.sendRedirect("failView.jsp");
      }
         out.print(json);
      } catch (SQLException | IOException e) {
         e.printStackTrace();
      }

   }

   // 수정
   public void fixedPostContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      int postId = Integer.parseInt(request.getParameter("postId"));
//      String postContents = request.getParameter("postContent");
      
      int postId = 32;
      String postContents = "changePostContent test";
      
      try {
         boolean updateResult = postDAO.fixedPost(postContents, postId);
         String updatePostResult = Boolean.toString(updateResult);
         PrintWriter out = response.getWriter();
         
         if (updateResult == true) {
            json.put("updatePostResult", updatePostResult);
            
//            request.setAttribute("updateResult", updateResult);
//            request.getRequestDispatcher("postView.jsp").forward(request, response);
         } else {
//            response.sendRedirect("failView.jsp");
            
            json.put("message", "fail");
            System.out.println("실패");
      }
         out.print(json);
      } catch (SQLException | IOException e) {
         e.printStackTrace();
      }

   }

   // 새로운 포스트 작성
   public void createNewPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      String userId = request.getParameter("user");
//      String postContents = request.getParameter("postContent");
      
      String userId = "123@naver.com";
      String postContents = "new Post test";
      
      try {
         boolean result = postDAO.createPost(userId, postContents);
         String newPostResult = Boolean.toString(result);
         PrintWriter out = response.getWriter();
         if (result == true) {
            json.put("newPostResult", newPostResult);
            
//            request.setAttribute("result", result);
//            request.getRequestDispatcher("postView.jsp").forward(request, response);
         } else {
            json.put("message", "fail");
            System.out.println("실패");
            
//            response.sendRedirect("failView.jsp");
      }
         out.print(json);
      } catch (SQLException | IOException e) {
         e.printStackTrace();
      }

}

   // user_id로 게시글 조회
//   public void getPostId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////      int postId = Integer.parseInt(request.getParameter("postId"));
//      int postId = 35;
//      
//      try {
////         ArrayList<postDTO> postIdAll = postDAO.getAllpost(postId);
//         postDTO searchPostByid = postDAO.getAllpost(postId);
//         PrintWriter out = response.getWriter();
//         
//         if (searchPostByid != null) {
//            String postByid = mapper.writeValueAsString(searchPostByid);
//            json.put("postByid", postByid);
//            
////            request.setAttribute("postIdAll", postIdAll);
////            request.getRequestDispatcher("postView.jsp").forward(request, response);
//         } else {
//            json.put("message", "fail");         
//            
////            response.sendRedirect("failView.jsp");
//         }
//         out.print(json);            
//      } catch (SQLException | IOException e) {
//         e.printStackTrace();
//      }
//   }

   // userId = userEmail로 게시글 조회
   public void getUserId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//      String userEmail = request.getParameter("user");
	   response.setContentType("application/json; charset=UTF-8");
      String userEmail = request.getParameter("user");
      
      
      try {
         ArrayList<joinDTO> userAllPost = postDAO.getAllpost(userEmail);
         PrintWriter out = response.getWriter();
         if (userAllPost != null) {
            String postByname = mapper.writeValueAsString(userAllPost);
            json.put("postByname", postByname);
            System.out.println(json);
            
            
//            request.setAttribute("userAllPost", userAllPost);
//            request.getRequestDispatcher("postView.jsp").forward(request, response);
         } else {
            json.put("message", "fail");
            
//            response.sendRedirect("failView.jsp");
         }
         out.print(json);
      } catch (SQLException | IOException e) {
         e.printStackTrace();
      }
      
   }

}