package com.wcs.legalization.uaaserver.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.legalization.uaaserver.dto.UserDto;
import com.wcs.legalization.uaaserver.entity.UserDao;
import com.wcs.legalization.uaaserver.event.UserRegistrationEvent;
import com.wcs.legalization.uaaserver.repository.UserRepository;

@RestController
public class RegistrationController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
    @GetMapping("/register")
    public String register(Model model) {
    	model.addAttribute("user", new UserDto());
    	return "register";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result) {
    	if (result.hasErrors()) {
    		return "register";
    	}
    	UserDao userDao = new UserDao(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()), userDto.getEmail(), true); 
    	userRepository.save(userDao);
    	eventPublisher.publishEvent(new UserRegistrationEvent(userDao));
    	return "redirect:register?success";
    }
}
