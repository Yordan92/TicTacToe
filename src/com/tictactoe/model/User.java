package com.tictactoe.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@XmlRootElement
@Table(name = "USERS")
public class User implements Serializable {

    private static final long serialVersionUID = -7196507424378163030L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String password;

    private String email;
    
    @OneToMany(mappedBy="user")
    private Set<Position> positions = new HashSet<>();;

   
    public User() {
    }

    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addPosition(Position p) {
    	positions.add(p);
    }
    
    
    public int[] getPositionsAsArray() {
    	int board[] = new int[9];
    	for(Position temp : positions) {
    		board[temp.getX()*3 + temp.getY()] = temp.getPlayer();
    	}
    	return board;
    }
    
    public Set<Position> getPosition() {
    	return positions;
    }
    
    public void removeAllPositions() {
    	positions.clear();
    }
	@Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (userName != null && !userName.trim().isEmpty())
            result += "userName: " + userName;
        if (password != null && !password.trim().isEmpty())
        	result += ", password: " + password;

        if (email != null && !email.trim().isEmpty())
            result += ", email: " + email;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
        if (id != null) {
            if (!id.equals(other.id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
