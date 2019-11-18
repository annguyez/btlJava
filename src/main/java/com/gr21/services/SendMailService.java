package com.gr21.services;

public interface SendMailService {
	public void sendEmail(String from, String to, String subject, String content);
}
