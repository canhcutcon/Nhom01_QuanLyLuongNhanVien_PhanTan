package daoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Util.HibernateUtil;
import dao.NhanVienDao;
import entity.NhanVien;
import entity.PhongBan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class NhanVienDaoImpl extends UnicastRemoteObject implements NhanVienDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7527299525183596459L;

	private EntityManager entityManager;
	EntityTransaction entityTrans;

	public NhanVienDaoImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		this.entityManager = HibernateUtil.getInstance().getEntityManager();
	}

	@Override
	public List<NhanVien> getListNhanVien() throws RemoteException {
		// TODO Auto-generated method stub
		List<NhanVien> lstNhanViens =(List<NhanVien>)entityManager.createNativeQuery("select * from nhan_vien where trang_thai = 1", NhanVien.class).getResultList();
//				.getResultList();
//		List<NhanVien> lstNhanViens = new ArrayList<NhanVien>();
//		List<?> lst = entityManager.createNativeQuery("select * from nhan_vien where trang_thai = 1", NhanVien.class)
//				.getResultList();
//		for (Object object : lst) {
//			Object[] rs = (Object[])object;		
//			int id = Integer.parseInt(rs[0].toString());
//			String ten = (String)rs[1];
//			int trangThai = Integer.parseInt(rs[2].toString());
//			lstPhongBans.add(new PhongBan(id, ten, trangThai));
//		}
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
		List<NhanVien> lstNhanVien = entityManager.createNativeQuery("select * from nhan_vien where ma_nv=:x")
				.setParameter("x", nhanVien.getMaNV()).getResultList();
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
		List<NhanVien> lstNhanVien = entityManager.createNativeQuery("select * from nhan_vien where ma_nv=:x")
				.setParameter("x", nhanVien.getMaNV()).getResultList();
		for (NhanVien temp : lstNhanVien) {
			try {
				entityTrans.begin();
				temp.setTenNV(nhanVien.getTenNV());
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
	public List<NhanVien> getNhanVienTheoDanhMuc(String tenNV, String sdt, String cmnd, String chucVu)
			throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "select * from nhan_vien where ((hoTen like '%" + tenNV + "%') AND" + "(sdt like '%" + sdt
				+ "%') AND" + "(cmnd like '%" + cmnd + "%') AND" + "(idChucVu like '%" + chucVu
				+ "%') AND trang_thai=1)";
		List<NhanVien> lst = entityManager.createNativeQuery(sql, NhanVien.class).getResultList();
		return lst;
	}

}
