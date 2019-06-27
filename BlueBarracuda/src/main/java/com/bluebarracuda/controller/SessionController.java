package com.bluebarracuda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bluebarracuda.model.User;
import com.bluebarracuda.repo.UserRepo;

@CrossOrigin(origins = "https://localhost:4200")
@Controller
@RequestMapping(value="/auth")
public class SessionController {

	private UserRepo userRepo;

	public SessionController(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@GetMapping(value = "")
	public @ResponseBody void createSession(HttpSession session) {
		String name = (String) session.getAttribute("loggedName");
		System.out.println(name);

		String pass = (String) session.getAttribute("loggedPass");
		System.out.println(pass);
	}

	@PostMapping(value = "/registerUser")
	public @ResponseBody ResponseEntity<User> registerUser(@RequestParam("username") String usernameParam,
			@RequestParam("password") String passwordParam, @RequestParam("firstname") String firstnameParam,
			@RequestParam("lastname") String lastnameParam, @RequestParam("email") String emailParam) {

		System.out.println("in the register user method");
		String username = usernameParam;
		String password = passwordParam;
		String firstname = firstnameParam;
		String lastname = lastnameParam;
		String email = emailParam;		

		User newUser = new User(username, password);
		newUser.setEmail(email);
		newUser.setFirstName(firstname);
		newUser.setLastName(lastname);	
		System.out.println(newUser.toString());
		userRepo.insert(newUser);
		return new ResponseEntity<User>(newUser, HttpStatus.OK);
		
	}

	@PostMapping(value = "/authenticate")
	public @ResponseBody ResponseEntity<User> login(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		System.out.println("In Auth, Username input: " + username);	
		User user = userRepo.getHash(username, password);
		if (user == null) {
			return  new ResponseEntity<User>(new User(), HttpStatus.UNAUTHORIZED);
		}		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}


}
