package app;

import java.rmi.Naming;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import dao.PhongBanDao;

public class aaaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
EntityManager entityManager = Persistence.createEntityManagerFactory("Nhom01_QuanLyLuong_PhanTan").createEntityManager();
		
		try {
			PhongBanDao phongBanDao = (PhongBanDao)Naming.lookup("rmi://172.28.150.126:8988/phongBanDao");
			phongBanDao.getListPhongBan().forEach(e -> System.out.println(e));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
