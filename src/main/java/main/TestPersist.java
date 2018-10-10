package main;

//import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.City;
import model.Heroes;

public class TestPersist {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("marlon");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {

			txn.begin();
			;
			Heroes h = new Heroes();
			Heroes h1 = new Heroes();
			Heroes h2 = new Heroes();
			Heroes h3 = new Heroes();
			City c = new City();
			City c1 = new City();

			h.setName("Achilleus");
			h1.setName("Agamemnon");
			h2.setName("Enée");
			h3.setName("Hector");

			c.setNameOfTheCity("Troy");
			c1.setNameOfTheCity("Mycènes");
			
			h.setCity(c1);
			h1.setCity(c1);
			h2.setCity(c);
			h3.setCity(c);

			

			c1.getHeroes().add(h);
			c1.getHeroes().add(h1);
			c.getHeroes().add(h2);
			c.getHeroes().add(h3);
			
			
//			p.getStudents().add(st1);
//			p.getStudents().add(st2);
//			p.getStudents().add(st3);
//			p.getStudents().add(st4);
//		
	//		p = em.find(Professor.class, 7L);
//			p=em.find(Professor.class, 14L);
//			
//			st=em.find(Student.class, 24L);
//			
//			st.setProfessor(p);

//			
			em.persist(h);
			em.persist(h2);
			em.persist(h1);
			em.persist(h3);


			em.persist(c);

//			Set<Student> students = p.getStudents();
//			students.size();

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
