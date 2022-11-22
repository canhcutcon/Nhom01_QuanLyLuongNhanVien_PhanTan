package app;

import java.rmi.Naming;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import dao.LoaiPhatDao;
import dao.NhanVienDao;
import dao.PhongBanDao;
import entity.NhanVien;

public class Test {

	public static void main(String[] args) {
		
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy", "policy\\policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		// TODO Auto-generated method stub
		EntityManager entityManager = Persistence.createEntityManagerFactory("Nhom01_QuanLyLuong_PhanTan").createEntityManager();
		
		try {
//			PhongBanDao phongBanDao = (PhongBanDao)Naming.lookup("rmi://LAPTOP-27HK0FFM:8988/phongBanDao");
//			LoaiPhatDao loaiPhatDao = (LoaiPhatDao) Naming.lookup("rmi://localhost:8988/loaiPhatDao");
//			phongBanDao.getListPhongBan().forEach(e -> System.out.println(e));
//			loaiPhatDao.getListMucPhat().forEach(e->System.out.println(e.getTenLoai()));
			
			NhanVienDao nhanVienDao = (NhanVienDao) Naming.lookup("rmi://localhost:8988/nhanVienDao");
			NhanVien nhanVien = nhanVienDao.getNhanVienTheoMa(1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
