package com.tictactoe.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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
    
    @OneToOne
    private TicTacToe game;

   
    public User() {
    }

    public User(String userName, String password, String email, Date dateOfBirth) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.game = new TicTacToe();
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


    private TicTacToe getGame() {
		return game;
	}

	private void setGame(TicTacToe game) {
		this.game = game;
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
