package daoImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import Util.HibernateUtil;
import dao.NhanVien_DAO;
import entity.ChucVu;
import entity.NhanVien;

public class NhanVien_IMPL implements NhanVien_DAO{

	private EntityManager entityManager;
	
	
	public NhanVien_IMPL() {
		super();
		// TODO Auto-generated constructor stub
		this.entityManager = HibernateUtil.getInstance().getEntityManager();
	}

	@Override
	public List<NhanVien> getListNhanVien() throws RemoteException {
		// TODO Auto-generated method stub
		List<NhanVien> lstNhanViens = new ArrayList<NhanVien>();
		String sql = "select * from nhan_vien";
		List<?> temp = entityManager.createNativeQuery(sql).getResultList();
		for (Object o : temp) {		
			Object[] rs = (Object[]) o;		
			int id = (int) rs[0];
			NhanVien empl = entityManager.find(NhanVien.class, id);
			lstNhanViens.add(empl);
			System.out.println(empl.toString());
		}
		return lstNhanViens;
	}

	@Override
	public NhanVien getNhanVienTheoMa(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createNhanVien(NhanVien nhanVien) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteNhanVien(NhanVien nhanVien) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateNhanVien(NhanVien nhanVien) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}
