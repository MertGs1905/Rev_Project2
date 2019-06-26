package com.bluebarracuda.model;


public class Post {
	User user;
	String post;
	Ratings rating;
	
	public Post(User user, String post, Ratings rating) {
		super();
		this.user = user;
		this.post = post;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Post [user=" + user + ", post=" + post + ", rating=" + rating + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Ratings getRating() {
		return rating;
	}
	public void setRating(Ratings rating) {
		this.rating = rating;
	}
	
}
