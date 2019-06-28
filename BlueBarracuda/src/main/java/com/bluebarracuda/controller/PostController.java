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

import com.bluebarracuda.model.Post;
import com.bluebarracuda.model.User;
import com.bluebarracuda.repo.PostRepo;
import com.bluebarracuda.repo.UserRepo;

/**
 * @author  Arnold C. Sinko
 * 			Jacob Shanklin
 * 			Graham L Tyree
 * 			Mert Altun
 * 			Michael G. Perkins
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(value = "/post")
public class PostController {

	/**
	 * PostRepo is a Spring managed dependency of PostController 
	 */
	private PostRepo postRepo;
	/**
	 * UserRepo is a Spring managed dependency of PostController
	 */
	private UserRepo userRepo;

	/**
	 * 
	 */
	public PostController() {

	}

	/**
	 * @param postRepo
	 * @param userRepo
	 */
	@Autowired
	public PostController(PostRepo postRepo, UserRepo userRepo) {
		this.postRepo = postRepo;
		this.userRepo = userRepo;
	}

	/**
	 * @return A list of all Post(s) associated with a specific User
	 */
	@GetMapping(value = "/getAllPosts")
	public @ResponseBody List<Post> getAllPosts() {
		System.out.println("Inside Get all posts");
		return postRepo.SelectAll();

	}

	/**
	 * @param postId
	 * @return A single Post determined by the provided postId
	 */
	@PostMapping(value = "/getPostById")
	public @ResponseBody Post getPostById(@RequestParam("postId") int postId) {
		return postRepo.selectById(postId);
	}

	/**
	 * 
	 * Calls the appropriate postRepo method in order to add a new Post from a specific User
	 * 
	 * @param postText
	 * @param userId
	 */
	@PostMapping(value = "/newPost")
	public void addPost(@RequestParam("postText") String postText,
			@RequestParam("userId") int userId) {

		User user = userRepo.selectById(userId);
		if (user != null) {
			Post post = new Post();
			post.setPostText(postText);
			post.setUser(user);
			postRepo.insert(post);
		}

	}

}
