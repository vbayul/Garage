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
	
	public Client getClient(int idClient){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Client client = (Client) session.createQuery("from Client where id = :idClient")
				.setParameter("idClient", idClient).uniqueResult();
		session.getTransaction().commit();
		
		return client;
	}
	
	public void updateClient(Client client){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		session.update(client);
		
		session.getTransaction().commit();
	}
	
	public List<Car> getCars(int idClient){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Car> cars = session.createQuery("from Car where idclients = :idClient")
								.setParameter("idClient", idClient).list();
		
		session.getTransaction().commit();
		
		return cars;
	}

	public void deleteCarFromClient(int idCar){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Car car = (Car) session.createQuery("from Car where idcars = :idCar")
							   .setParameter("idCar", idCar).uniqueResult();
		car.setIdclients(0);
		session.update(car);		
		
		session.getTransaction().commit();
	}
}
