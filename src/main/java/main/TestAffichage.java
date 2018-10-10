package main;

import java.util.Set;

//import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.City;
import model.Heroes;

public class TestAffichage {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("marlon");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		City c = null;
		
		
		try {

			txn.begin();
			
			c=em.find(City.class, 1L);
			Set<Heroes> heroes = c.getHeroes();
			heroes.size();

			txn.commit();

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();

		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}

		}

		System.out.println(c.getHeroes());
	}

}
