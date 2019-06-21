package model;

public class Ratings {
	User user;
	int likes;
	int dislikes;
	public Ratings(User user, int likes, int dislikes) {
		super();
		this.user = user;
		this.likes = likes;
		this.dislikes = dislikes;
	}
	@Override
	public String toString() {
		return "Ratings [user=" + user + ", likes=" + likes + ", dislikes=" + dislikes + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	
	
}
