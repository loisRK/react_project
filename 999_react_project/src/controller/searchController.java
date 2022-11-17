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

import com.google.gson.Gson;

import dao.postDAO;
import dto.joinDTO;
import dto.postDTO;

@WebServlet("/api/searchController")
public class searchController extends HttpServlet {
   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("searchController 실행");
      System.out.println(request.getParameter("inputText"));
      
      String userEmail = request.getParameter("inputText");
//      String userEmail = "123@naver.com";
      response.setContentType("application/json; charset=UTF-8");
       JSONObject json = new JSONObject();
      
      try {
         ArrayList<joinDTO> userAllPost = postDAO.getAllpost(userEmail);
         Gson gson = new Gson();
         String jsonAll = gson.toJson(userAllPost);
         
         json.put("postList", jsonAll);
         System.out.println(json);
         
         PrintWriter out = response.getWriter();
         out.print(json);
         
         
      } catch (SQLException | IOException e) {
         e.printStackTrace();
         }
      }
}

