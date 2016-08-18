package com.tictactoe.dao;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.tictactoe.model.TicTacToe;
import com.tictactoe.model.User;

@Singleton
public class TicTacToeDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void addTicTacToe(TicTacToe game) {
		em.persist(game);
		
	}
	
	public void getTicTacToe() {
		String txtQuery = "SELECT t FROM TicTacToe t";
		TypedQuery<TicTacToe> query = em.createQuery(txtQuery, TicTacToe.class);
		System.out.println(query.getResultList().get(0));
		
	}
}
