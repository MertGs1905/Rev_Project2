package com.bluebarracuda.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Users")
public class Users {	

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	@Column(name="user_name", unique=true, nullable=false)
	private String username;
	
	@Column(name="password", unique=true, nullable=false)
	private String password;

	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
	private Profile profile;
	
	 @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	 @JsonIgnore
	private List<Post> posts;

	public Users() {	
		
	}
	
	

	/**
	 * @param username
	 * @param password
	 * @param profile
	 */
	public User(String username, String password, Profile profile) {
		super();
		this.username = username;
		this.password = password;
		this.profile = profile;
	}



	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}	
	
	
}