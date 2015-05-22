/**
 * @autor pathmasri
 * May 10, 2015 9:51:15 PM
 */
package com.sample.caching;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.sample.model.Student;
import com.sample.utils.HibernateUtils;

public class DemoCaching {

	public static void main(String[] args){
		//testFirstLevelCaching();
		
		//testSecondLevelCaching();
		
		testQueryCaching();
	}

	/**
	 * 
	 */
	private static void testQueryCaching() {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
	    
		Query query = session.createQuery("from Student where studentId=4");
		query.setCacheable(true);
		List users = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sf.openSession();
		session2.beginTransaction();
		
		
		Query query2 = session2.createQuery("from Student where studentId=4");
		query2.setCacheable(true);
		List users2 = query2.list();
		
		session2.getTransaction().commit();
		session2.close();
		sf.close();	
		
	}

	/**
	 * 
	 */
	private static void testSecondLevelCaching() {
		
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
	    
		Student student = (Student)session.get(Student.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sf.openSession();
		session2.beginTransaction();
		Student student2 = (Student)session2.get(Student.class, 1);
		
		System.out.println(student2.getStudentName());
		
		session2.getTransaction().commit();
		session2.close();
		sf.close();	
		
	}

	/**
	 * 
	 */
	private static void testFirstLevelCaching() {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
	    
		Student student = (Student)session.get(Student.class, 1);
		
		student.setStudentName("teschache");
		
		// A select query will not be run for this one. Result will be taken from the cache
		Student student2 = (Student)session.get(Student.class, 1);
		
		System.out.println(student2.getStudentName());
		
		session.getTransaction().commit();
		session.close();
		sf.close();		
	}
	
}
