/**
 * @autor pathmasri
 * May 9, 2015 9:36:11 AM
 */
package com.sample.lazyandeager;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sample.model.Address;
import com.sample.model.UserDetails;
import com.sample.utils.HibernateUtils;

public class DemoFetchTypes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class, 5);
		session.close();
		System.out.print(user.getAddress().size());

	}

}
