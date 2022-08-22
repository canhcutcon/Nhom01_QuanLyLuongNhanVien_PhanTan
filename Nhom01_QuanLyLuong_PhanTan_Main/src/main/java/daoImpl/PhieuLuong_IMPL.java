package daoImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Util.HibernateUtil;

import dao.PhieuLuong_DAO;
import entity.PhieuLuong;

import entity.NhanVien;

public class PhieuLuong_IMPL implements PhieuLuong_DAO{

	private EntityManager entityManager;
	EntityTransaction entityTrans;

	public PhieuLuong_IMPL() {
		super();
		// TODO Auto-generated constructor stub
		this.entityManager = HibernateUtil.getInstance().getEntityManager();
	}

	@Override
	public List<PhieuLuong> getListPhieuLuong() throws RemoteException {

		List<PhieuLuong> lstPhieuLuongs = entityManager.createNativeQuery("Select * from phieu_luong where trangThai = 1", PhieuLuong.class)
				.getResultList();
		return lstPhieuLuongs;
	}
	
	@Override
	public PhieuLuong getPhieuLuongTheoMa(int id) throws RemoteException {
		entityTrans = entityManager.getTransaction();
		PhieuLuong phieuLuong = null;
		try {
			entityTrans.begin();
			phieuLuong = entityManager.find(PhieuLuong.class, id);
			entityTrans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entityTrans.rollback();
		}
		return phieuLuong;
	}


	@Override
	public boolean createPhieuLuong(PhieuLuong phieuLuong) throws RemoteException {
		entityTrans = entityManager.getTransaction();
		try {
			entityTrans.begin();
			entityManager.persist(phieuLuong);
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
	public boolean deletePhieuLuong(PhieuLuong phieuLuong) throws RemoteException {
		entityTrans = entityManager.getTransaction();
		List<PhieuLuong> lstPhieuLuong = entityManager.createNativeQuery("select * from phieu_luong where id=:x")
				.setParameter("x", phieuLuong.getIdphieuLuong())
				.getResultList();
		for (PhieuLuong temp : lstPhieuLuong) {
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
	public boolean updatePhieuLuong(PhieuLuong phieuLuong) throws RemoteException {
		List<PhieuLuong> lstPhieuLuong = entityManager.createNativeQuery("select * from phieu_luong where id=:x")
				.setParameter("x", phieuLuong.getIdphieuLuong())
				.getResultList();
		for (PhieuLuong temp : lstPhieuLuong) {
			try {
				entityTrans.begin();
				temp.setIdNhanVien(phieuLuong.getIdNhanVien());
				temp.setNgayNhan(phieuLuong.getNgayNhan());
				temp.setTongLuongThucNhan(phieuLuong.getTongLuongThucNhan());
				temp.setTrangThai(phieuLuong.getTrangThai());
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

