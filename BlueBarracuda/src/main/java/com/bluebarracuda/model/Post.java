package com.bluebarracuda.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Post")
public class Post {

	@Id
	@Column(name = "post_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "User_FK")
	private User user;
	
	@Column(name="post_text", nullable=false)	
	private String postText;
	
	@Column(name="likes")
	private int likes;
	
	@Column(name="dislikes")
	private int dislikes;

	public Post() {
	}

	public Post(User user, String postText, int likes, int dislikes) {
		this.user = user;
		this.postText = postText;
		this.likes = likes;
		this.dislikes = dislikes;
	}

	@Override
	public String toString() {
		return "Post [user=" + user 
				+ ", post=" + postText 
				+ ", likes=" + likes 
				+ ", dislikes " + dislikes + "]";
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;

	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String post) {
		this.postText = post;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

}
