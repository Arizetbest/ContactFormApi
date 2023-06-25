package com.contactform.model.requestDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class ContactUsRequestDto {
	
	@NotEmpty
	private String firstname;
	@NotEmpty
	private String lastname;
	
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String message;
	@NotEmpty
	private String subject;
	
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
