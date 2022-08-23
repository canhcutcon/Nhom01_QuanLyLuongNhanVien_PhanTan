package daoImpl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Util.HibernateUtil;
import dao.BangChamCong_DAO;
import entity.BangChamCong;

public class BangChamCong_IMPL implements BangChamCong_DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager;
	private EntityTransaction entityTrans;
	
	public BangChamCong_IMPL() {
		super();
		this.entityManager = HibernateUtil.getInstance().getEntityManager();
	}

	@Override
	public List<BangChamCong> getListChamCong() throws RemoteException {
		// TODO Auto-generated method stub
		List<BangChamCong> lstBangChamCongs = entityManager.createNativeQuery("Select * from bang_cham_cong where trangThai = 1", BangChamCong.class).getResultList();
		return lstBangChamCongs;
	}

	@Override
	public boolean createChamCong(BangChamCong bangChamCong) throws RemoteException {
		entityTrans = entityManager.getTransaction();
		try {
			entityTrans.begin();
			entityManager.persist(bangChamCong);
			entityTrans.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			entityTrans.rollback();
		}
		return false;
	}

	@Override
	public List<BangChamCong> getListChamCongTheoNgay(Date date) throws RemoteException {
		return null;
	}

	@Override
	public boolean updateChamCong(BangChamCong bangChamCong) throws RemoteException {
		entityTrans = entityManager.getTransaction();
		List<BangChamCong> lstBangChamCongs = entityManager.createNativeQuery("select * from bang_cham_cong where idBangChamCong =:x").setParameter("", bangChamCong.getIdBangChamCong()).getResultList();
		try {
			entityTrans.begin();
			for(BangChamCong temp : lstBangChamCongs) {
				temp.setNgayCong(bangChamCong.getNgayCong());
				temp.setChamCong(bangChamCong.getChamCong());
				temp.setTrangThai(bangChamCong.getTrangThai());
				entityManager.merge(temp);
				entityTrans.commit();
			}
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			entityTrans.rollback();
		}
		return false;
	}

}
