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

import com.bluebarracuda.model.Post;
import com.bluebarracuda.repo.PostRepo;

@CrossOrigin(origins="http://localhost:4200")
@Controller
@RequestMapping(value="post")
public class PostController {
	
	private PostRepo postRepo;
	
	public PostController() {
		
	}
	
	@Autowired
	public PostController(PostRepo postRepo) {
		
		this.postRepo = postRepo;	
	}
	
	@GetMapping(value="/getAllPosts.app")
	public @ResponseBody List<Post> getAllPosts(){
		System.out.println("Inside Get all posts");
		return postRepo.SelectAll();
		
	}
	
	@PostMapping(value="/getCommentById.app")
	public @ResponseBody Post getPostById(@RequestParam("id") int num) {
		return postRepo.selectByInt(num);
	}
	
	@PostMapping(value="{num}/getCommentByUri.app")
	public @ResponseBody Post getPostByUri(@PathVariable("num") int num) {
		return postRepo.selectByInt(num);
	}
	
}
