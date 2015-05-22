/**
 * @autor pathmasri
 * May 10, 2015 7:11:43 PM
 */
package com.sample.criteriaapi;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.sample.model.Student;
import com.sample.utils.HibernateUtils;

public class DemoCriteiriaApi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
	     
		Criteria criteria = session.createCriteria(Student.class);
		
//		criteria.add(Restrictions.like("studentName","%student%"))
//		        .add(Restrictions.ge("studentId", 2))
//		        .add(Restrictions.between("studentId", 3, 9));
		
		criteria.add(Restrictions.or(Restrictions.eq("studentId",1),
				Restrictions.eq("studentName", "Pathmasri")));
		
		
		
		List<Student> students = (List<Student>)criteria.list();
		
		for(int i=0; i< students.size();i++ ){
			System.out.println(students.get(i).getStudentName());
		}
		
		
		session.getTransaction().commit();
		session.close();
		sf.close();

	}

}
