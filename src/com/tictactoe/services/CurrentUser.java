package com.tictactoe.services;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.enterprise.context.SessionScoped;
import com.tictactoe.model.User;

/**
 * Session Bean implementation class CurrentUser
 */

@SessionScoped
public class CurrentUser implements Serializable{
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}

