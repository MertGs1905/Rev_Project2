package com.bluebarracuda.model;

import java.sql.Timestamp;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

||||||| merged common ancestors
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Profile")
>>>>>>> 7ba77f5f5e73120170cf214f67da431200df8d1d
public class Profile {
<<<<<<< HEAD
	
	@Column(name="email")
||||||| merged common ancestors
	User user;
=======

	@Column(name="email")
>>>>>>> 7ba77f5f5e73120170cf214f67da431200df8d1d
	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="occupation")
	private String occupation;

	@Column(name="birthdate")
	private Timestamp birthdate;

	@Column(name="hobbies")
	private String hobbies;

	@Column(name="image_link")
	String imageLink;
	
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
	
	public Profile(String email, String firstName, String lastName, String occupation, Timestamp birthdate,
			String hobbies, String imageLink) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.occupation = occupation;
		this.birthdate = birthdate;
		this.hobbies = hobbies;
<<<<<<< HEAD
		this.image = image;
	}
	
	
	/**
	 * @param email
	 * @param firstName
	 * @param lastName
	 */
	public Profile(String email, String firstName, String lastName) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
||||||| merged common ancestors
		this.image = image;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
=======
		this.imageLink = imageLink;
>>>>>>> 7ba77f5f5e73120170cf214f67da431200df8d1d
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public Timestamp getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Timestamp birthdate) {
		this.birthdate = birthdate;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public String getImageLink() {
		return this.imageLink;
	}
	public void setImage(String imageLink) {
		this.imageLink = imageLink;
	}
	@Override
	public String toString() {
		return "Profile [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", occupation=" + occupation + ", birthdate=" + birthdate + ", hobbies=" + hobbies + ", image="
				+ imageLink + "]";
	}
	
	
}
