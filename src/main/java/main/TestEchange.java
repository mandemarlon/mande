package main;

//import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.City;
import model.Heroes;

public class TestEchange {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("marlon");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {

			txn.begin();

			
			Heroes h = new Heroes();
			City c = new City();

			c = em.find(City.class, 2L);
		

			h = em.find(Heroes.class, 1L);

			h.setCity(c);

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

	}

}