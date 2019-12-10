package com.app.email.util;

import java.nio.file.Paths;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.app.email.model.Email;

@Component
public class EmailUtil {

	private JavaMailSender javaMailSender;

	public EmailUtil(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public String send(Email email) throws MessagingException{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true); 
		
		helper.setTo(email.getTo());
		helper.setSubject(email.getSubject());
		helper.setText(email.getBody(), true);
		helper.addAttachment("John Wick", Paths.get("C:\\Users\\Saurabh\\Downloads\\Video\\john wick.jpg").toFile());
		
		javaMailSender.send(mimeMessage);
		return "Mail Sent Successfully";
	}
}
