package app;

import java.rmi.Naming;

import dao.PhongBanDao;
import entity.PhongBan;

public class aaaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "policy\\policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			PhongBanDao phongBanDao = (PhongBanDao) Naming.lookup("rmi://192.168.1.5:8988/phongBanDao");
			System.out.println(phongBanDao.getPhongBanTheoMa(1));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
