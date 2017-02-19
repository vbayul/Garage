package org.garage.jpa;

import java.util.List;

import org.garage.model.Trouble;
import org.hibernate.Session;

public class HibernateMappingTroubles {
	
	public List<Trouble> getTroubles(){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Trouble> trouble = session.createQuery("from Trouble").list();
		
		session.getTransaction().commit();
		
		return trouble;		
	}

}
