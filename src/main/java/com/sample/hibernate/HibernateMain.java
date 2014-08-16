/**
 * @autor pathmasri
 * Aug 17, 2014 12:30:13 AM
 */
package com.sample.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMain {
	
	public static void main(String[] args){
		UserDetails user = new UserDetails();
		user.setUserID(1);
		user.setUserName("Pathmasri");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	
	

}
