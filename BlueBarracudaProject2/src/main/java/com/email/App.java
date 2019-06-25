package com.email;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.email.configuration.AppConfig;
import com.email.service.MailService;
import com.email.service.MailServiceImpl;

public class App
{
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	
	public static String generateAlphaNumericPassword() {
		int len = 10;
		StringBuilder builder = new StringBuilder();
		while (len-- != 0) {
		int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
		builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString().toLowerCase();
	}
	
	
	public static void sendUserMail(String email)
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		MailService mailService = context.getBean("mailService", MailServiceImpl.class);

		String senderEmailId = "buddymeinc@gmail.com";
		String receiverEmailId = email;
		String subject = "Your Password Has Been Successfully Reset";
		String message = "Your account is at serious thread. On our end it looks like "
				+ "you have forgotten your password. If that is not the case, please "
				+ "consider that someone decided to prank you a little bit. In any case, "
				+ "we suggest to change your password once you firstly log in."
				+ "\n\n Your new Password is: \t"+ generateAlphaNumericPassword()
				+"\n\n Have a shitty day!!! ";

		mailService.sendEmail(senderEmailId, receiverEmailId, subject, message);
		context.close();
	}

}
