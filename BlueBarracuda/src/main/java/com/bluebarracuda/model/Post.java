package com.bluebarracuda.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Post")
public class Post {
<<<<<<< HEAD
	
	@Id
	@Column(name="food_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
	User user;
		
	String post;
	int likes;
	int dislikes;
	
	public Post() {		
	}
	
	public Post(User user, String post, int likes, int dislikes) {
=======
	User user;
	String post;
	Ratings rating;
	public Post(User user, String post, Ratings rating) {
>>>>>>> 41253aa69d9f70c1e15c3ab46eb7573790bf6ffc
		super();
		this.user = user;
		this.post = post;
		this.likes = likes;
		this.dislikes = dislikes;
	}
	@Override
	public String toString() {
<<<<<<< HEAD
		return "Post [user=" 
				+ user + ", post=" + post + ", likes=" + likes + ", dislikes " + dislikes +"]";
=======
		return "Post [user=" + user + ", post=" + post + ", rating=" + rating + "]";
	}
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
>>>>>>> 41253aa69d9f70c1e15c3ab46eb7573790bf6ffc
	}
		
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
	
}
