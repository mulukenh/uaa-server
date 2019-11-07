package com.wcs.legalization.uaaserver.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.legalization.uaaserver.dto.UserDto;
import com.wcs.legalization.uaaserver.entity.UserDao;
import com.wcs.legalization.uaaserver.repository.UserRepository;

@RestController
public class UaaController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;	

    @GetMapping("/home")
    public String greetingForm(Model model) {
        return "<h1 style=\"color:green;text-align:center;\">Welcome to the HOME Page!<h1>";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "<h1 style=\"color:red;text-align:center;\">Welcome to the ADMIN Page!<h1>";
    }
    
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
    	return "redirect:register?success";
    }
}
