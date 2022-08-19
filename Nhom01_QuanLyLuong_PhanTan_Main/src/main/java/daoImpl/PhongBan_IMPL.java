package daoImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Util.HibernateUtil;
import dao.PhongBan_DAO;
import entity.PhongBan;

public class PhongBan_IMPL implements PhongBan_DAO{

	EntityManager entityManager;
	EntityTransaction entityTrans;
	
	public PhongBan_IMPL() {
		super();
		entityManager = HibernateUtil.getInstance().getEntityManager();
	}

	@Override
	public List<PhongBan> getListPhongBan() throws RemoteException {
		// TODO Auto-generated method stub
		List<PhongBan> lstPhongBans = new ArrayList<PhongBan>();
		List<PhongBan> lstList = entityManager.createNativeQuery("select * from phong_ban where trangThai=:x")
				.setParameter("x", 1)
				.getResultList();
//		for(Object obj: lstList)
//		{
//			Object[] objects = (Object[]) obj;
//			int id = (int) objects[0];
//			PhongBan temp = entityManager.find(PhongBan.class, id);
//			lstPhongBans.add(temp);
//		}
		for (PhongBan object : lstList) {
			lstPhongBans.add(object);
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
		List<PhongBan> phongBans = entityManager.createNativeQuery("select * from phong_ban where idphong_ban=:x")
				.setParameter("x", phongBan.getIdPhongBan())
				.getResultList();
		for (PhongBan temp : phongBans) {
			try {
				entityTrans.begin();
				temp.setTenPhongBan(phongBan.getTenPhongBan());
				temp.setQuanLyPB(phongBan.getQuanLyPB());
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
		List<PhongBan> phongBans = entityManager.createNativeQuery("select * from phong_ban where idphong_ban=:x")
				.setParameter("x", phongBan.getIdPhongBan())
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
