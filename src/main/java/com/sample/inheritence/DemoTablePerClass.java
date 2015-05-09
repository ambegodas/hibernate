/**
 * @autor pathmasri
 * May 9, 2015 5:21:29 PM
 */
package com.sample.inheritence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sample.model.Computer;
import com.sample.model.Desktop;
import com.sample.model.Tablet;
import com.sample.utils.HibernateUtils;

public class DemoTablePerClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Computer c = new Computer();
		c.setComputerName("Server");
		
		Tablet t = new Tablet();
		t.setComputerName("Tablet");
		t.setTouchScreenType("Multi Touch");
		
		Desktop d = new Desktop();
		d.setComputerName("DeskTop");
		d.setMonitorType("CRT");
		
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(c);
		session.save(d);
		session.save(t);
		
		session.getTransaction().commit();
		
		session.close();
		sf.close();
	}

}
