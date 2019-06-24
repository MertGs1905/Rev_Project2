package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	
	//String Fname;
	//String Lname;
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	@Column(name="user_name", unique=true, nullable=false)
	private String username;
	
	@Column(name="password", unique=true, nullable=false)
	private String password;
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "user [username=" + username + ", password=" + password + "]";
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
	
}
