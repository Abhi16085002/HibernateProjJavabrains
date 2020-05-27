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
		String minUserId = "5";
//		String minUserId = "5 or 1=1"; 
		String userName = "user 10";
		
//		Query query = session.createQuery("from UserDetails where userId >  " + minUserId );
//		Query query = session.createQuery("from UserDetails where userId > ?0 " );
		Query query = session.createQuery("from UserDetails where userId > :userId and userName = :userName " );
//		query.setParameter(0, Integer.parseInt(minUserId));
		query.setParameter("userId", Integer.parseInt(minUserId));
		query.setParameter("userName", userName);
		
		
		List<UserDetails> users = (List<UserDetails>) query.list();
		
		session.getTransaction().commit();
		session.close();
		
		
		for(UserDetails u : users)
			System.out.println(u.getUserName());
		
	}

}
