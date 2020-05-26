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
		
		
		Query query = session.createQuery("select userName from UserDetails ");
//		Query query = session.createQuery("from UserDetails");
//		Query query = session.createQuery("from UserDetails where userId > 5 ");
		query.setFirstResult(5);
		query.setMaxResults(4);
		
//		List<UserDetails> users = (List<UserDetails>) query.list();
		List<String> userNames = (List<String>) query.list();
		
		session.getTransaction().commit();
		session.close();
		
//		System.out.println("Size of list result = " + users.size() );
		
//		for(UserDetails u : users)
//			System.out.println(u.getUserName());
		
		for(String u : userNames)
			System.out.println(u);
		
	}

}
