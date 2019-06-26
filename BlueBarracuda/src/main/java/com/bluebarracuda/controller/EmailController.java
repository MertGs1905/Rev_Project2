package com.bluebarracuda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluebarracuda.email.MailService;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin(origins="http://localhost:4200")
@Controller
//@RequestMapping(value="/Project2/email")
public class EmailController {
	
		private MailService mail;
	
	public EmailController() {
		
	}
	
	@Autowired
	public EmailController(MailService mail) {
		this.mail = mail;
	}
	
	
	@RequestMapping(value = "/resetPassword.app", method = RequestMethod.POST)
	public @ResponseBody void doRestPwd() throws JsonProcessingException {
	
			System.out.println("in the resetmapper");
			
			//generating random password
			String randString =  generateAlphaNumericPassword();
			
			// Creating message 
			String senderEmailId = "greenmonkeys83@gmail.com";
			String receiverEmailId = "tlgraham2017@gmail.com";
			System.out.println(receiverEmailId);
			String subject = "Your Password Has Been Successfully Reset";
			String message = "Your account is at serious thread. On our end it looks like "
					+ "you have forgotten your password. If that is not the case, please "
					+ "consider that someone decided to prank you a little bit. In any case, "
					+ "we suggest to change your password once you firstly log in."
					+ "\n\n Your new Password is: \t"+ randString
					+"\n\n Have a shitty day!!! ";
			
			//sending email 
			mail.sendEmail(senderEmailId, receiverEmailId, subject, message);
			
			//Updating password in database
		
			
			
		}
		
		public static String generateAlphaNumericPassword(){
			final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			int len = 10;
			StringBuilder builder = new StringBuilder();
			while (len-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
			}
			return builder.toString().toLowerCase();
		}
	}
	


