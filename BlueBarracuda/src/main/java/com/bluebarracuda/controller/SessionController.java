package com.bluebarracuda.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bluebarracuda.model.Profile;
import com.bluebarracuda.model.User;
import com.bluebarracuda.repo.UserRepo;


@CrossOrigin(origins = "https://localhost:4200")
@Controller
public class SessionController {
	
	private UserRepo userRepo;

	@GetMapping(value="")
	public @ResponseBody void createSession(HttpSession session) {
		String name = (String)session.getAttribute("loggedName");
		System.out.println(name);
		
		String pass = (String)session.getAttribute("loggedPass");
		System.out.println(pass);
	}
	
	@PostMapping(value="/registerUser")
	public @ResponseBody void registerUser(
			@RequestParam("username") String usernameParam, 
			@RequestParam("password") String passwordParam,
			@RequestParam("firstname") String firstnameParam, 
			@RequestParam("lastname") String lastnameParam, 
			@RequestParam("email") String emailParam) {
		
		System.out.println("in the register user method");
		String username = usernameParam;
		String password = passwordParam;
		String firstname = firstnameParam;
		String lastname = lastnameParam;
		String email = emailParam;
		
		Profile profile = new Profile(email, firstname, lastname);
		System.out.println(profile.toString());
		User newUser = new User(username, password);
		newUser.setProfile(profile);
		System.out.println(newUser.toString());
		userRepo.insert(newUser);
	}
	
	
	
	@PostMapping(value="/authenticate")
	public @ResponseBody User login(
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		
		System.out.println("In Auth, Username input: " + username);
		User tmp = userRepo.selectByUsername(username);
		if(tmp.getPassword() == password)
			return userRepo.selectByUsername(username);
		else return null;
	}
	
	
//	@GetMapping(value="/logout")
//	public String logout(HttpSession session) {
//		System.out.println("in the logout method");
//		session.invalidate();
//		
//		System.out.println("\n\n\n");
//		return "extpa";
//	}
}
