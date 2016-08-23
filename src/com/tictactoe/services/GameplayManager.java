//package com.tictactoe.services;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import javax.ejb.Stateless;
//import javax.inject.Inject;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//import com.google.gson.Gson;
//
//
//@Stateless
//@Path("game")
//public class GameplayManager {
//	
//	private static final Response RESPONSE_OK = Response.ok().build();
//	
//	@Inject
//	CurrentUser currentUser;
//	
//	@Inject
//	CurrentGameplay currentGameplay;
//	
//	@GET
//	@Path("gameplay/move/{playerMove}")
//	@Produces("application/json")
//	public String makeMove(@PathParam("playerMove") Integer index) {
//		Gson gson = new Gson();
//		
//		return gson.toJson(currentGameplay.getComputerMove());
//	}
//	
//	private void redirectToPlay(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String contextPath = request.getContextPath();
//		response.sendRedirect(contextPath + "/play.html");
//	}
//	
//	@GET
//	@Path("resume")
//	public Response resumeGame(@Context HttpServletRequest request, @Context HttpServletResponse response) {
//		try {
//			redirectToPlay(request, response);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return RESPONSE_OK;
//	}
//
//	
//	@GET
//	@Path("newgame")
//	public Response newGame(@Context HttpServletRequest request, @Context HttpServletResponse response) {
//		try {
//			redirectToPlay(request, response);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return RESPONSE_OK;
//	}
//
//}
