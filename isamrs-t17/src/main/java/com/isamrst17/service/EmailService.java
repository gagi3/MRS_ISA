package com.isamrst17.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements Runnable{
	
	@Autowired
	public JavaMailSender emailSender;
	
	public String to;
	public String subject;
	public String text;
	
	public void setup(String to, String subject, String text) {
		this.to=to;
		this.subject = subject;
		this.text = text;
	}

	public void sendEmail() {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	@Override
	public void run() {
		sendEmail();
	}

}
