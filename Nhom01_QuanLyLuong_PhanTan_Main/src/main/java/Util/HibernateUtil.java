package Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class HibernateUtil {
	/**
	 * Launch the application. Tên: Võ Thị Trà Giang Ngày tạo: 21/08/2022
	 */
private static HibernateUtil instance = null;
	
	private EntityManager entityManager;
	
	public HibernateUtil() {
		entityManager = Persistence.createEntityManagerFactory("Nhom01_QuanLyLuong_PhanTan")
				.createEntityManager();
	}
	
	public synchronized static HibernateUtil getInstance() {
		if(instance == null) {
			instance = new HibernateUtil();			
		}
		return instance;
		
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
