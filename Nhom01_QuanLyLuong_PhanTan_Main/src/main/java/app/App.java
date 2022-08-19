package app;

import java.rmi.RemoteException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import dao.ChucVu_DAO;
import dao.NhanVien_DAO;
import daoImpl.ChucVu_IMPL;
import daoImpl.NhanVien_IMPL;

public class App {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager entityManager = Persistence.createEntityManagerFactory("Nhom01_QuanLyLuong_PhanTan")
				.createEntityManager();

		ChucVu_DAO chucVu_DAO = new ChucVu_IMPL();
		NhanVien_DAO nhanVien_DAO = new NhanVien_IMPL();
		try {
			chucVu_DAO.getListChucVU().forEach(chucVu -> System.out.println(chucVu));
			nhanVien_DAO.getListNhanVien().forEach(nv -> System.out.println(nv));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
