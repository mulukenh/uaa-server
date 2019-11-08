package com.wcs.legalization.uaaserver.event;

import org.springframework.context.ApplicationEvent;
import com.wcs.legalization.uaaserver.entity.UserDao;

public class UserRegistrationEvent extends ApplicationEvent {

	private static final long serialVersionUID = 7099057708183571937L;
	private final UserDao user;
	
	public UserRegistrationEvent(UserDao user) {
		super(user);
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserDao getUser() {
		return user;
	}
}
