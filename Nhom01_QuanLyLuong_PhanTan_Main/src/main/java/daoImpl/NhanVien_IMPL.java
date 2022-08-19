package daoImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Util.HibernateUtil;
import dao.NhanVien_DAO;
import entity.ChucVu;
import entity.NhanVien;

public class NhanVien_IMPL implements NhanVien_DAO{

	private EntityManager entityManager;
	EntityTransaction entityTrans;
	
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
		entityTrans = entityManager.getTransaction();
		NhanVien nhanVien = null;
		try {
			entityTrans.begin();
			nhanVien = entityManager.find(NhanVien.class, id);
			entityTrans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entityTrans.rollback();
		}
		return nhanVien;
	}

	@Override
	public boolean createNhanVien(NhanVien nhanVien) throws RemoteException {
		// TODO Auto-generated method stub
		entityTrans = entityManager.getTransaction();
		try {
			entityTrans.begin();
			entityManager.persist(nhanVien);
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
	public boolean deleteNhanVien(NhanVien nhanVien) throws RemoteException {
		// TODO Auto-generated method stub
		entityTrans = entityManager.getTransaction();
		List<NhanVien> lstNhanVien = entityManager.createNativeQuery("select * from nhan_vien where id=:x")
				.setParameter("x", nhanVien.getId())
				.getResultList();
		for (NhanVien temp : lstNhanVien) {
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

	@Override
	public boolean updateNhanVien(NhanVien nhanVien) throws RemoteException {
		// TODO Auto-generated method stub
		entityTrans = entityManager.getTransaction();
		List<NhanVien> lstNhanVien = entityManager.createNativeQuery("select * from nhan_vien where id=:x")
				.setParameter("x", nhanVien.getId())
				.getResultList();
		for (NhanVien temp : lstNhanVien) {
			try {
				entityTrans.begin();
				temp.setHoTen(nhanVien.getHoTen());
				temp.setSdt(nhanVien.getSdt());
				temp.setCmnd(nhanVien.getCmnd());
				temp.setDiaChi(nhanVien.getDiaChi());
				temp.setNgayVaoLam(nhanVien.getNgayVaoLam());
				temp.setNgaySinh(nhanVien.getNgaySinh());
				temp.setChucVu(nhanVien.getChucVu());
				temp.setMatKhau(nhanVien.getMatKhau());
				temp.setHinhAnh(nhanVien.getHinhAnh());
				temp.setTrangThai(nhanVien.getTrangThai());
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
	public List<NhanVien> getNhanVienTheoDanhMuc(int maNV, String tenNV, String sdt, String cmnd, int chucVu)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
