package daoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Util.HibernateUtil;
import dao.PhieuLuongDao;
import entity.PhieuLuong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PhieuLuongImpl extends UnicastRemoteObject implements PhieuLuongDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5430168135627520674L;
	private EntityManager entityManager;
	EntityTransaction entityTrans;

	public PhieuLuongImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		this.entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
	}

	@Override
	public List<PhieuLuong> getListPhieuLuong(int maNV, int thang, int nam) throws RemoteException {
		// TODO Auto-generated method stub
		List<PhieuLuong> phieuLuongs= new ArrayList<PhieuLuong>();
		List<?> lstList = entityManager.createNativeQuery("select * from bang_cham_cong cc join nhan_vien nv on cc.ma_NV = nv.ma_nv\r\n"
				+ "join phong_ban pb on nv.ma_pb = pb.ma_pb\r\n"
				+ "where (cc.ngay_cong =:x and cc.thang_cong =:z and cc.name_cong =:r and nv.ma_pb =:y)")
//				.setParameter("x", ngayCong)
//				.setParameter("z", thang)
//				.setParameter("r", nam)
//				.setParameter("y", maPB)
				.getResultList();
		return phieuLuongs;
	}

}
