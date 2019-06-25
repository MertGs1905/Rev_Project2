package com.bluebarracuda.repo;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluebarracuda.model.Ratings;



@Repository("ratingRepo")
@Transactional
public class RatingRepo {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private SessionFactory sesFact;

	public RatingRepo() {
	}
	

	@Autowired
	public RatingRepo(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}
	
	public void insert(Ratings rate) {
		
		sesFact.getCurrentSession().save(rate);
	}
	
	public void update(Ratings rate) {
		sesFact.getCurrentSession().update(rate);
	}
	
	public void delete(Ratings rate) {
		sesFact.getCurrentSession().delete(rate);;
	}
	
	public Ratings selectById(int id) {
		return sesFact.getCurrentSession().get(Ratings.class, id);
	}
	
	public List<Ratings> selectAll(){
		return sesFact.getCurrentSession().createQuery("from Ratings", Ratings.class).list();
	}
	
}
