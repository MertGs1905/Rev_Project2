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
import com.bluebarracuda.model.Rating;
import com.bluebarracuda.model.User;
import com.bluebarracuda.repo.PostRepo;
import com.bluebarracuda.repo.RatingRepo;
import com.bluebarracuda.repo.UserRepo;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(value = "/post")
public class PostController {

	private PostRepo postRepo;
	private UserRepo userRepo;
	private RatingRepo ratingRepo;

	public PostController() {

	}

	@Autowired
	public PostController(PostRepo postRepo, UserRepo userRepo, RatingRepo ratingRepo) {
		this.postRepo = postRepo;
		this.userRepo = userRepo;
		this.ratingRepo = ratingRepo;
	}

	@GetMapping(value = "/getAllPosts")
	public @ResponseBody List<Post> getAllPosts() {
		System.out.println("Inside Get all posts");
		List<Post> posts = postRepo.SelectAll();
		if(posts.isEmpty()) {
			posts.add(new Post());			
		}
		return posts;

	}

	@PostMapping(value = "/getPostById")
	public @ResponseBody Post getPostById(@RequestParam("postId") int postId) {
		return postRepo.selectById(postId);
	}

	@PostMapping(value = "/newPost")
	public void addPost(@RequestParam("post") String postText,
			@RequestParam("user_id") int userId) {

		User user = userRepo.selectById(userId);
		if (user != null) {
			Post post = new Post();
			post.setPostText(postText);
			post.setUser(user);
			postRepo.insert(post);
		}
		
	}
	
	@PostMapping(value="/likePost")
	public Post likePost(@RequestParam("postId") int postId, @RequestParam("userId") int userId) {
		Post post = postRepo.selectById(postId);
		Rating rating = new Rating();
		rating.setUser(userRepo.selectById(userId));
		rating.setPost(post);
		ratingRepo.insert(rating);
		post.addRating(rating);
		postRepo.update(post);
		return post;		
	}

}
