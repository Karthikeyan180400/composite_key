package com.ty.compositkey;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestValidateUser {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "select u from User u where (u.userId.email=?1 or u.userId.phone=?2) and u.password=?3";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, "kar@mail.com");
		query.setParameter(2, 121212121l);
		query.setParameter(3, "12131415");

		List<User> users = query.getResultList();
		if (users.size() > 0) {
			System.out.println("Valid User");
		} else {
			System.out.println("Email or Password is incorrect");
		}

	}

}
