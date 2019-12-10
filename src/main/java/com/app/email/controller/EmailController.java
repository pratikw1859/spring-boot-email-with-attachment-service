package com.app.email.controller;

import javax.mail.MessagingException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.email.model.Email;
import com.app.email.util.EmailUtil;

@RestController
@RequestMapping(EmailController.API)
public class EmailController {
	
	public static final String API = "/email";
	
	private EmailUtil emailUtil;

	public EmailController(EmailUtil emailUtil) {
		this.emailUtil = emailUtil;
	}
	
	@PostMapping("/send")
	public String send(@RequestBody Email email) throws MessagingException{
		return emailUtil.send(email);
	}
}