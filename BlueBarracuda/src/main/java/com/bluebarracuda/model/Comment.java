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
@Table(name="User")
public class Comment {
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "User_FK")
	User user;
	
	@Id
	@Column(name="comment_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int commentId; 
	
	@Column(name="comment")
	private String comment;	
	
	@Column(name="likes", nullable=true)
	private int likes;
	
	@Column(name="dislikes", nullable=true)
	private int dislikes;
	
	public Comment() {
		
	}
	
	public Comment(User user, String comment, int likes, int dislikes) {
		super();
		this.user = user;
		this.comment = comment;
		this.likes = likes;
		this.dislikes = dislikes;
		
	}
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "Comment [user=" + user 
				+ ", comment=" + comment 
				+ ", likes=" + likes 
				+ ", dislikes= " + dislikes + "]";
	}
	
	
}
