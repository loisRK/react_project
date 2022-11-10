package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
		
//		String command = "oneUser"; 
//		System.out.println(command);
//		
//		if(command.equals("oneUser")) {
//			getOneUser(request, response);
//		}
		
		// web에서 값을 받아오는 객체 생성
//		ObjectMapper mapper = new ObjectMapper();
//		userDTO user = mapper.readValue(request.getInputStream(), userDTO.class);
//		System.out.println(user);
		
		// web으로 값을 보내주는 객체
		response.setContentType("application/json; charset=UTF-8");
//		JSONObject json = new JSONObject();
//		json.put("user dto test", user);
//		System.out.println(json);
//		PrintWriter out = response.getWriter();
//		out.print("out test");
//		out.print(json);
		
		getOneUser(request, response);
      

	}
	
	public void getOneUser(HttpServletRequest request, HttpServletResponse response) {
		userDTO user1 = new userDTO();
		JSONObject json = new JSONObject();
		
		ObjectMapper mapper = new ObjectMapper();
		
//		String userNickName = request.getParameter("userNickName");
		String userNickName = "피죤";
		
		try {
			user1 = userDAO.getOneUser(userNickName);
			String jsonInString = mapper.writeValueAsString(user1);
			System.out.println(jsonInString);
			json.put("user", jsonInString);
			
//			json.put("user", user1);
//			json.put("name", "피죤");
			
			
			System.out.println(json);
			
			PrintWriter out = response.getWriter();
			
//			out.print("out test");
			out.print(json);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
