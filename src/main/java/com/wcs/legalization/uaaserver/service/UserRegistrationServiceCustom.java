//package com.wcs.legalization.uaaserver.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.wcs.legalization.uaaserver.dto.UserDto;
//import com.wcs.legalization.uaaserver.entity.UserDao;
//import com.wcs.legalization.uaaserver.repository.UserRepository;
//
//@Service
//public class UserRegistrationServiceCustom {
//	
//	@Autowired
//	private UserRepository userRepository;
//	private PasswordEncoder passwordEncoder;
//
//	@Override
//	public void createUser(UserDto user) {
//		UserDao newUser = new UserDao(user.getUsername(), 
//				passwordEncoder.encode(user.getPassword()), 
//				user.getEmail(), 
//				true);;
//		userRepository.save(newUser);
//	}
//}
