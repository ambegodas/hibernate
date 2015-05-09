/**
 * @autor pathmasri
 * May 9, 2015 8:25:13 PM
 */
package com.sample.transientpersistentdetached;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sample.model.Student;
import com.sample.utils.HibernateUtils;

public class DemoDetachedToPersistent {
	
	public static void main(String args[]){
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
	   //persistent
	    Student st =	(Student)s.get(Student.class, 7);
	    
		s.close();
		//detached
		
		
		// We'll try to make it persistent again
		st.setStudentName("Updated name after the session is closed");
		s = sf.openSession();
		s.beginTransaction();
		s.update(st);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
			
	}

}
