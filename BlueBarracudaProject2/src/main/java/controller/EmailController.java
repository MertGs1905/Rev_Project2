package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ram.service.MailService;

@CrossOrigin(origins="http://localhost:4200")
@Controller
@RequestMapping(value="/Project2/email")
public class EmailController {
	
		private MailService mailServ;
	    private MailService mail;
	
	public EmailController() {
		
	}
	
	@RequestMapping(value = "/resetPassword.app", method = RequestMethod.POST)
	public @ResponseBody OpResult doRestPwd(HttpServletRequest request) throws JsonProcessingException {
	
			System.out.println("in the resetmapper");
			
			//generating random password
			String randString =  generateAlphaNumericPassword();
			
			// Creating message 
			String senderEmailId = "greenmonkeys83@gmail.com";
			String receiverEmailId = email;
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
	


