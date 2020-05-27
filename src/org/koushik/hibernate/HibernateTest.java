package org.koushik.hibernate;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
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
		
//		Criteria criteria = session.createCriteria(UserDetails.class);   // it is depricated
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<UserDetails> criteria = builder.createQuery(UserDetails.class);
		Root<UserDetails> root = criteria.from(UserDetails.class);
		criteria.select(root);
		criteria.where(builder.equal(root.get("userName"), "user 10" ));
		Query<UserDetails> q = session.createQuery(criteria);
		
		List<UserDetails> users =  q.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		
		for(UserDetails u : users)
			System.out.println(u.getUserName());
		
	}

}
//query.where(builder.or(builder.between(root.get("userId"), 7, 10),(builder.equal(root.get("userId"), 5))));
