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

<<<<<<< HEAD
import com.bluebarracuda.model.Profile;
import com.bluebarracuda.model.Users;
=======
import com.bluebarracuda.model.User;
>>>>>>> 640d91a7c3ecb33811cc85c43577a2837a9b74a4
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
	public @ResponseBody List<Users> getAllUsers(){
		System.out.println("All user controller");
		return userRepo.selectAll();
	}
	
	@PostMapping(value="/getUserById")
	public @ResponseBody Users getUserById(@RequestParam("userId") int userId) {
		return userRepo.selectById(userId);
	}
	
	@PostMapping(value="/getUserByUsername")
	public @ResponseBody Users getUserByUsername(@RequestParam("username") String username) {
		return userRepo.selectByUsername(username);
	}
<<<<<<< HEAD
	@PostMapping(value="/authenticate")
	public @ResponseBody Users login(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("In Auth, Username input: " + username);
		Users tmp = userRepo.selectByUsername(username);
		if(tmp.getPassword() == password)
			return userRepo.selectByUsername(username);
		else return null;
	}
	@PostMapping(value="/register")
	public @ResponseBody void register(@RequestParam("username") String user) {
		System.out.println("In Auth, Username input: " + user);
		// userRepo.insert(user);
		System.out.println("User Inserted");
=======
>>>>>>> 640d91a7c3ecb33811cc85c43577a2837a9b74a4

//	@PostMapping(value="/authenticate")
//	public @ResponseBody User login(@RequestParam("username") String username, @RequestParam("password") String password) {
//		System.out.println("In Auth, Username input: " + username);
//		User tmp = userRepo.selectByUsername(username);
//		if(tmp.getPassword() == password)
//			return userRepo.selectByUsername(username);
//		else return null;
//	}
//	@PostMapping(value="/register")
//	public @ResponseBody void register(@RequestParam("username") String user) {
//		System.out.println("In Auth, Username input: " + user);
//		// userRepo.insert(user);
//		System.out.println("User Inserted");
//	}
}