package com.tictactoe.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tictactoe.dao.PositionDAO;
import com.tictactoe.dao.UserDAO;
import com.tictactoe.model.Position;
import com.tictactoe.model.User;
import com.tictactoe.services.CurrentGameplay;
import com.tictactoe.services.CurrentUser;
import com.tictactoe.services.GenerateJson;

/**
 * Servlet implementation class NextMove
 */
@WebServlet("/NextMove")
public class NextMove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Inject
	CurrentUser currentUser;
	
	@Inject
	UserDAO userDAO;
	
	@Inject 
	PositionDAO positionDAO;
	
	@Inject 
	CurrentGameplay currentGameplay;
	
    public NextMove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void addUserPosition(User u, Position p) {
    	u.addPosition(p);
    	p.setUser(u);
    	userDAO.update(u);
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String responseString = null;
		int playerMove = Integer.parseInt(request.getParameter("index"));
		Position p = new Position(playerMove / Position.MAX_VALUE, playerMove % Position.MAX_VALUE, Position.FIRST_PLAYER);
		User user = currentUser.getUser();
		if(positionDAO.hasPositon(user, p)) {
			response.sendRedirect("BoardPositions");
			return;
		}
		addUserPosition(user, p);
		if (currentGameplay.isWinner(Position.FIRST_PLAYER, user.getPositionsAsArray())) {
			responseString = GenerateJson.boardPositions("You win!!!", user.getPositionsAsArray());
		}
		int nextMove = currentGameplay.getComputerMove(user.getPositionsAsArray());
		Position nextPosition = new Position(nextMove / Position.MAX_VALUE, nextMove % Position.MAX_VALUE, Position.SECOND_PLAYER);
		addUserPosition(user, nextPosition);
		if (currentGameplay.isWinner(Position.SECOND_PLAYER, user.getPositionsAsArray())) {
			responseString = GenerateJson.boardPositions("Computer win!!!", user.getPositionsAsArray());
		} else {
			response.sendRedirect("BoardPositions");
		}
		response.setContentType("application/json");
		response.getWriter().println(responseString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
