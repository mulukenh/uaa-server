package com.wcs.legalization.uaaserver.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserDao {
	@Id
	private String username;
	private String password;
	private String email;
	private boolean enabled;
	
	public UserDao() {
	}

	public UserDao(String username, String password, String email, boolean enabled) {
		this.username = username;
		this.password = password;
		this.setEmail(email);
		this.setEnabled(enabled);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
