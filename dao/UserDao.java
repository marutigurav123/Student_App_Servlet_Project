package com.servlet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import com.servlet.dto.User;



public class UserDao {

	public static void saveUser(User u) {
		
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dbinfo");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(u);
		entityTransaction.commit();
			
	}
	
	public static User getUser(String email, String password)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dbinfo");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query q=entityManager.createQuery("select u from User u where email = ?1 and password = ?2",User.class);
		q.setParameter(1, email);
		q.setParameter(2, password);
		 List<User> ListofUser=q.getResultList();
		 if (ListofUser.size() == 1) {
				return (User) ListofUser.get(0);
			
		}
			return null;
				}
	

}
