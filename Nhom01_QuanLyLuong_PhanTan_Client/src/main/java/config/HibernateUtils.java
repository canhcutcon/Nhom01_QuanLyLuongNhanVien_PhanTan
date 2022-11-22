package config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {
	private static HibernateUtils instance = null;
	private EntityManagerFactory entityManagerFactory;
	
	private HibernateUtils() {
		entityManagerFactory = Persistence.createEntityManagerFactory("Nhom01_QuanLyLuong_PhanTan");
	}

	public synchronized static HibernateUtils getInstance() {
		if(instance == null)
			instance = new HibernateUtils();
		return instance;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
