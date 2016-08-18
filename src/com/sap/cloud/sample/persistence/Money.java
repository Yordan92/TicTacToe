package com.sap.cloud.sample.persistence;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;

/**
 * Session Bean implementation class Money
 */


@SessionScoped
public class Money implements Serializable {

    /**
     * Default constructor.
     *  
     */
	private String money;
	public void setMoney(int money) {
		System.out.println("vlezna v settera na " + this);
		this.money = new String(Integer.toString(money));
	}
	
	public String getMoney() {
		return this.money;
	}
    public Money() {
   }

}
