package com.bluebarracuda.repo;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluebarracuda.model.Rating;



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
	
	public void insert(Rating rate) {
		
		sesFact.getCurrentSession().save(rate);
	}
	
	public void update(Rating rate) {
		sesFact.getCurrentSession().update(rate);
	}
	
	public void delete(Rating rate) {
		sesFact.getCurrentSession().delete(rate);;
	}
	
	public Rating selectById(int id) {
		return sesFact.getCurrentSession().get(Rating.class, id);
	}
	
	public List<Rating> selectAll(){
		return sesFact.getCurrentSession().createQuery("from Rating", Rating.class).list();
	}
	
}
