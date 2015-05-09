/**
 * @autor pathmasri
 * May 9, 2015 6:34:10 PM
 */
package com.sample.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sample.model.Student;
import com.sample.utils.HibernateUtils;

public class DemoCrud {
	
	public static void main(String[] args){
		
       //insertData();
       //readData();
		//deleteData();
		updateData();
		
		

	}
	
	private static void insertData(){
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
	
		for(int i=0;i<10;i++){
			Student st = new Student();
			st.setStudentName("student"+i);
			s.save(st);
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	private static void readData(){
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
	
	    Student st =	(Student)s.get(Student.class, 1);
		
	   // System.out.println(st.getStudentName());
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
		System.out.println(st.getStudentName());
	}
	
	private static void deleteData(){
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
	
	    Student st =	(Student)s.get(Student.class, 4);
		s.delete(st);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	private static void updateData(){
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
	
	    Student st =	(Student)s.get(Student.class, 3);
		st.setStudentName("Pathmasri");
		s.save(st);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}

}
