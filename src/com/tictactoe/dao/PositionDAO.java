package com.tictactoe.dao;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.tictactoe.model.Position;
import com.tictactoe.model.User;

@Singleton
public class PositionDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void addPosition(Position pos) {
		em.persist(pos);
		
	}
	
	public void getTicTacToe() {
		String txtQuery = "SELECT t FROM Position t";
		TypedQuery<Position> query = em.createQuery(txtQuery, Position.class);
		System.out.println(query.getResultList());
		
	}
	
	public void deleteAllPositions(User user) {
		String deleteQuery = "DELETE FROM Position p WHERE p.user = :user";
		TypedQuery<Position> query =  em.createQuery(deleteQuery, Position.class);
		query.setParameter("user", user);
		query.executeUpdate();
	}
	
	public boolean hasPositon(User user, Position p) {
		String findQuery = "Select p FROM Position p WHERE p.user = :user and p.x = :x and p.y = :y";
		TypedQuery<Position> query =  em.createQuery(findQuery, Position.class);
		query.setParameter("user", user);
		query.setParameter("x", p.getX());
		query.setParameter("y", p.getY());
		return query.getResultList().size() != 0;
	}
}
