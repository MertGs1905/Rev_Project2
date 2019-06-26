package com.bluebarracuda.model;

<<<<<<< HEAD

import java.util.List;

=======
>>>>>>> 3e63eba5b39d1180136e185a5a0414ba5e12b69e
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy="Post")
	private List<Rating> ratings;

	public Post() {
		
	}

<<<<<<< HEAD
	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
=======
	/**
	 * @param user
	 * @param postText
	 * @param likes
	 * @param dislikes
	 */
	public Post(User user, String postText, int likes, int dislikes) {
		super();
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
>>>>>>> 3e63eba5b39d1180136e185a5a0414ba5e12b69e
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
<<<<<<< HEAD
	
	
	
=======
>>>>>>> 3e63eba5b39d1180136e185a5a0414ba5e12b69e
}
