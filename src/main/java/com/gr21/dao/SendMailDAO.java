package com.gr21.dao;

public interface SendMailDAO {
	public void sendEmail(String from, String to, String subject, String content);
}
