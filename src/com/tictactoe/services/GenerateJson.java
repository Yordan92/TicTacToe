package com.tictactoe.services;

import com.google.gson.Gson;

public class GenerateJson {
	 static class JsonResponse {
    	String winMessage;
    	int[] board;
    	public JsonResponse(String winMessage, int[] board) {
    		this.winMessage = winMessage;
    		this.board = board;
    	}
	 }
	 
	 public static String boardPositions(String winMessage, int []board) {
		 Gson gson = new Gson();
		 JsonResponse jr = new JsonResponse(winMessage, board);
		 return gson.toJson(jr);
		 
	 }

}
