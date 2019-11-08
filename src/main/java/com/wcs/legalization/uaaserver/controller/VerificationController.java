package com.wcs.legalization.uaaserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.legalization.uaaserver.entity.UserDao;
import com.wcs.legalization.uaaserver.repository.UserRepository;
import com.wcs.legalization.uaaserver.service.VerificationService;

@RestController
public class VerificationController {
	@Autowired
	private VerificationService verificationService;
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/verify/email")
	public String verifyEmail(@RequestParam String id) {
		String username = verificationService.getUsernameForId(id);
		if (username != null) {
			UserDao user = userRepository.findByUsername(username);
			user.setVerified(true);
			userRepository.save(user);
		}
		return "redirect:/login-verified";
	}
}
