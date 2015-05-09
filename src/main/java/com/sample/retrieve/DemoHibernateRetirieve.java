/**
 * @autor pathmasri
 * May 8, 2015 5:21:10 AM
 */
package com.sample.retrieve;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.sample.save.UserDetails;


public class DemoHibernateRetirieve {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	public static void main(String[] args){
		UserDetails user = new UserDetails();
		user.setUserID(7);
		user.setUserName("Wathsala");
		user.setAddress("Address");
		user.setJoiningDate(new Date());
		user.setDescription("Description");
		ArrayList<UserDetails> users = new ArrayList<UserDetails>();
		users.add(user);
		//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		SessionFactory sessionFactory = createSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//session.saveOrUpdateAll(users);
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session  = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 7);
		session.clear();
		System.out.println(user.toString());
		
	}
	
	
	/*
	 * Session factory is an expensive object. It is better to re-use the same factory to create sessions.
	 */
	public static SessionFactory createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
	
	

}
