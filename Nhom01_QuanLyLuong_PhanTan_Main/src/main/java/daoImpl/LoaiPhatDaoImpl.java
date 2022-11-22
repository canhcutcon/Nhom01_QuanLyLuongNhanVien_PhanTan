package daoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Util.HibernateUtil;
import dao.LoaiPhatDao;
import entity.LoaiPhat;
import entity.PhongBan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LoaiPhatDaoImpl extends UnicastRemoteObject implements LoaiPhatDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4833322125228667375L;
	EntityManager entityManager;
	EntityTransaction entityTrans;

	public LoaiPhatDaoImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		this.entityManager = HibernateUtil.getInstance().getEntityManager();
	}

	@Override
	public List<LoaiPhat> getListMucPhat() throws RemoteException {
		// TODO Auto-generated method stub
		List<LoaiPhat> lstMucPhats = new ArrayList<LoaiPhat>();
		List<?> lstLists = entityManager.createNativeQuery("SELECT * FROM muc_tien_phat where trang_thai=1")
				.getResultList();
		for (Object object : lstLists) {
			Object[] rs = (Object[]) object;
			int id = Integer.parseInt(rs[0].toString());
			String tenMucPhat = rs[1].toString();
			Double tienPhat = Double.parseDouble(rs[2].toString());
			int trangThai = Integer.parseInt(rs[3].toString());
			lstMucPhats.add(new LoaiPhat(id, tenMucPhat, tienPhat, trangThai));
		}
		return lstMucPhats;
	}

	@Override
	public boolean createMucPhat(LoaiPhat mucPhat) throws RemoteException {
		// TODO Auto-generated method stub
		entityTrans = entityManager.getTransaction();
		try {
			entityTrans.begin();
			entityManager.persist(mucPhat);
			entityTrans.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityTrans.rollback();
		}
		return false;
	}

	@Override
	public boolean updateMucPhat(LoaiPhat loaiPhat) throws RemoteException {
		// TODO Auto-generated method stub
		LoaiPhat lp = this.getLoaiPhatTheoMa(loaiPhat.getMaLoaiPhat());
		lp.setTenLoai(loaiPhat.getTenLoai());
		lp.setTienPhat(loaiPhat.getTienPhat());
		try {
			entityTrans.begin();
			entityManager.persist(lp);
			entityTrans.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entityTrans.rollback();
		}

		return false;
	}
	public LoaiPhat getLoaiPhatTheoMa(int id) throws RemoteException {
		// TODO Auto-generated method stub
		LoaiPhat loaiPhat = null;
		entityTrans = entityManager.getTransaction();
		try {
			entityTrans.begin();
			loaiPhat = entityManager.find(LoaiPhat.class, id);
			entityTrans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entityTrans.rollback();
		}
		return loaiPhat;
	}

	@Override
	public boolean deleteMucPhat(LoaiPhat mucPhat) throws RemoteException {
		// TODO Auto-generated method stub
		entityTrans = entityManager.getTransaction();
		LoaiPhat lp = this.getLoaiPhatTheoMa(mucPhat.getMaLoaiPhat());
		lp.setTrangThai(0);
		try {
			entityTrans.begin();
			entityManager.persist(lp);
			entityTrans.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entityTrans.rollback();
		}	
		return true;
		
	}

}
