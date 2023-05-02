package com.desarrollo.entities;

public class Login {
	private String username;
	private String pass;
	public String getUsername() {
		return username;
	}
	public Login() {
		
	}
	public Login(String username, String pass) {
		this.username = username;
		this.pass = pass;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
