package app;

import java.rmi.Naming;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import dao.NhanVienDao;
import dao.PhongBanDao;

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
//			nhanVienDao.getListNhanVien().forEach(e -> System.out.println(e));
//			nhanVienDao.getNhanVienTheoMa(1);
			System.out.println(nhanVienDao.getNhanVienTheoMa(11));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
