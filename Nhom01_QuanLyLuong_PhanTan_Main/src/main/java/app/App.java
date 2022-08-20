package app;

import java.rmi.RemoteException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import dao.ChucVu_DAO;
import dao.NhanVien_DAO;
import dao.PhongBan_DAO;
import daoImpl.ChucVu_IMPL;
import daoImpl.NhanVien_IMPL;
import daoImpl.PhongBan_IMPL;
import entity.ChucVu;

public class App {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager entityManager = Persistence.createEntityManagerFactory("Nhom01_QuanLyLuong_PhanTan")
				.createEntityManager();

//		ChucVu_DAO chucVu_DAO = new ChucVu_IMPL();
//		ChucVu cVu = new ChucVu(3,"EmployeeManagerment", 1);
//
//		try {
//			chucVu_DAO.updateChucVu(cVu);
//		} catch (RemoteException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		NhanVien_DAO nhanVien_DAO = new NhanVien_IMPL();
//		PhongBan_DAO phongBan_DAO = new PhongBan_IMPL(); 
		try {
//			chucVu_DAO.getListChucVU().forEach(chucVu -> System.out.println(chucVu));
			nhanVien_DAO.getListNhanVien().forEach(nv -> System.out.println(nv));
//			nhanVien_DAO.getNhanVienTheoDanhMuc("Duy", "","", 2).forEach(nv -> System.out.println(nv));
			
//			phongBan_DAO.getListPhongBan().forEach(phogban -> System.out.println(phogban));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
