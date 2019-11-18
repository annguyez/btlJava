package com.gr21.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gr21.dao.SendMailDAO;
import com.gr21.services.SendMailService;

@Service
public class SendMailServiceImpl implements SendMailService{

	@Autowired
	SendMailDAO sendMailDao;
	
	public void sendEmail(String from, String to, String subject, String content) {
		sendMailDao.sendEmail(from, to, subject, content);
	}
	
}
