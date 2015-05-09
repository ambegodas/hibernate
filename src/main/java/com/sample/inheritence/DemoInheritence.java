/**
 * @autor pathmasri
 * May 9, 2015 4:30:30 PM
 */
package com.sample.inheritence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sample.model.FourWheeler;
import com.sample.model.GenericVehicle;
import com.sample.model.TwoWheeler;
import com.sample.utils.HibernateUtils;

public class DemoInheritence {
	
	public static void main(String[] args){
		
		GenericVehicle vehicle = new GenericVehicle();
		vehicle.setVehicleType("Car");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setSteerHandle("handle");
		bike.setVehicleType("Bike");
		
		FourWheeler car = new FourWheeler();
		car.setSteeringWheeler("Streering Wheeler");
		car.setVehicleType("Porsche");
		
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(vehicle);
		session.save(car);
		session.save(bike);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

}
