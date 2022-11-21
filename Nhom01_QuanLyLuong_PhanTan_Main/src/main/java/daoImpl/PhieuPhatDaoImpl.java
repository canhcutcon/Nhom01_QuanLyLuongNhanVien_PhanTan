package daoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import Util.HibernateUtil;
import dao.PhieuPhatDao;
import entity.PhieuPhat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
@SuppressWarnings("serial")
public class PhieuPhatDaoImpl extends UnicastRemoteObject implements PhieuPhatDao{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4864422418199696665L;
	EntityManager entityManager;
	EntityTransaction entityTrans;
	
	public PhieuPhatDaoImpl() throws RemoteException{
		// TODO Auto-generated constructor stub
		this.entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
	}

	@Override
	public List<PhieuPhat> getListPhieuPhat() throws RemoteException {
		// TODO Auto-generated method stub
		List<PhieuPhat> lstPhieuPhats = entityManager.createNativeQuery("Select * from phieu_phat where trang_thai = 1", PhieuPhat.class).getResultList();
		return lstPhieuPhats;
	}

	@Override
	public boolean createPhieuPhat(PhieuPhat phieuPhat) throws RemoteException {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		List<PhieuPhat> lstPhieuPhats = entityManager.createNativeQuery("select * from phieu_phat where ma_phieu_phat=:x")
				.setParameter("x", phieuPhat.getMaPhieuPhat())
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



}
