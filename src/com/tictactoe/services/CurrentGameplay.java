package com.tictactoe.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;
import com.tictactoe.model.Position;



@ApplicationScoped
public class CurrentGameplay {
	
	class NextMove {
		public int next;
	}
	
	public static final int MIN_PLAYER = Position.FIRST_PLAYER;
	
	public int getComputerMove(int[] board) {
		NextMove nextMove = new NextMove();
		int count = 0;
		for(int i = 0; i < board.length ; i++) {
			if(board[i] == 0) {
				count ++;
			}
		}
		minMaxAlphaBeta(board, Position.SECOND_PLAYER, -1, 1, count, nextMove);
		return nextMove.next;
	}
	
	private int minMaxAlphaBeta(int[] board, int player, int alpha, int beta, int depth, NextMove nextMove) {
		if (isWinner(Position.FIRST_PLAYER, board)) {
			return -1;
		} else if (isWinner(Position.SECOND_PLAYER, board)) {
			return 1;
		} else if (depth == 0) {
			return 0;
		}
		
		if (player == MIN_PLAYER) {
			int result = 1, minResult = 1;
			for (int i=0; i<board.length; i++) {
				if (board[i] == 0) {
					board[i] = player;					
					result = minMaxAlphaBeta(board, nextPlayer(player), alpha, beta, depth - 1, nextMove);
					beta = Math.min(result, beta);
					minResult = Math.min(minResult, result);
					board[i] = 0;
					if (beta < alpha) {
						break;
					}	
				}
			}
			return minResult;
		} else {
			int result = -1, maxResult = -1, bestMove = -1;
			for (int i=0; i<board.length; i++) {
				if (board[i] == 0) {
					board[i] = player;					
					result = minMaxAlphaBeta(board, nextPlayer(player), alpha, beta, depth - 1, nextMove);
					alpha = Math.max(alpha, result);
					if (result > maxResult) {
						bestMove = i;
						maxResult = result;
					}
					board[i] = 0;
					if (beta < alpha) {
						break;
					}	
				}
			}
			nextMove.next = bestMove;
			return maxResult;
		}
	}
	
	private int nextPlayer(int player) {
		if (player == Position.FIRST_PLAYER) {
			return Position.SECOND_PLAYER;
		}
		return Position.FIRST_PLAYER;
	}
	
	public boolean isWinner (int player, int[] board) {		
		for (int i=0; i < Position.MAX_VALUE; i++) {
			//row win
			if (board[i * Position.MAX_VALUE] == board[i * Position.MAX_VALUE + 1] &&
			    board[i * Position.MAX_VALUE] == board[i * Position.MAX_VALUE + 2] &&
			    board[i * Position.MAX_VALUE] == player) {
				return true;				
			} 
			//column win
			if (board[i] == board[i + Position.MAX_VALUE] &&
				board[i] == board[i + Position.MAX_VALUE * 2] &&
				board[i] == player) {
				return true;				
			}
		}
		//diagonal win
		if (board[0] == board[Position.MAX_VALUE + 1] && board[0] == board[2 * Position.MAX_VALUE + 1] && board[0] == player) {
			return true;
		}
		
		if(board[2] == board[4] && board[2] == board[6] && board[2] == player) {
			return true;
		}
		return false;
	}
}
