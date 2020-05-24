package org.koushik.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.javabrains.koushik.dto.Address;
import org.javabrains.koushik.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUserName("first name");
		
		Address addr = new Address();
		addr.setCity("city name");
		addr.setPincode("pincode ");
		addr.setState("state name");
		
		user.setHomeAddress(addr);
		
		Address addr2 = new Address();
		addr2.setCity("second city");
		addr2.setPincode("second pin code");
		
		user.setOfficeAddress(addr2);
				
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		

	}

}
