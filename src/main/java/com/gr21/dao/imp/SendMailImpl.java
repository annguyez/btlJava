package com.gr21.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Repository;

import com.gr21.dao.SendMailDAO;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SendMailImpl implements SendMailDAO{
	
	@Autowired
	MailSender mailSender;
	public void sendEmail(String from, String to, String subject, String content) {
		// TODO Auto-generated method stub
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		System.out.println("Sent");
		mailSender.send(message);
	}

}
