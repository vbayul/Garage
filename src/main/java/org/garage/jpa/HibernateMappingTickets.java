package org.garage.jpa;

import java.util.List;

import org.garage.model.Ticket;
import org.hibernate.Session;

public class HibernateMappingTickets {
	
	public List<Ticket> getTickets(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Ticket> tickets = session.createQuery("from Ticket").list();
		session.getTransaction().commit();

		return tickets;
	}
	
	public Ticket getTicket(int idTicket) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();	
		Ticket ticket = (Ticket) session.createQuery("from Ticket where id = :idTiket")
				.setParameter("idTiket", idTicket).uniqueResult();
		session.getTransaction().commit();
		
		return ticket;
	}
	
	public void updateTicket(Ticket ticket){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		session.update(ticket);
		session.getTransaction().commit();		
	}
	
	public int saveTicket(Ticket ticket){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		int id = (Integer) session.save(ticket);
		session.getTransaction().commit();		
		return id;
	}

}
