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
		
		UserDetails user = new UserDetails();         // Transient Object
		user.setUserName("Test User");                    
				
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
//		user.setUserName("Update User");
		
		session.save(user);  // persistent object
		
		user.setUserName("Update User");
		user.setUserName("Update User Again");
		
		
		session.getTransaction().commit();
		session.close();
		
		user.setUserName("Updated user After Session Close");
		
	}

}
