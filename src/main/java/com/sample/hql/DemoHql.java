/**
 * @autor pathmasri
 * May 9, 2015 9:19:49 PM
 */
package com.sample.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sample.model.Student;
import com.sample.utils.HibernateUtils;

public class DemoHql {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//usePagination();
		//retrieveOnlyMember();
		//sqlInjection();
		//parameterBinding();
		//testNamedQueries();
		testNamedNativeQueries();
		
	}
	
	private static void retrieveData(){
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		
		//Query query = s.createQuery("from Student");
		Query query = s.createQuery("from Student where studentId>5");

		List<Student> students = (List<Student>)query.list();

		s.close();
		sf.close();
		
		//System.out.println(students.size());
		
		for (Student st: students){
			System.out.println(st.getStudentName());
		}

	}
	
	private static void usePagination(){
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		
		//Query query = s.createQuery("from Student");
		Query query = s.createQuery("from Student");
		query.setFirstResult(3);
		query.setMaxResults(4);

		List<Student> students = (List<Student>)query.list();

		s.close();
		sf.close();
		
		//System.out.println(students.size());
		
		for (Student st: students){
			System.out.println(st.getStudentName());
		}
	}
	
	private static void retrieveOnlyMember(){
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		
		//Query query = s.createQuery("from Student");
		Query query = s.createQuery("select studentName from Student");
		query.setFirstResult(3);
		query.setMaxResults(4);

		List<String> studentNames = (List<String>)query.list();

		s.close();
		sf.close();
		
		//System.out.println(students.size());
		
		for (String name: studentNames){
			System.out.println(name);
		}
	}
	
	private static void sqlInjection(){
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		String studentId = "1 or 1=1";
		//Query query = s.createQuery("from Student");
		Query query = s.createQuery("select studentName from Student where studentId > "+ studentId);

		List<String> studentNames = (List<String>)query.list();

		s.close();
		sf.close();
		
		//System.out.println(students.size());
		
		for (String name: studentNames){
			System.out.println(name);
		}
	}
	
	private static void parameterBinding(){
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		String studentId = "5";
		
//		Query query = s.createQuery("select studentName from Student where studentId > ? and studentName = ?");
//        query.setInteger(0, Integer.parseInt(studentId));
//        query.setString(1, "student9");
        
		Query query = s.createQuery("select studentName from Student where studentId > :studenId and studentName = :studentName");
        query.setInteger("studenId", Integer.parseInt(studentId));
        query.setString("studentName", "student9");
                		
		List<String> studentNames = (List<String>)query.list();

		s.close();
		sf.close();
		
		//System.out.println(students.size());
		
		for (String name: studentNames){
			System.out.println(name);
		}
	}
    
	
	private static void testNamedQueries(){
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		
		Query q = s.getNamedQuery("student.byId");
		q.setInteger(0, 3);	
		
		List<Student> students = (List<Student>)q.list();


		s.close();
		sf.close();
		
		//System.out.println(students.size());
		
		for (Student st: students){
			System.out.println(st.getStudentName());
		}
	}
	
	private static void testNamedNativeQueries(){
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		
		Query q = s.getNamedQuery("Student.byName");
		q.setString(0, "Pathmasri");
		
		List<Student> students = (List<Student>)q.list();


		s.close();
		sf.close();
		
		//System.out.println(students.size());
		
		for (Student st: students){
			System.out.println(st.getStudentName());
		}
	}

}
