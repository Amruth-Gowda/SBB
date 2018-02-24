package com.MavenProject.SmartBookBorrow.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private int userId;
	
	private String userName, userGender, userDOB, userAddress, userEmail, userPassword, userMobileNumber;

	public User(){
	}

	public User(int userId, String userName, String userGender, String userDOB, String userAddress, String userEmail,
			String userPassword, String userMobileNumber) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userGender = userGender;
		this.userDOB = userDOB;
		this.userAddress = userAddress;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userMobileNumber = userMobileNumber;
		
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserDOB() {
		return userDOB;
	}
	public void setUserDOB(String userDOB) {
		this.userDOB = userDOB;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(String userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	
}
