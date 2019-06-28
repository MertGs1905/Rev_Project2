package com.bluebarracuda.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.bluebarracuda.model.User;
import com.bluebarracuda.repo.UserRepo;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping(value="/user")
public class UserController {	

	private UserRepo userRepo;
	
	public UserController() {
	}

	@Autowired
	public UserController(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	@GetMapping(value="/getAllUsers")
	public @ResponseBody List<User> getAllUsers(){
		System.out.println("All user controller");
		return userRepo.selectAll();
	}
	
	@PostMapping(value="/getUserById")
	public @ResponseBody User getUserById(@RequestParam("user_id") int user_id) {
		return userRepo.selectById(user_id);
	}
	
	@PostMapping(value="/getUserByUsername")
	public @ResponseBody User getUserByUsername(@RequestParam("username") String username) {
		return userRepo.selectByUsername(username);
	}


}