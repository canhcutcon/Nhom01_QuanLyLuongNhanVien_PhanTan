package app;

import java.rmi.Naming;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import dao.BangChamCongDao;
import dao.NhanVienDao;
import dao.PhongBanDao;
import entity.BangChamCong;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager entityManager = Persistence.createEntityManagerFactory("Nhom01_QuanLyLuong_PhanTan").createEntityManager();
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "policy\\policy.policy");
//			System.setSecurityManager(new SecurityManager());
		}
		try {
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
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
