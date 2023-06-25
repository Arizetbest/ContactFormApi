package com.contactform.service;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.mail.Address;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Component
public class SendMailService {

	@Value("${email.emailid}")
	private String emailid;
	
	@Value("${email.password}")
	private String password;
	
	@Value("${email.smtphost}")
	private String smtphost;
	
	@Value("${email.smtpport}")
	private String smtport;
	
	public boolean sendMail(String name, String subject, String email, String message) {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", smtphost);
		properties.put("mail.smtp.port", smtport);
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailid, password);
			}
		});
		Message msg = prepareMessage(session, name, email, subject, message);
		try {
			Transport.send(msg);
			return true;
		} catch(MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private Message prepareMessage(Session session,String senderName, String to, String subject, String message) {
		Message msg = new MimeMessage(session);
		try {
			Address replyToArrayAddress[] = new Address[1];
			replyToArrayAddress[0] = new InternetAddress(to);
			msg.setFrom(new InternetAddress(emailid));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(emailid));
			msg.setRecipient(Message.RecipientType.BCC, new InternetAddress(to));
			msg.setSubject(subject+ " From " + senderName);
			msg.setText(message);
			msg.setReplyTo(replyToArrayAddress);
			return msg;
		} catch(AddressException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
