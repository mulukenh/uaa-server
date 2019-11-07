package com.wcs.legalization.uaaserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wcs.legalization.uaaserver.entity.UserDao;
import com.wcs.legalization.uaaserver.repository.UserRepository;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDao user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return User.withUsername(user.getUsername())
				.password(user.getPassword())
				.roles("USER").build();
	}
}
