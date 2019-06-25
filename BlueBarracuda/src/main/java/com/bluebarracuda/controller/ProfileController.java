package com.bluebarracuda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins="http://localhost:4200")
@Controller
@RequestMapping(value="/Project2")
public class ProfileController {

	private ProfileRepo profileRepo;
	
	public ProfileController() {
	}
	
	@Autowired
	public ProfileController(ProfileRepo profileRepo){
		this.profileRepo = profileRepo;
		
	}
	
	@GetMapping(value="/getAllProfile.app")
	public @ResponseBody List<Profile> getAllProfile(){
		return profileRepo.selectAll();
	}
	
	@PostMapping(value="/getProfileById.app")
	public @ResponseBody Profile getProfileById(@RequestParam("id")int num){
		return profileRepo.selectById(num);
	}
	
	@PostMapping(value="{num}/getProfileByUri.app")
	public @ResponseBody Profile getProfileByUri(@PathVariable("num")int num) {
		return profileRepo.selectById(num);
	}
	
	
}