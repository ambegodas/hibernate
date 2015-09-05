/**
 * @autor pathmasri
 * May 25, 2015 11:32:01 PM
 */
package com.sample.interceptors;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory buildSessionFactory() {

		   Configuration configuration = new Configuration().setInterceptor(new MyInterceptor());
	        configuration.configure();
	        serviceRegistry = new ServiceRegistryBuilder().
applySettings(configuration.getProperties()).buildServiceRegistry();        
	        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	        return sessionFactory;		
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

}