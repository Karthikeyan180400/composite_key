package com.ty.compositkey;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestGetUserByEmail {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		String sql = "select u from User u where u.userId.email=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, "peter@mail.com");
		List<User> user = query.getResultList();
		if (user.size() > 0) {
			for (User user2 : user) {

				System.out.println("Name is " + user2.getName());
				System.out.println("Age is " + user2.getAge());
				System.out.println("Gender is " + user2.getGender());
				UserId userId1 = user2.getUserId();
				System.out.println("Email is " + userId1.getEmail());
				System.out.println("Phone is " + userId1.getPhone());
			}
		} else {
			System.out.println("No User Exists");
		}

	}

}
