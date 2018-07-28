package com.mbaczewski.main;


public class User implements Updatable {

	private String userName;
	private String email;

	public User(String userName, String email) {
		this.userName = userName;
		this.email = email;
	}

	@Override
	public String updateStatement() {
		return "UPDATE user set (userName=" + userName + ", email=" + email;
	}
}
