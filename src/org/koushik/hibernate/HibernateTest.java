package org.koushik.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.javabrains.koushik.dto.Address;
import org.javabrains.koushik.dto.FourWheeler;
import org.javabrains.koushik.dto.TwoWheeler;
import org.javabrains.koushik.dto.UserDetails;
import org.javabrains.koushik.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user =(UserDetails) session.get(UserDetails.class,1); 
		
		session.getTransaction().commit();
		session.close();
		
//		user.setUserName("updated username after session close ");
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.update(user);             // not made any changes but updated query still run
//		user.setUserName("Change After Update");  
		
		session.getTransaction().commit();
		session.close();
		
		
		
		
	}

}
