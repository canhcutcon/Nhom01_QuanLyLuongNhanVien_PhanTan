package daoImpl;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Util.HibernateUtil;
import dao.NhanVien_DAO;
import entity.NhanVien;

public class NhanVien_IMPL implements NhanVien_DAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
		List<NhanVien> lstNhanViens = entityManager.createNativeQuery("Select * from nhan_vien where trangThai = 1", NhanVien.class)
				.getResultList();
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
				temp.setPhongBan(nhanVien.getPhongBan());
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
	public List<NhanVien> getNhanVienTheoDanhMuc(String tenNV, String sdt, String cmnd, int chucVu)
			throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "select * from nhan_vien where ((hoTen like '%"+ tenNV +"%') AND"
												+  "(sdt like '%"+ sdt +"%') AND"
												+  "(cmnd like '%"+ cmnd +"%') AND" 
												+  "(idChucVu like '%"+ chucVu +"%') AND trangThai=1)";
		List<NhanVien> lst = entityManager.createNativeQuery(sql,NhanVien.class).getResultList();
		return lst;
	}
}
