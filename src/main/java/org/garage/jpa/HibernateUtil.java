package org.garage.jpa;

import org.garage.model.Car;
import org.garage.model.Client;
import org.garage.model.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = builtSessionFactory();
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static SessionFactory builtSessionFactory(){
		try{
			return new AnnotationConfiguration()
	                .configure()
					.addAnnotatedClass(Client.class)
					.addAnnotatedClass(Car.class)
					.addAnnotatedClass(Ticket.class)
					.buildSessionFactory();
		}catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
}
