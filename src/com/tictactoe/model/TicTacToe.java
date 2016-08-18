package com.tictactoe.model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement

public class TicTacToe implements Serializable {
	static final int BOARD_SIZE = 3;
	public static final int EMPTY_MOVE = 0;
	public static final int FIRST_PLAYER = 1;
	public static final int SECOND_PLAYER = 2;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@ElementCollection
	@CollectionTable(name ="board")
	List<Integer> board = Arrays.asList(0,0,0,0,0,0,0,0,0,0);
	
	
	
	public TicTacToe() {
		
	}
	
//	public int checkForWinner() {
//		int winner = 0;
//		for(int i=0; i<BOARD_SIZE; i++) {
//			if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
//				winner = board[i][0];
//			} else if(board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
//				winner = board[0][i];
//			} else if(board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
//				winner = board[0][0];
//			}
//		}
//		return winner;
//	}
	
	public void setPosition(int x, int y, int forPlayer) {
		 int pos = x * BOARD_SIZE + y;
		 if (pos >= BOARD_SIZE * BOARD_SIZE) {
			 return;
		 }
		 board.set(pos, forPlayer);
	}
	
	public int getPosition(int x, int y) {
		int pos = x * BOARD_SIZE + y;
		if (pos >= BOARD_SIZE * BOARD_SIZE) {
			 return -1;
		 }
		return board.get(pos);
	}
	
	public boolean setMove(int x, int y, int player) {
//		if (board[x][y] == EMPTY_MOVE) {
//			board[x][y] = player;
//			return true;
//		}
//		return false;
		setPosition(x, y, player);
		return true;
	}

	private Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TicTacToe [board=" + Arrays.toString(board.toArray()) + "]";
	}
	

}
