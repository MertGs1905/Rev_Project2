package com.bluebarracuda.repo;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
		
		Session session = sesFact.openSession();
	      Transaction tx = null;
	    String  newPass = getHash(user.getUsername(), randString);
	      try{
	         tx = session.beginTransaction();
	         user = session.get(User.class, user.getPassword()); 
	         user.setPassword( newPass );
	         session.update(user); 
	         tx.commit();
	      }catch(HibernateException e) {
	          if (tx!=null) tx.rollback();
	          e.printStackTrace(); 
	       }
	}
	
	public void delete(User user) {
		sesFact.getCurrentSession().delete(user);;
	}
	
	public User selectById(int id) {
		return sesFact.getCurrentSession().get(User.class, id);
	}
	
	public User selectByUsername(String username) {
		List<User> users = sesFact.getCurrentSession().createNativeQuery("select * from"+
				" Users where username='"+username
				+"'", User.class).list();
		return users.get(0);
	}
	
	public List<User> selectAll(){
		System.out.println();
		return sesFact.getCurrentSession().createQuery("from User", User.class).list();
	}
	
	public String getHash(String username, String password) {
		return (String) sesFact.getCurrentSession().createNativeQuery("SELECT GET_USER_HASH(:username, :password) FROM DUAL")
		.setParameter("username", username)
		.setParameter("password", password)
		.getSingleResult();		
	}
	
	

}
