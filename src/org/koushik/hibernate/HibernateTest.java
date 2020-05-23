package org.koushik.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.javabrains.koushik.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("first name");
		user.setJoinedDate(new Date());
		user.setAddress("First user's address ");
		user.setDescription("users description goes here ");
		
				
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		

	}

}
