package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long userId;
	   
		private String userName;
	    private String password;
	    private String role;
	    private  String email;
		
	    
	    
	    public User() {
			super();
		}



		public User(Long userId) {
			super();
			this.userId = userId;
		}



		public User(Long userId, String userName, String password, String role, String email) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.password = password;
			this.role = role;
			this.email = email;
		}



		public Long getUserId() {
			return userId;
		}



		public void setUserId(Long userId) {
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



		public String getRole() {
			return role;
		}



		public void setRole(String role) {
			this.role = role;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}
		
	
	
		
	    
	
}
