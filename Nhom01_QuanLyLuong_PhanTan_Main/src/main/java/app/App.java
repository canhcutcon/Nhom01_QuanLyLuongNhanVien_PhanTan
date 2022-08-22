package app;

import java.rmi.RemoteException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import dao.BangLuongNhanVien_DAO;
import dao.ChucVu_DAO;
import dao.NhanVien_DAO;
import dao.PhieuLuong_DAO;
import dao.PhongBan_DAO;
import daoImpl.BangLuongNhanVien_IMPL;
import daoImpl.ChucVu_IMPL;
import daoImpl.NhanVien_IMPL;
import daoImpl.PhieuLuong_IMPL;
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
		//NhanVien_DAO nhanVien_DAO = new NhanVien_IMPL();
		//PhieuLuong_DAO phieuLuong_DAO = new PhieuLuong_IMPL();
//		PhongBan_DAO phongBan_DAO = new PhongBan_IMPL(); 
		BangLuongNhanVien_DAO bangLuongNhanVien_DAO = new BangLuongNhanVien_IMPL();
		try {
//			chucVu_DAO.getListChucVU().forEach(chucVu -> System.out.println(chucVu));
			//nhanVien_DAO.getListNhanVien().forEach(nv -> System.out.println(nv));
//			nhanVien_DAO.getNhanVienTheoDanhMuc("Duy Ngoc", "","", 2).forEach(nv -> System.out.println(nv));
			//phieuLuong_DAO.getListPhieuLuong().forEach(pl -> System.out.println(pl));
			bangLuongNhanVien_DAO.getListBangLuongNhanVien().forEach(bl -> System.out.println(bl));
//			phongBan_DAO.getListPhongBan().forEach(phogban -> System.out.println(phogban));
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
