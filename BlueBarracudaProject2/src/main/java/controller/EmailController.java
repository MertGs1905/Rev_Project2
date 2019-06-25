package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ram.App;

@CrossOrigin(origins="http://localhost:4200")
@Controller
@RequestMapping(value="/Project2/email")
public class EmailController {
	
	
	public EmailController() {
		
	}
	
	@GetMapping(value="/sendEmail.app")
	public @ResponseBody void sendEmail(@RequestParam("email") String email){
	
		App.sendUserMail(email);
	}
	

}
