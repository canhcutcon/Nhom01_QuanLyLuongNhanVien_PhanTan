package app;

import java.rmi.RemoteException;
import java.time.LocalDate;

import dao.NhanVienDao;
import dao.PhongBanDao;
import daoImpl.NhanVienDaoImpl;
import daoImpl.PhongBanDaoImpl;
import entity.NhanVien;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhongBanDao phongBanDao = new PhongBanDaoImpl();
		
		try {
			phongBanDao.getListPhongBan().forEach(pb -> System.out.println(pb));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		NhanVienDao nvDao = new NhanVienDaoImpl();
//		
//		nvDao.createNhanVien(new NhanVien("Giang Vo", "0123456789", "0123456789", "NguyenVanBao", LocalDate.now(), LocalDate.of(2001, 03, 02), "Quan ly","123456", true, null,1, ));
	}

}
