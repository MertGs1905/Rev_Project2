package com.bluebarracuda.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluebarracuda.model.Registration;
import com.bluebarracuda.repo.RegistrationRepo;


@CrossOrigin(origins = "https://localhost:4200")
@Controller
public class SessionController {
	
	private RegistrationRepo regRepo;

	@GetMapping(value="")
	public @ResponseBody void createSession(HttpSession session) {
		String name = (String)session.getAttribute("loggedName");
		System.out.println(name);
		
		String pass = (String)session.getAttribute("loggedPass");
		System.out.println(pass);
	}
	
	@PostMapping(value="/register")
	public @ResponseBody void registerUser(HttpServletRequest request) {
		
		System.out.println("in the register user method");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		Profile registration = new Profile(username, password, firstname, lastname, email);		
		regRepo.insert(registration);
	}
	
	
	
	@GetMapping(value="/login")
	public String login(HttpSession session) {
		System.out.println("in the login method");
		
		session.setAttribute("loggedName", "MyNameIsPeachesAndImTheBest");
		session.setAttribute("loggedPass", "soulglow");
		
		System.out.println("\n\n\n");
		return "extpa";
	}
	
	@GetMapping(value="/logout")
	public String logout(HttpSession session) {
		System.out.println("in the logout method");
		session.invalidate();
		
		System.out.println("\n\n\n");
		return "extpa";
	}
}
