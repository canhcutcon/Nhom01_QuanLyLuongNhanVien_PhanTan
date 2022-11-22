package app;

import java.rmi.RemoteException;

import Util.HibernateUtil;
import dao.NhanVienDao;
import daoImpl.NhanVienDaoImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class test {
	public static void main(String[] args) throws RemoteException {
		
		//Create database
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
		
		NhanVienDao nv = new NhanVienDaoImpl();
		System.out.println(nv.getNhanVienTheoMa(1).getTenNV());
		
	}
}
