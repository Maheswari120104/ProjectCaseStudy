package com.hexaware.finance.bean;

public class Users {
	
		
		
			private int userId;
			private String userName;
			private String password;
			private String email;
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
			public Users(int userId, String userName, String password, String email) {
				
				this.userId = userId;
				this.userName = userName;
				this.password = password;
				this.email = email;
			}
			public Users() {
				this.userId = 0;
				this.userName = "";
				this.password = "";
				this.email = "";
			}
			@Override
			public String toString() {
				return "userid:"+userId;			}
				// TODO Auto-generated constructor stub
			}

		
	


