package com.bluebarracuda.repo;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluebarracuda.model.Profile;


@Repository("profileRepo")
@Transactional
public class ProfileRepo {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private SessionFactory sesFact;
	
	public ProfileRepo() {
		
	}
	
	@Autowired
	public ProfileRepo(SessionFactory sesFact) {
		this.sesFact = sesFact;
	} 
	
	public void insert(Profile prof) {
		sesFact.getCurrentSession().save(prof);	
	}
	
	public void update(Profile prof) {
		sesFact.getCurrentSession().update(prof);
	}
	
	public void delete(Profile prof) {
		sesFact.getCurrentSession().delete(prof);
	}
	
	public Profile selectById(int id) {
		return sesFact.getCurrentSession().get(Profile.class,id);
	}
	
	public List<Profile> selectAll(){
		return sesFact.getCurrentSession().createQuery("from Profile", Profile.class).list();
	}
}
