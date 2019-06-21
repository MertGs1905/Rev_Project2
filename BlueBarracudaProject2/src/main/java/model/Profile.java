package model;

import java.sql.Timestamp;
import java.util.Arrays;

public class Profile {
	User user;
	String email;
	String firstName;
	String lastName;
	String occupation;
	Timestamp birthdate;
	String hobbies;
	byte[] image;
	public Profile(User user, String email, String firstName, String lastName, String occupation, Timestamp birthdate,
			String hobbies, byte[] image) {
		super();
		this.user = user;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.occupation = occupation;
		this.birthdate = birthdate;
		this.hobbies = hobbies;
		this.image = image;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Profile [user=" + user + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", occupation=" + occupation + ", birthdate=" + birthdate + ", hobbies=" + hobbies + ", image="
				+ Arrays.toString(image) + "]";
	}
	
	
}
