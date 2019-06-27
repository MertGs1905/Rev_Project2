package com.bluebarracuda.repo;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.bluebarracuda.model.Users;

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
	
	public int insert(Users user) {		
		System.out.println("In user insert");
		return (int) sesFact.getCurrentSession().save(user);
	}
	
	public void update(Users user) {
		sesFact.getCurrentSession().update(user);
	}
	
	public void delete(Users user) {
		sesFact.getCurrentSession().delete(user);;
	}
	
	public Users selectById(int id) {
		return sesFact.getCurrentSession().get(Users.class, id);
	}
	
	public Users selectByUsername(String username) {
		List<Users> users = sesFact.getCurrentSession().createNativeQuery("select * from"+
				" Users where username='"+username
				+"'", Users.class).list();
		return users.get(0);
	}
	
	public List<Users> selectAll(){
		System.out.println();
		return sesFact.getCurrentSession().createQuery("from User", Users.class).list();
	}
	
	

}
