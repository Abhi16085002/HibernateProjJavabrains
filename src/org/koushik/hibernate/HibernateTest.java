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
				
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("car");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("bike");
		bike.setSteeringHandle("bike steeringHaandle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("porsche");
		car.setSteeringWheel("porche Steering Wheel");
		
		
				
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		
		session.getTransaction().commit();
		session.close();
		
		
	}

}
