package app;

import java.rmi.Naming;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

<<<<<<< HEAD
import dao.LoaiPhatDao;
import dao.NhanVienDao;
import dao.PhongBanDao;
import entity.NhanVien;
=======
import dao.BangChamCongDao;
import dao.NhanVienDao;
import dao.PhongBanDao;
import entity.BangChamCong;
>>>>>>> 668bbde74e97932b7795eac5d7abbb7cbab8759b

public class Test {

	public static void main(String[] args) {
		
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy", "policy\\policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		// TODO Auto-generated method stub
		EntityManager entityManager = Persistence.createEntityManagerFactory("Nhom01_QuanLyLuong_PhanTan").createEntityManager();
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "policy\\policy.policy");
//			System.setSecurityManager(new SecurityManager());
		}
		try {
<<<<<<< HEAD
//			PhongBanDao phongBanDao = (PhongBanDao)Naming.lookup("rmi://LAPTOP-27HK0FFM:8988/phongBanDao");
//			LoaiPhatDao loaiPhatDao = (LoaiPhatDao) Naming.lookup("rmi://localhost:8988/loaiPhatDao");
//			phongBanDao.getListPhongBan().forEach(e -> System.out.println(e));
//			loaiPhatDao.getListMucPhat().forEach(e->System.out.println(e.getTenLoai()));
			
			NhanVienDao nhanVienDao = (NhanVienDao) Naming.lookup("rmi://localhost:8988/nhanVienDao");
			NhanVien nhanVien = nhanVienDao.getNhanVienTheoMa(1);
=======
			PhongBanDao phongBanDao = (PhongBanDao)Naming.lookup("rmi://localhost:8988/phongBanDao");
			phongBanDao.getListPhongBan().forEach(e -> System.out.println(e));
			NhanVienDao nhanVienDao = (NhanVienDao)Naming.lookup("rmi://localhost:8988/nhanVienDao");
			BangChamCongDao bangChamCongDao = (BangChamCongDao)Naming.lookup("rmi://localhost:8988/bangChamCongDao");
//			nhanVienDao.getListNhanVien().forEach(e -> System.out.println(e));
//			nhanVienDao.getNhanVienTheoMa(1);
//			System.out.println(nhanVienDao.getNhanVienTheoMa(11));
			BangChamCong bangChamCong = bangChamCongDao.getBangChamCongById(1);
			System.out.println(bangChamCong);
			bangChamCong.setDiTre(true);
			bangChamCongDao.updateChamCong(bangChamCong);
//			bangChamCongDao.getListChamCong(1, 11, 2022, 1).forEach(e -> System.out.println(e));
>>>>>>> 668bbde74e97932b7795eac5d7abbb7cbab8759b
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
