package daoImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Util.HibernateUtil;

import dao.BangLuongNhanVien_DAO;
import entity.BangLuongNhanVien;
import entity.NhanVien;

public class BangLuongNhanVien_IMPL implements BangLuongNhanVien_DAO{

	private EntityManager entityManager;
	EntityTransaction entityTrans;

	public BangLuongNhanVien_IMPL() {
		super();
		// TODO Auto-generated constructor stub
		this.entityManager = HibernateUtil.getInstance().getEntityManager();
	}

	@Override
	public List<BangLuongNhanVien> getListBangLuongNhanVien() throws RemoteException {

		List<BangLuongNhanVien> lstBangLuongNhanViens = entityManager.createNativeQuery("Select * from luong_nhan_vien where trangThai = 1", BangLuongNhanVien.class)
				.getResultList();
		return lstBangLuongNhanViens;
	}


	@Override
	public BangLuongNhanVien getBangLuongNhanVienTheoMa(int id) throws RemoteException {
		entityTrans = entityManager.getTransaction();
		BangLuongNhanVien bangLuongNhanVien = null;
		try {
			entityTrans.begin();
			bangLuongNhanVien = entityManager.find(BangLuongNhanVien.class, id);
			entityTrans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entityTrans.rollback();
		}
		return bangLuongNhanVien;
	}

		
	

	@Override
	public boolean createBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) throws RemoteException {
		entityTrans = entityManager.getTransaction();
		try {
			entityTrans.begin();
			entityManager.persist(bangLuongNhanVien);
			entityTrans.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entityTrans.rollback();
		}
		return false;
	}
	
	@Override
	public boolean deleteBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) throws RemoteException {
		entityTrans = entityManager.getTransaction();
		List<BangLuongNhanVien> lstBangLuongNhanVien = entityManager.createNativeQuery("select * from luong_nhan_vien where id=:x")
				.setParameter("x", bangLuongNhanVien.getIdLuongNhanVien())
				.getResultList();
		for (BangLuongNhanVien temp : lstBangLuongNhanVien) {
			try {
				entityTrans.begin();
				temp.setTrangThai(0);
				entityManager.merge(temp);
				entityTrans.commit();
			} catch (Exception e) {
				// TODO: handle exception
				entityTrans.rollback();
				throw e;
			}
		}
		return true;
	}

	@Override
	public boolean updateBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) throws RemoteException {
		List<BangLuongNhanVien> lstBangLuongNhanVien = entityManager.createNativeQuery("select * from luong_nhan_vien where id=:x")
				.setParameter("x", bangLuongNhanVien.getIdLuongNhanVien())
				.getResultList();
		for (BangLuongNhanVien temp : lstBangLuongNhanVien) {
			try {
				entityTrans.begin();
				temp.setThue(bangLuongNhanVien.getThue());
				temp.setSoNgayLamDuoc(bangLuongNhanVien.getSoNgayLamDuoc());
				temp.setLuongCoBan(bangLuongNhanVien.getLuongCoBan());
				temp.setNgayTinhLuong(bangLuongNhanVien.getNgayTinhLuong());
				temp.setChungChi(bangLuongNhanVien.getChungChi());
				temp.setMaPhieuPhat(bangLuongNhanVien.getMaPhieuPhat());
				temp.setIdNhanVien(bangLuongNhanVien.getIdNhanVien());
				temp.setTrangThai(bangLuongNhanVien.getTrangThai());
				entityManager.merge(temp);
				entityTrans.commit();
			} catch (Exception e) {
				// TODO: handle exception
				entityTrans.rollback();
				throw e;
			}
		}
		return true;
	
	}

		
	

}
