package com.tictactoe.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tictactoe.dao.PositionDAO;
import com.tictactoe.dao.UserDAO;
import com.tictactoe.services.CurrentUser;

/**
 * Servlet implementation class NewGamePlayServlet
 */
@WebServlet("/NewGamePlayServlet")
public class NewGamePlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewGamePlayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Inject
    CurrentUser currentUser;
    
    @Inject
    PositionDAO positionDAO;
    
    @Inject
    UserDAO userDAO;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		currentUser.getUser().removeAllPositions();
		userDAO.update(currentUser.getUser());
		positionDAO.deleteAllPositions(currentUser.getUser());
		response.sendRedirect("play.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
