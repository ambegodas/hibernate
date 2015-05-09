/**
 * @autor pathmasri
 * May 8, 2015 9:05:01 PM
 */
package com.sample.embededobjects;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.sample.model.Address;
import com.sample.model.UserDetails;
import com.sample.utils.HibernateUtils;

public class DemoEmbeddedObjects {
	
	public static void main(String args[]){
		
		UserDetails user = new UserDetails();
		user.setUserName("Eroshi");
		user.setJoiningDate(new Date());
		user.setDescription("test description");
		Address homeAddress = new Address();
		homeAddress.setStreet("Sriya mavawatha");
		homeAddress.setCity("Panadura");
		homeAddress.setState("Western Province");
		homeAddress.setPincode("1004");
		user.setHomeAddress(homeAddress);
		
		Address officeAddres = new Address();
		officeAddres.setStreet("Main Street");
		officeAddres.setCity("Kurunegala");
		officeAddres.setState("Easter Province");
		officeAddres.setPincode("1009");
		user.setOfficeAddress(officeAddres);
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		
	}
	

}
