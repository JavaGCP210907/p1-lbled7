package com.revature.models;

//DTO - Data transfer object
//An HTTP handler will parse a JSON object sent by the user, containing their username and password
//this then gets sent to the controller to get turned into a Java object
//Username and password will be put into the DTO as fields, which will then get checked by service layer
//You NEVER store a DTO in the database. It's purely for Data Transfer...hence Data Transfer Object

public class LoginDTO {
	
	
	private String username;
	private String password;
	
	
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	
	
	
}
