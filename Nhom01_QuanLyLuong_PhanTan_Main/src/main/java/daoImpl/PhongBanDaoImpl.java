package daoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Util.HibernateUtil;
import dao.PhongBanDao;
import entity.PhongBan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PhongBanDaoImpl extends UnicastRemoteObject implements PhongBanDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7887358672797562188L;
	EntityManager entityManager;
	EntityTransaction entityTrans;

	public PhongBanDaoImpl() throws RemoteException{
		// TODO Auto-generated constructor stub
		entityManager = HibernateUtil.getInstance().getEntityManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PhongBan> getListPhongBan() throws RemoteException {
		// TODO Auto-generated method stub
		List<PhongBan> lstPhongBans = new ArrayList<PhongBan>();
		List<?> lstList = entityManager.createNativeQuery("select * from phong_ban where trang_thai =:x")
				.setParameter("x", 1)
				.getResultList();
		
		for (Object object : lstList) {
			Object[] rs = (Object[])object;		
			System.out.println(rs[0] + " " + rs[1] + " " + rs[2]);
			int id = Integer.parseInt(rs[0].toString());
			String ten = (String)rs[1];
			int trangThai = Integer.parseInt(rs[2].toString());
			lstPhongBans.add(new PhongBan(id, ten, trangThai));
		}
		return lstPhongBans;
	}

	@Override
	public PhongBan getPhongBanTheoMa(int id) throws RemoteException {
		// TODO Auto-generated method stub
		PhongBan phongBan = null;
		entityTrans = entityManager.getTransaction();
		try {
			entityTrans.begin();
			phongBan = entityManager.find(PhongBan.class, id);
			entityTrans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entityTrans.rollback();
		}
		return phongBan;
	}

	@Override
	public boolean createPhongBan(PhongBan phongBan) throws RemoteException {
		// TODO Auto-generated method stub
		entityTrans = entityManager.getTransaction();
		try {
			entityTrans.begin();
			entityManager.persist(phongBan);
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
	public boolean updatePhongBan(PhongBan phongBan) throws RemoteException {
		// TODO Auto-generated method stub
		entityTrans = entityManager.getTransaction();
		List<PhongBan> phongBans = entityManager.createNativeQuery("select * from phong_ban where ma_pb=:x")
				.setParameter("x", phongBan.getMaPB())
				.getResultList();
		for (PhongBan temp : phongBans) {
			try {
				entityTrans.begin();
				temp.setTenPB(phongBan.getTenPB());
				temp.setTrangThai(phongBan.getTrangThai());
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
	public boolean deletePhongBan(PhongBan phongBan) throws RemoteException {
		// TODO Auto-generated method stub
		entityTrans = entityManager.getTransaction();
		List<PhongBan> phongBans = entityManager.createNativeQuery("select * from phong_ban where ma_pb=:x")
				.setParameter("x", phongBan.getMaPB())
				.getResultList();
		for (PhongBan temp : phongBans) {
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

}
