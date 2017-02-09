package org.garage.jpa;

import java.util.List;

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
	
	public List<Client> getClient(int idClient){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Client> client = session.createQuery("from Client where id = :idClient")
				.setParameter("idClient", idClient).list();
		session.getTransaction().commit();
		
		return client;
	}

}
