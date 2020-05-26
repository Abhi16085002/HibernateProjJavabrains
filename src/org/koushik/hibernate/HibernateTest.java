package org.koushik.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
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
		
//		for(int i=1;i<=10;i++) {
//		     UserDetails user = new UserDetails();
//		     user.setUserName("user " + i );
//		     session.save(user);
//		}
		
		
//		Query query = session.createQuery("from UserDetails");
		Query query = session.createQuery("from UserDetails where userId > 5 ");
		List users = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Size of list result = " + users.size() );
		
	}

}
