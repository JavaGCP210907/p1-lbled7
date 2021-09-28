package com.revature.models;

public class User {
	private String ers_username;
	private String ers_password;
	private String user_first_name;
	private String user_last_name;
	private String ers_user_role;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String ers_username, String ers_password, String user_first_name, String user_last_name,
			String ers_user_role) {
		super();
		this.ers_username = ers_username;
		this.ers_password = ers_password;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.ers_user_role = ers_user_role;
	}
	public String getErs_username() {
		return ers_username;
	}
	public void setErs_username(String ers_username) {
		this.ers_username = ers_username;
	}
	public String getErs_password() {
		return ers_password;
	}
	public void setErs_password(String ers_password) {
		this.ers_password = ers_password;
	}
	public String getUser_first_name() {
		return user_first_name;
	}
	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}
	public String getUser_last_name() {
		return user_last_name;
	}
	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}
	public String getErs_user_role() {
		return ers_user_role;
	}
	public void setErs_user_role(String ers_user_role) {
		this.ers_user_role = ers_user_role;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ers_password == null) ? 0 : ers_password.hashCode());
		result = prime * result + ((ers_user_role == null) ? 0 : ers_user_role.hashCode());
		result = prime * result + ((ers_username == null) ? 0 : ers_username.hashCode());
		result = prime * result + ((user_first_name == null) ? 0 : user_first_name.hashCode());
		result = prime * result + ((user_last_name == null) ? 0 : user_last_name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (ers_password == null) {
			if (other.ers_password != null)
				return false;
		} else if (!ers_password.equals(other.ers_password))
			return false;
		if (ers_user_role == null) {
			if (other.ers_user_role != null)
				return false;
		} else if (!ers_user_role.equals(other.ers_user_role))
			return false;
		if (ers_username == null) {
			if (other.ers_username != null)
				return false;
		} else if (!ers_username.equals(other.ers_username))
			return false;
		if (user_first_name == null) {
			if (other.user_first_name != null)
				return false;
		} else if (!user_first_name.equals(other.user_first_name))
			return false;
		if (user_last_name == null) {
			if (other.user_last_name != null)
				return false;
		} else if (!user_last_name.equals(other.user_last_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [ers_username=" + ers_username + ", ers_password=" + ers_password + ", user_first_name="
				+ user_first_name + ", user_last_name=" + user_last_name + ", ers_user_role=" + ers_user_role + "]";
	}
	
	
	
	
	
	
}
