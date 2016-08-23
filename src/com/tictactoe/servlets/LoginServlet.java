package com.tictactoe.servlets;

import java.io.IOException;
import java.net.HttpURLConnection;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tictactoe.dao.PositionDAO;
import com.tictactoe.dao.UserDAO;
import com.tictactoe.model.User;
import com.tictactoe.services.CurrentUser;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@Inject
	private UserDAO userDAO;
	  
	@Inject
	private CurrentUser currentUser;
	  
	
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		User user = userDAO.getUserByCredentials(username, password);
		if(user == null) {
			 response.setStatus(HttpURLConnection.HTTP_UNAUTHORIZED);
			 return;
		}
		currentUser.setUser(user);
		response.setStatus(HttpURLConnection.HTTP_OK);
	}

}
