package com.ty.compositkey;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveUser {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		UserId userId1 = new UserId();
		userId1.setEmail("eesh@mail.com");
		userId1.setPhone(12162121);

		User user = new User();
		user.setUserId(userId1);
		user.setName("Eeshwaran");
		user.setAge(24);
		user.setGender("Male");
		user.setPassword("123434415");

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();

	}

}
