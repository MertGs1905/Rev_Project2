package com.bluebarracuda.repo;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluebarracuda.model.Registration;
import com.bluebarracuda.model.User;

@Repository("registerRepo")
@Transactional
public class RegistrationRepo {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private SessionFactory sesFact;

	public RegistrationRepo() {
	}

	@Autowired
	public RegistrationRepo(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}
	
	public void insert(Registration registration) {		
		sesFact.getCurrentSession().save(registration);
	}

}
