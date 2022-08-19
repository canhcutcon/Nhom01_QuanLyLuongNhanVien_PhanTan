package daoImpl;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;

import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.AliasToEntityMapResultTransformer;

import com.mysql.cj.Query;

import dao.*;
import entity.ChucVu;
import Util.*;

public class ChucVu_IMPL implements ChucVu_DAO{
	private static final long serialVersionUID = 3111304828983788972L;

	private EntityManager entityManager;
	
	public ChucVu_IMPL() {
		super();
		this.entityManager = HibernateUtil.getInstance().getEntityManager();
	}

	public List<ChucVu> getListChucVU() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<ChucVu> lstChucVu = new ArrayList<ChucVu>();
		String sql = "select * from chuc_vu";
		List<?> temp = entityManager.createNativeQuery(sql).getResultList();
		for (Object o : temp) {		
			Object[] rs = (Object[]) o;		
			int id = (int) rs[0];
			ChucVu empl = entityManager.find(ChucVu.class, id);
			lstChucVu.add(empl);		
		}
		return lstChucVu;
	}

	public ChucVu getChucVuTheoMa(int maCV) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean createChucVu(ChucVu chucVu) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteChucVu(ChucVu chucVu) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateChucVu(ChucVu chucVu) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
