/**
 * @autor pathmasri
 * May 10, 2015 8:20:23 PM
 */
package com.sample.projections;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.sample.model.Student;
import com.sample.utils.HibernateUtils;

public class DemoProjections {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//testProjections();
		testExampleQuery();
	}
	
	private static void testProjections(){
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
	     
		Criteria criteria = session.createCriteria(Student.class);
		 //Ordering
         //criteria.addOrder(Order.desc("studentId"));
		
		 // Selecting a column
		  criteria.setProjection(Projections.property("studentId"));	
		List<Student> students = (List<Student>)criteria.list();
		
		for(int i=0; i< students.size();i++ ){
			System.out.println(students.get(i).getStudentName());
		}				
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	private static void testExampleQuery(){
		
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Student exampleStudent = new Student();
		exampleStudent.setStudentId(4);
		exampleStudent.setStudentName("student5");
		//Example example = Example.create(exampleStudent).enableLike();
		Example example = Example.create(exampleStudent).excludeProperty("studentId");
		Criteria criteria = session.createCriteria(Student.class).add(example);
	
		List<Student> students = (List<Student>)criteria.list();
		
		for(int i=0; i< students.size();i++ ){
			System.out.println(students.get(i).getStudentName());
		}				
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

}
