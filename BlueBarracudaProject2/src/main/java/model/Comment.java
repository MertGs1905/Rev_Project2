package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comment {
	@Id
	@Column(name="food_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int commentId;
	@OneToMany
	User user;
	String comment;
	Ratings rating;
	public Comment(User user, String comment, Ratings rating) {
		super();
		this.user = user;
		this.comment = comment;
		this.rating = rating;
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
	public Ratings getRating() {
		return rating;
	}
	public void setRating(Ratings rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Comment [user=" + user + ", comment=" + comment + ", rating=" + rating + "]";
	}
	
	
}
