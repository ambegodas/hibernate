/**
 * @autor pathmasri
 * Aug 17, 2014 12:30:13 AM
 */
package com.sample.save;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateMain {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	public static void main(String[] args){
		UserDetails user = new UserDetails();
		//user.setUserID(5);
		user.setUserName("Pathmasri");
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
