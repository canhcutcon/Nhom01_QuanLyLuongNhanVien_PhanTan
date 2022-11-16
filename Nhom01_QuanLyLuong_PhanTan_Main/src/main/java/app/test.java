package app;

import Util.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class test {
	public static void main(String[] args) {
		EntityManager entityManager;
		EntityTransaction entityTransaction;
		entityManager =HibernateUtil.getInstance().getEntityManager();
		entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityTransaction.commit();
		}catch (Exception e) {
			// TODO: handle exception
			entityTransaction.rollback();
		}
		
	}
}
