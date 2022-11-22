package daoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
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
		List<NhanVien> lstNhanViens = (List<NhanVien>) entityManager
				.createNativeQuery("select * from nhan_vien where trang_thai = 1", NhanVien.class).getResultList();
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
		Object a = entityManager.createNativeQuery("select * from nhan_vien where ma_nv=:x").setParameter("x", id)
				.getSingleResult();
		
		Object[] rs = (Object[]) a;
		int maNV = Integer.parseInt(rs[0].toString());
		String chucVu = (String) rs[1];
		String cmnd = (String) rs[2];
		String diaChi = (String) rs[3];
		String hinhAnh = (String) rs[4];
		Boolean isAdmin = (Boolean) rs[5];
		String matKhau = (String) rs[6];
		String ngaySinh = rs[7].toString().substring(0, 10);
		String ngayVaoLam = rs[8].toString().substring(0, 10);
		String sdt = (String) rs[9];
		String ten = (String) rs[10];
		int trangThai = Integer.parseInt(rs[11].toString());
		Object maPb = rs[12];

		nhanVien = new NhanVien(maNV, ten, sdt, cmnd, diaChi, LocalDate.parse(ngayVaoLam),
				LocalDate.parse(ngaySinh), chucVu, matKhau, isAdmin, hinhAnh, trangThai,
				null);
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

	@Override
	public boolean checkLoginUser(int maNV, String makhau) throws RemoteException {
		entityTrans = entityManager.getTransaction();
		NhanVien nv = this.getNhanVienTheoMa(maNV);
		if (nv != null && nv.getMatKhau().equalsIgnoreCase(makhau))
			return true;
		else 
			return false;
	}

}
