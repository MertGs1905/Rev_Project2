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

import com.bluebarracuda.model.Comment;
import com.bluebarracuda.repo.CommentRepo;


@CrossOrigin(origins="http://localhost:4200")
@Controller
@RequestMapping(value="/BlueBarracuda")
public class CommentController {

	private CommentRepo commentRepo;
	
	public CommentController() {
		
	}
	
	@Autowired
	public CommentController(CommentRepo commentRepo) {
		this.commentRepo = commentRepo;
	}
	
	@GetMapping(value="/getAllComment.app")
	public @ResponseBody List<Comment> getAllComment(){
		return commentRepo.selectAll();
	}
	

	@PostMapping(value="/getCommentById.app")
	public @ResponseBody Comment getCommentById(@RequestParam("id") int num) {
		return commentRepo.selectById(num);
	}
	
	@PostMapping(value="{num}/getCommentByUri.app")
	public @ResponseBody Comment getCommentByUri(@PathVariable("num") int num) {
		return commentRepo.selectById(num);
	}
	
}