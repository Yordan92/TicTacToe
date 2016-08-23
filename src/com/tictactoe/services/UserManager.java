//package com.tictactoe.services;
//
//import java.net.HttpURLConnection;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.Arrays;
//import java.util.Date;
//
//import javax.ejb.Stateless;
//import javax.inject.Inject;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//import com.tictactoe.dao.PositionDAO;
//import com.tictactoe.dao.UserDAO;
//import com.tictactoe.model.Position;
//import com.tictactoe.model.User;
//
//
//
//@Stateless
//@Path("user")
//public class UserManager {
//    
//    private static final Response RESPONSE_OK = Response.ok().build();
//
//    @Inject
//    private UserDAO userDAO;
//    
//    @Inject
//    private CurrentUser currentUser;
//    
//    @Inject
//    private PositionDAO positionDao;
//   
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void registerUser(User newUser) {
//    	System.out.println("___________________________________");
//    	Position p = new Position(0,0,1);
//        p.setUser(newUser);
//        newUser.addPosition(p);
//        userDAO.addUser(newUser);
//        p.getUser().getUserName();
//        positionDao.addPosition(p);
//        currentUser.setUser(newUser);
//    }
//    
//    @Path("login")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response loginUser(User user) {
//    	
//        boolean isUserValid = userDAO.validateUserCredentials(user.getUserName(), user.getPassword());
//        if (!isUserValid) {
//            return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).build();
//        }
//        currentUser.setUser(user);
//        return RESPONSE_OK;
//    }
//    
//    @Path("authenticated")
//    @GET
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response isAuthenticated() {
//        if (currentUser.getUser() == null) {
//            return Response.status(HttpURLConnection.HTTP_NOT_FOUND).build();
//        }
//        return RESPONSE_OK;
//    }
//
//    @Path("current")
//    @GET
//    @Consumes(MediaType.TEXT_PLAIN)
//    public String getUser() {
//        if (currentUser.getUser() == null) {
//            return null;
//        }
//        return Arrays.toString(currentUser.getUser().getPositions());
//    }
//
//	@Path("logout")
//	@GET
//	@Consumes(MediaType.TEXT_PLAIN)
//	public void logoutUser() {
//		currentUser.setUser(null);
//	}
//	
//	 @Path("move")
//	 @GET
//	 @Consumes(MediaType.TEXT_PLAIN)
//	 public void setMove() throws NoSuchAlgorithmException {
////		 MessageDigest mda = MessageDigest.getInstance("SHA-512");
////	        String password = new String(mda.digest(new String("abc").getBytes()));
////			User user = new User("ivan", password, "y@y", new Date());
////			user.setGame(new TicTacToe());
////			userDAO.addUser(user);
////			System.out.println("This is some kind of a test_____________________________*************************");
////			System.out.println(userDAO.findUserByName("ivan").getGame());
//	 }
//}