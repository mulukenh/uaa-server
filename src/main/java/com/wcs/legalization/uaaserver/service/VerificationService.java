package com.wcs.legalization.uaaserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcs.legalization.uaaserver.entity.Verification;
import com.wcs.legalization.uaaserver.repository.VerificationRepository;

@Service
public class VerificationService {
	
	@Autowired
	private VerificationRepository verificationRepo;

	public String createVerificationId(String username) {
		Verification verification = verificationRepo.findByUsername(username);
		return verification.getId();
	}

	public String getUsernameForId(String id) {
		Verification verification = verificationRepo.findById(id).get();
		return verification.getUsername();
	}
}
