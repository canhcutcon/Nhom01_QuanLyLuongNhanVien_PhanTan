package daoImpl;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Util.HibernateUtil;
import dao.MucPhat_DAO;
import entity.MucPhat;

public class MucPhat_IMPL implements MucPhat_DAO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager;
	EntityTransaction entityTrans;
	
	public MucPhat_IMPL() {
		super();
		this.entityManager = HibernateUtil.getInstance().getEntityManager();
	}

	@Override
	public List<MucPhat> getListMucPhat() throws RemoteException {
		List<MucPhat> lstMucPhats = entityManager.createQuery("select * from muc_tien_phat where trangThai=1", MucPhat.class).getResultList();
		return lstMucPhats;
	}

	@Override
	public boolean createMucPhat(MucPhat mucPhat) throws RemoteException {
		entityTrans = entityManager.getTransaction();
		try {
			entityTrans.begin();
			entityManager.persist(mucPhat);
			entityTrans.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			entityTrans.rollback();
		}
		return false;
	}

	@Override
	public boolean updateMucPhat(MucPhat mucPhat) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMucPhat(MucPhat mucPhat) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}
