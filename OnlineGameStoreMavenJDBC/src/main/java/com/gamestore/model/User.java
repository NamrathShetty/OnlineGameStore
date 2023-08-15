package com.gamestore.model;

public class User {

	private String username;
	private String password;
	private double amount;
	private Integer userId;
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", amount=" + amount + ", userId=" + userId
				+ "]";
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public User() {
		super();
	}
	public User(String username, String password, double amount) {
		super();
		this.username = username;
		this.password = password;
		this.amount = amount;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
