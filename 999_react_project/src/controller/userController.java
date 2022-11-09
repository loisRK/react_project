package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDAO;
import dto.userDTO;


@WebServlet("/userController")
public class userController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ArrayList<userDTO> all = userDAO.getAlluser();
			if (all != null) {
				request.setAttribute("all", all);
				request.getRequestDispatcher("view.jsp").forward(request, response);
			} else {
				response.sendRedirect("failView.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
