package com.bluebarracuda.repo;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.bluebarracuda.model.User;

/**
 * @author 	Arnold C. Sinko
 * 			Jacob Shanklin
 * 			Graham L Tyree
 * 			Mert Altun
 * 			Michael G. Perkins
 *
 */
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
	
	/**
	 * 
	 */
	private SessionFactory sesFact;

	/**
	 * 
	 */
	public UserRepo() {
	}

	/**
	 * @param sesFact
	 */
	@Autowired
	public UserRepo(SessionFactory sesFact) {
		this.sesFact = sesFact;
	}
	
	/**
	 * @param user
	 */
	public void insert(User user) {		
		System.out.println("In user insert");
		sesFact.getCurrentSession().save(user);
	}
	
	/**
	 * @param user
	 */
	public void update(User user) {
		sesFact.getCurrentSession().update(user);
	}
	
	/**
	 * @param user
	 */
	public void delete(User user) {
		sesFact.getCurrentSession().delete(user);;
	}
	
	/**
	 * @param id
	 * @return
	 */
	public User selectById(int id) {
		return sesFact.getCurrentSession().get(User.class, id);
	}
	
	/**
	 * @param username
	 * @return
	 */
	public User selectByUsername(String username) {
		List<User> users = sesFact.getCurrentSession().createNativeQuery("select * from"+
				" Users where username='"+username
				+"'", User.class).list();
		return users.get(0);
	}
	
	/**
	 * @return
	 */
	public List<User> selectAll(){
		System.out.println();
		return sesFact.getCurrentSession().createQuery("from User", User.class).list();
	}
	
	/**
	 * @param username
	 * @param password
	 * @return
	 */
	public String getHash(String username, String password) {
		return (String) sesFact.getCurrentSession().createNativeQuery("SELECT GET_USER_HASH(:username, :password) FROM DUAL")
		.setParameter("username", username)
		.setParameter("password", password)
		.getSingleResult();		
	}
	
	

}
