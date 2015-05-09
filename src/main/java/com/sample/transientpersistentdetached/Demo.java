/**
 * @autor pathmasri
 * May 9, 2015 7:22:16 PM
 */
package com.sample.transientpersistentdetached;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sample.model.Student;
import com.sample.utils.HibernateUtils;

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
	    // Before save the object, Its called transient
	    Student st =	(Student)s.get(Student.class, 7);
	    
	    //After saving the object becomes persistent
	    s.save(st);
	    // Updating after saving. Still the update will be reflected in the object
	    st.setStudentName("Ambegoda");
		
		s.getTransaction().commit();
		st.setStudentName("Wathsala");
		// Now the object is in detached state. Hibernate does not keep track on any changes to the object
		s.close();
		sf.close();


	}

}
