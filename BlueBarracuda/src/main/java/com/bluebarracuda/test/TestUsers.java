package com.bluebarracuda.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amazonaws.services.identitymanagement.model.User;
import com.bluebarracuda.repo.UserRepo;

import antlr.collections.List;



public class TestUsers {
	
	
	static UserRepo users;
	
	@BeforeClass
	public static void setUpBefore() {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    users = appContext.getBean(UserRepo.class);
	}
	
	
	
	@Test
	public void test() {
		//fail("Not yet implemented");
		
		List usersAll = (List) users.selectAll();

	
		assertFalse(usersAll.equals(null));
	}

}
