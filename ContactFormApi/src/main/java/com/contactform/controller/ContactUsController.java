package com.contactform.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactform.model.requestDto.ContactUsRequestDto;
import com.contactform.model.responseDto.SuccessandMessageDto;
import com.contactform.service.SendMailService;

@RestController
@RequestMapping("/")
public class ContactUsController {

	private final SendMailService sendMailService;
	
	
	
	public ContactUsController(SendMailService sendMailService) {
		super();
		this.sendMailService = sendMailService;
	}



	@PostMapping("/contactus")
	public ResponseEntity<SuccessandMessageDto> Contactus(@RequestBody ContactUsRequestDto requestDto) {
		SuccessandMessageDto responseDto = new SuccessandMessageDto();
		
		boolean result = this.sendMailService.sendMail(
				requestDto.getFirstname()+" "+requestDto.getLastname(), 
				requestDto.getSubject(),
				requestDto.getEmail(),
				requestDto.getMessage());
		if(result) {
			responseDto.setMessage("Mail Send Successfully!!");
			responseDto.setSuccess(true);
			return new ResponseEntity<SuccessandMessageDto>(responseDto,HttpStatus.OK);
		}
		else {
			responseDto.setMessage("Mailing failed!!");
			responseDto.setSuccess(false);
			return new ResponseEntity<SuccessandMessageDto>(responseDto,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
