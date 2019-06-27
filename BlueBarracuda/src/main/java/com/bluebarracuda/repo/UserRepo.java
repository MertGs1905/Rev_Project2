package com.bluebarracuda.repo;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.bluebarracuda.model.User;

@Repository("userRepo")
@Transactional
public class UserRepo {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private SessionFactory sesFact;

	public UserRepo() {
	}

	@Autowired
	public UserRepo(SessionFactory sesFact) {
		this.sesFact = sesFact;
	}
	
	public void insert(User user) {		
		System.out.println("In user insert");
		sesFact.getCurrentSession().save(user);
	}
	
	public void update(User user) {
		sesFact.getCurrentSession().update(user);
	}
	
	public  void updatePass(User user, String randString) {
		
		
	    String  newPass = getHashPass(user.getUsername(), randString);
	  
	         user.setPassword( newPass );
	         
	         sesFact.getCurrentSession().update(user); 
	        
	}
	
	public void delete(User user) {
		sesFact.getCurrentSession().delete(user);;
	}
	
	public User selectById(int id) {
		return sesFact.getCurrentSession().get(User.class, id);
	}
	
	public User selectByUsername(String username) {
		System.out.println(username +" in selectByUsername");
		List<User> users = sesFact.getCurrentSession().createNativeQuery("select * from"+
				" Users where user_name='"+username+"'", User.class).list();
		
		System.out.println("users.get() returns a: " + users.get(0));
		User user = users.get(0);
		return user;
	}
	
	public User selectByEmail(String email) {
		System.out.println(email +" in selectByEmail");
		List<User> users = sesFact.getCurrentSession().createNativeQuery("select * from"+
				" Users where email='"+email+"'", User.class).list();
		System.out.println(users.toString());
		return users.get(0);
	}
	
	public List<User> selectAll(){
		System.out.println();
		return sesFact.getCurrentSession().createQuery("from User", User.class).list();
	}
	
	public String getHashPass(String username, String password) {			
		 String pass =  "'GET_USER_HASH('" + username + "', '" + password + "')";

        
        return pass;
	}
	
	public User getHash(String username, String password) {			
		List<User> user = sesFact.getCurrentSession().createQuery("FROM User" 
				+ " WHERE username= '" + username
                + "' AND password = GET_USER_HASH('" 
				+ username + "', '" + password + "')", User.class).list();

        if (user.size() == 0) {
            return null;
        }  
        return user.get(0);
	}


}
