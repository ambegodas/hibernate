/**
 * @autor pathmasri
 * May 9, 2015 10:00:00 AM
 */
package com.sample.mappings;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sample.model.Address;
import com.sample.model.Employee;
import com.sample.model.UserDetails;
import com.sample.model.Vehicle;
import com.sample.utils.HibernateUtils;

public class DemoOneToOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Employee emp = new Employee();
		emp.setEmployeeName("Pathmasri");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");
		
		emp.getVehicles().add(vehicle);
		emp.getVehicles().add(vehicle2);
		
		vehicle.setUser(emp);
		vehicle2.setUser(emp);
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(emp);
		//session.save(vehicle);
		//session.save(vehicle2);
		
	
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		// TODO Auto-generated method stub

	}

}
