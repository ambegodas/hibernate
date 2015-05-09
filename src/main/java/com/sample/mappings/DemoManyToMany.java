/**
 * @autor pathmasri
 * May 9, 2015 11:46:35 AM
 */
package com.sample.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sample.model.Employee;
import com.sample.model.LapTop;
import com.sample.utils.HibernateUtils;

public class DemoManyToMany {
	
	public static void main(String args[]){
		
		Employee e1 = new Employee();
		e1.setEmployeeName("Pathmasri");
		
		Employee e2 = new Employee();
		e2.setEmployeeName("Wathsala");
		
		LapTop l1 = new LapTop();
		l1.setLaptopName("Toshiba");
		
		LapTop l2 = new LapTop();
		l2.setLaptopName("Dell");
		
		e1.getLaptops().add(l1);
		e1.getLaptops().add(l2);
		
		l1.getEmployees().add(e1);
		l1.getEmployees().add(e2);
		
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(e1);
		s.save(e2);
		s.save(l1);
		s.save(l2);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
		
		
		
		
	}

}
