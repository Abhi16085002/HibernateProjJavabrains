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
		
//		for(int i=0;i<10;i++) {
//			UserDetails user = new UserDetails() ;
//			user.setUserName("user " + i );
//			session.save(user);
//		}
		
		 UserDetails user = session.get(UserDetails.class, 5 );
//		 System.out.println("User name pulled up is " + user.getUserName() );
		 
//		 session.delete(user);
		 
		 user.setUserName("Updated user");
		 session.update(user);
		
		session.getTransaction().commit();
		session.close();
		
		
	}

}
