package daoImpl;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.AliasToEntityMapResultTransformer;

import com.mysql.cj.Query;

import dao.*;
import entity.ChucVu;
import entity.NhanVien;
import Util.*;

public class ChucVu_IMPL implements ChucVu_DAO{
	private static final long serialVersionUID = 3111304828983788972L;

	private EntityManager entityManager;
	private EntityTransaction entityTrans;
	public ChucVu_IMPL() {
		super();
		this.entityManager = HibernateUtil.getInstance().getEntityManager();
	}

	public List<ChucVu> getListChucVU() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<ChucVu> lstChucVu = new ArrayList<ChucVu>();
		List<ChucVu> chucVus = entityManager.createNativeQuery("select * from chuc_vu where "
				+ "trangThai=:x", ChucVu.class)
				.setParameter("x",1)
				.getResultList();
		for (ChucVu temp : chucVus) {
			lstChucVu.add(temp);
		}
		return lstChucVu;
	}

	public ChucVu getChucVuTheoMa(int maCV) throws RemoteException {
		// TODO Auto-generated method stub
		ChucVu chucVu = null;
		entityTrans = entityManager.getTransaction();
		
		try {
			entityTrans.begin();
			chucVu = entityManager.find(ChucVu.class, maCV);
			entityTrans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entityTrans.rollback();
		}
		return chucVu;
	}

	public boolean createChucVu(ChucVu chucVu) throws RemoteException {
		// TODO Auto-generated method stub
		entityTrans = entityManager.getTransaction();
		try {
			entityTrans.begin();
			entityManager.persist(chucVu);
			entityTrans.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entityTrans.rollback();
		}
		return false;
	}

	public boolean deleteChucVu(ChucVu chucVu) throws RemoteException {
		// TODO Auto-generated method stub
		
		entityTrans = entityManager.getTransaction();
		List<ChucVu> chucVus = entityManager.createNativeQuery("select * from chuc_vu where "
				+ "idChucVu=:x", ChucVu.class)
				.setParameter("x", chucVu.getId())
				.getResultList();
		for (ChucVu temp : chucVus) {
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

	public boolean updateChucVu(ChucVu chucVu) throws RemoteException {
		// TODO Auto-generated method stub
		entityTrans = entityManager.getTransaction();
		List<ChucVu> chucVus = entityManager.createNativeQuery("select * from chuc_vu where "
				+ "idChucVu=:x", ChucVu.class)
				.setParameter("x", chucVu.getId())
				.getResultList();
		for (ChucVu temp : chucVus) {
			try {
				entityTrans.begin();
				temp.setChucVu(chucVu.getChucVu());
				temp.setTrangThai(chucVu.getTrangThai());
				entityManager.merge(temp);
				entityTrans.commit();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				entityTrans.rollback();
				throw e;
			}
		}
		return false;
	}

}
