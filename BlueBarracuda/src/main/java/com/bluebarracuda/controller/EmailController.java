package com.bluebarracuda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluebarracuda.email.MailService;
import com.bluebarracuda.model.User;
import com.bluebarracuda.repo.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin(origins="http://localhost:4200")
@Controller
public class EmailController {
		
		private User user;
		private UserRepo userRepo;
		private MailService mail;
	
	public EmailController() {
		
	}
	
	@Autowired
	public EmailController(MailService mail) {
		this.mail = mail;
	}
	
	

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public @ResponseBody void doRestPwd(@RequestParam("email") String email) throws JsonProcessingException {
	
			System.out.println("in the resetmapper");
			
			//generating random password
			String randString =  generateAlphaNumericPassword();
			
			// Creating message 
			String senderEmailId = "greenmonkeys83@gmail.com";
			String receiverEmailId = email;
			System.out.println(receiverEmailId);
			String subject = "Your Password Has Been Successfully Reset";
			String message = "It looks like "
					+ "you have forgotten your password. If that is not the case, please "
					+ "consider that someone decided to prank you a little bit. In any case, "
					+ "we suggest to change your password once you firstly log in."
					+ "\n\n Your new Password is: "+ randString;
			
			//sending email 
			mail.sendEmail(senderEmailId, receiverEmailId, subject, message);
			
			
			user = userRepo.selectByEmail(receiverEmailId);
			
			//Updating password in database
//			userRepo.updatePass(user, randString);
			
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
	


