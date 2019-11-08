package com.wcs.legalization.uaaserver.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Verification {
	@Id
	private String id;
	private final String username;
	
	public Verification(String id, String username) {
		this.id = id;
		this.username = username;
	}
	
	public String getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
}
