package com.bluebarracuda.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Profile")
public class Profile {

	@Id
	@Column(name="profile_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int profileId;

	@Column(name="email")
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
	
    @OneToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
	
    
	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public Profile(String email, String firstName, String lastName, String occupation, Timestamp birthdate,
			String hobbies, String imageLink) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.occupation = occupation;
		this.birthdate = birthdate;
		this.hobbies = hobbies;
		this.imageLink = imageLink;
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
