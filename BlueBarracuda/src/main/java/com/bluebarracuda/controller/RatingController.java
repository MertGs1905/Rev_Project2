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

import com.bluebarracuda.model.Ratings;
import com.bluebarracuda.repo.RatingRepo;

@CrossOrigin(origins="http://localhost:4200")
@Controller
@RequestMapping(value="api/rating")
public class RatingController {
	

	private com.bluebarracuda.repo.RatingRepo ratingRepo;
	
	public RatingController() {
		
	}
	
	
	@Autowired
	public RatingController(RatingRepo ratingRepo) {
		this.ratingRepo = ratingRepo;
	}
	
	@GetMapping(value="/getAllRating.app")
	public @ResponseBody List<Ratings> getAllRating(){
		return ratingRepo.selectAll();
	}
	

	@PostMapping(value="/getRatingById.app")
	public @ResponseBody Ratings getRatingById(@RequestParam("id") int num) {
		return ratingRepo.selectById(num);
	}
	
	@PostMapping(value="{num}/getRatingByUri.app")
	public @ResponseBody Ratings getRatingByUri(@PathVariable("num") int num) {
		return ratingRepo.selectById(num);
	}

}