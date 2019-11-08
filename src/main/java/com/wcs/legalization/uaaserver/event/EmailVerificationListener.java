package com.wcs.legalization.uaaserver.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.wcs.legalization.uaaserver.service.VerificationService;

@Service
public class EmailVerificationListener implements ApplicationListener<UserRegistrationEvent> {

	private final JavaMailSender javaMailSender;
	@Autowired
	private VerificationService verificationService;
	
	public EmailVerificationListener(JavaMailSender javaMailSender, VerificationService verificationService) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void onApplicationEvent(UserRegistrationEvent event) {
		String username = event.getUser().getUsername();
		String verificationId = verificationService.createVerificationId(username);
		String email = event.getUser().getEmail();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("WCS Portfolio Account Verification");
		message.setText("Account activation link: https://localhost:8081/verify/email?id=" + verificationId);
		message.setTo(email);
		javaMailSender.send(message);
	}
}
