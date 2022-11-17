package controller;

import java.io.File;
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

import dao.userDAO;
import dto.userDTO;


@WebServlet("/api/userController")
public class userController extends HttpServlet {
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      
//      String command = "oneUser"; 
//      System.out.println(command);
//      
//      if(command.equals("oneUser")) {
//         getOneUser(request, response);
//      }
      
      // web에서 값을 받아오는 객체 생성
//      ObjectMapper mapper = new ObjectMapper();
//      userDTO user = mapper.readValue(request.getInputStream(), userDTO.class);
//      System.out.println(user);
      
      // web으로 값을 보내주는 객체
      response.setContentType("application/json; charset=UTF-8");      // response를 json 형태로 받기 설정
//      JSONObject json = new JSONObject();
//      json.put("user dto test", user);
//      System.out.println(json);
//      PrintWriter out = response.getWriter();
//      out.print("out test");
//      out.print(json);
      
      String command = request.getParameter("command");

      if (command.equals("oneUser")) {
         getOneUser(request, response);
      } else if (command.equals("allUsers")) {
         getAllUsers(request, response);
      }
//      getOneUser(request, response);      // json형태로 받은 response를 request한 곳으로 보내기?
      

   }
   
   public void getOneUser(HttpServletRequest request, HttpServletResponse response) {
      userDTO user1 = new userDTO();
      JSONObject json = new JSONObject();
      
      ObjectMapper mapper = new ObjectMapper();      // 객체를 string으로 변환하기 위한 객체
      
//      String userNickName = request.getParameter("userNickName");
      String userNickName = "최강훈남민기";
      
      try {
         user1 = userDAO.getOneUser(userNickName);   // 닉네임으로 userDTO 객체 찾아오기
         String jsonInString = mapper.writeValueAsString(user1);   // ObjectMapper를 이용해서 객체를 string 형태로 변환
//         System.out.println(jsonInString);
         json.put("user", jsonInString);            // string 형태를 json 형태로 변환 및 저장
         
//         json.put("user", user1);
//         json.put("name", "피죤");
         
         
//         System.out.println(json);
         
         PrintWriter out = response.getWriter();      // 웹으로 보내기 객체
         
//         out.print("out test");
         out.print(json);      // 웹으로 json 값 보내기
      } catch (SQLException | IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      

   }
   
   public void getAllUsers(HttpServletRequest request, HttpServletResponse response) {
      ArrayList<userDTO> users = new ArrayList<userDTO>();
      JSONObject json = new JSONObject();
      
      ObjectMapper mapper = new ObjectMapper();      // 객체를 string으로 변환하기 위한 객체
            
      try {
         users = userDAO.getAlluser();   // 닉네임으로 userDTO 객체 찾아오기
         String jsonInString = mapper.writeValueAsString(users);   // ObjectMapper를 이용해서 객체를 string 형태로 변환
//         System.out.println(jsonInString);
         json.put("users", jsonInString);            // string 형태를 json 형태로 변환 및 저장
         
//         json.put("user", user1);
//         json.put("name", "피죤");
         
         
//         System.out.println(json);
         
         PrintWriter out = response.getWriter();      // 웹으로 보내기 객체
         
//         out.print("out test");
         out.print(json);      // 웹으로 json 값 보내기
      } catch (SQLException | IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      

   }

}