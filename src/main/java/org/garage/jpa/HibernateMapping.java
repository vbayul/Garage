package org.garage.jpa;

import java.util.List;

import org.garage.model.Car;
import org.garage.model.Client;
import org.hibernate.Session;

public class HibernateMapping {
	
	public List<Client> getClients(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Client> clients = session.createQuery("from Client").list();
		
		session.getTransaction().commit();
		return clients;
	}
	
	public List<Car> getCars(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Car> cars = session.createQuery("from Car").list();
		
		session.getTransaction().commit();
		return cars;
	}
	
	public Client getClient(int idClient){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Client client = (Client) session.createQuery("from Client where id = :idClient")
				.setParameter("idClient", idClient).uniqueResult();
		session.getTransaction().commit();
		
		return client;
	}
	
	public Car getCar(int idCar){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Car car = (Car) session.createQuery("from Car where id = :idCar")
				.setParameter("idCar", idCar).uniqueResult();
		session.getTransaction().commit();
		
		return car;
	}

	public void updateClient(Client client){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		session.update(client);
		
		session.getTransaction().commit();
	}
	
}
