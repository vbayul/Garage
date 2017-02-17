package org.garage.jpa;

import java.util.List;

import org.garage.model.Car;
import org.hibernate.Session;

public class HibernateMappingCars {
	
	public List<Car> getCars(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Car> cars = session.createQuery("from Car").list();
		
		session.getTransaction().commit();
		return cars;
	}
	
	public Car getCar(int idCar){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Car car = (Car) session.createQuery("from Car where id = :idCar")
				.setParameter("idCar", idCar).uniqueResult();
		session.getTransaction().commit();
		
		return car;
	}

	public int addCar(Car car){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		int id = (Integer) session.save(car);
		
		session.getTransaction().commit();
		return id;
	}
	
	public void updateCar(Car car){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		session.update(car);
		
		session.getTransaction().commit();
	}
}
