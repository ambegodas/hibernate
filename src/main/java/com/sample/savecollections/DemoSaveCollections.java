/**
 * @autor pathmasri
 * May 9, 2015 8:05:10 AM
 */
package com.sample.savecollections;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sample.model.Address;
import com.sample.model.UserDetails;
import com.sample.utils.HibernateUtils;

public class DemoSaveCollections {
	
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
	
	user.getAddress().add(officeAddres);
	user.getAddress().add(homeAddress);
	
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	session.save(user);
	session.getTransaction().commit();
	session.close();
	}
}
