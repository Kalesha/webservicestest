package com.nacre.to;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;

@XmlRootElement
public class User {
	int userID;
	String userName;
	String userPassword;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName
				+ ", userPassword=" + userPassword + "]";
	}

	public static void main(String[] args) {
		User user = new User();
		user.setUserID(0);
		user.setUserName("Kalesha");
		user.setUserPassword("Kalesha@testpass");
		System.out.println(new Gson().toJson(user));

	}
}
