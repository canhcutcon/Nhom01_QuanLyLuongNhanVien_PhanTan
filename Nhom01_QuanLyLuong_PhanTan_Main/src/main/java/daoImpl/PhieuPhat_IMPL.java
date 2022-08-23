package daoImpl;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Util.HibernateUtil;
import dao.PhieuPhat_DAO;
import entity.PhieuPhat;

public class PhieuPhat_IMPL implements PhieuPhat_DAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager;
	EntityTransaction entityTrans;
	
	

	public PhieuPhat_IMPL() {
		super();
		this.entityManager = HibernateUtil.getInstance().getEntityManager();
	}

	@Override
	public List<PhieuPhat> getListPhieuPhat() throws RemoteException {
		List<PhieuPhat> lstPhieuPhats = entityManager.createNativeQuery("Select * from phieu_phat where trangThai = 1", PhieuPhat.class).getResultList();
		return lstPhieuPhats;
	}

	@Override
	public boolean createPhieuPhat(PhieuPhat phieuPhat) throws RemoteException {
		entityTrans = entityManager.getTransaction();
		try {
			entityTrans.begin();
			entityManager.persist(phieuPhat);
			entityTrans.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			entityTrans.rollback();
		}
		return false;
	}

	@Override
	public boolean updatePhieuPhat(PhieuPhat phieuPhat) throws RemoteException {
		List<PhieuPhat> lstPhieuPhats = entityManager.createNativeQuery("select * from phieu_phat where idPhieuPhat=:x")
				.setParameter("x", phieuPhat.getIdPhieuPhat())
				.getResultList();
		try {
			entityTrans.begin();
			for(PhieuPhat temp: lstPhieuPhats) {
				temp.setTrangThai(phieuPhat.getTrangThai());
			}
			
		}catch (Exception e) {
			entityTrans.rollback();
		}
		return false;
	}

	@Override
	public boolean deletePhieuPhat(PhieuPhat phieuPhat) throws RemoteException {
		// Cái này không viết vì updatePhieuPhat() chỉ thay đổi được trạng thái
		return false;
	}

}
