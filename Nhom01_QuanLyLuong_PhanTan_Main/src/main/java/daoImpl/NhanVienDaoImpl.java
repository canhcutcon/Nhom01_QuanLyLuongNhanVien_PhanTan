package daoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import Util.HibernateUtil;
import dao.NhanVienDao;
import entity.NhanVien;
import entity.PhongBan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@SuppressWarnings("serial")
public class NhanVienDaoImpl extends UnicastRemoteObject implements NhanVienDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3501576990434181970L;

	private EntityManager entityManager;
	EntityTransaction entityTrans;

	public NhanVienDaoImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		this.entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
	}

	@Override
	public List<NhanVien> getListNhanVien() throws RemoteException {
		// TODO Auto-generated method stub

		List<NhanVien> lstNhanViens = new ArrayList<NhanVien>();
		List<?> lstList = entityManager.createNativeQuery("select * from nhan_vien where trang_thai =:x")
				.setParameter("x", 1).getResultList();
//		lstNhanViens = (List<NhanVien>) lstList;
		try {
			for (Object object : lstList) {
				Object[] rs = (Object[]) object;
				int id = Integer.parseInt(rs[0].toString());
				String chucVu = (String) rs[1];
				String cmnd = (String) rs[2];
				String diaChi = (String) rs[3];
				String hinhAnh = (String) rs[4];
				Boolean isAdmin = (Boolean) rs[5];
				String matKhau = (String) rs[6];
				String ngayVaoLam = rs[7].toString().substring(0, 10);
				String ngaySinh = rs[8].toString().substring(0, 10);
				String sdt = (String) rs[9];
				String ten = (String) rs[10];
				int trangThai = Integer.parseInt(rs[11].toString());

				NhanVien nv = new NhanVien(id, ten, sdt, cmnd, diaChi, LocalDate.parse(ngayVaoLam),
						LocalDate.parse(ngaySinh), chucVu, matKhau, Boolean.parseBoolean(sdt), hinhAnh, trangThai,
						null);
				lstNhanViens.add(nv);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
>>>>>>> 668bbde74e97932b7795eac5d7abbb7cbab8759b
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

		String ngayVaoLam = rs[7].toString().substring(0, 10);
		String ngaySinh = rs[8].toString().substring(0, 10);
		String sdt = (String) rs[9];
		String ten = (String) rs[10];
		int trangThai = Integer.parseInt(rs[11].toString());

		nhanVien = new NhanVien(maNV, ten, sdt, cmnd, diaChi, LocalDate.parse(ngayVaoLam),
				LocalDate.parse(ngaySinh), chucVu, matKhau, Boolean.parseBoolean(sdt), hinhAnh, trangThai,
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
		List<NhanVien> lstNhanVien = entityManager
				.createNativeQuery("select * from nhan_vien where ma_nv=:x", NhanVien.class)
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
		List<NhanVien> lstNhanVien = entityManager
				.createNativeQuery("select * from nhan_vien where ma_nv=:x", NhanVien.class)
				.setParameter("x", nhanVien.getMaNV()).getResultList();
		for (NhanVien temp : lstNhanVien) {
			try {
				entityTrans.begin();
				temp.setTenNV(nhanVien.getTenNV());
				temp.setSdt(nhanVien.getSdt());
				temp.setCmnd(nhanVien.getCmnd());
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
		String sql = "select * from nhan_vien where ((ten_nv like '%" + tenNV + "%') AND" + "(sdt like '%" + sdt
				+ "%') AND" + "(cmnd like '%" + cmnd + "%') AND" + "(chuc_vu like '%" + chucVu
				+ "%') AND trang_thai=1)";
		List<NhanVien> lstNhanViens = new ArrayList<NhanVien>();
		List<?> lstList = entityManager.createNativeQuery(sql).getResultList();
		
		try {
			for (Object object : lstList) {
				Object[] rs = (Object[]) object;
				int id = Integer.parseInt(rs[0].toString());
				String chucVuNV = (String) rs[1];
				String cmndNV = (String) rs[2];
				String diaChi = (String) rs[3];
				String hinhAnh = (String) rs[4];
				Boolean isAdmin = (Boolean) rs[5];
				String matKhau = (String) rs[6];
				String ngayVaoLam = rs[7].toString().substring(0, 10);
				String ngaySinh = rs[8].toString().substring(0, 10);
				String sdtNV = (String) rs[9];
				String ten = (String) rs[10];
				int trangThai = Integer.parseInt(rs[11].toString());

				NhanVien nv = new NhanVien(id, ten, sdtNV, cmndNV, diaChi, LocalDate.parse(ngayVaoLam),
						LocalDate.parse(ngaySinh), chucVuNV, matKhau, Boolean.parseBoolean(sdt), hinhAnh, trangThai,
						null);
				lstNhanViens.add(nv);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstNhanViens;
	}

	@Override
	public List<NhanVien> getListNhanVien(String maPB) throws RemoteException {
		// TODO Auto-generated method stub
		List<NhanVien> lstNhanViens = new ArrayList<NhanVien>();
		List<?> lstList = entityManager.createNativeQuery("select * from nhan_vien where trang_thai =:x and ma_pb =:y")
				.setParameter("x", 1).setParameter("y", maPB).getResultList();
		try {
			for (Object object : lstList) {
				Object[] rs = (Object[]) object;
				int id = Integer.parseInt(rs[0].toString());
				String chucVu = (String) rs[1];
				String cmnd = (String) rs[2];
				String diaChi = (String) rs[3];
				String hinhAnh = (String) rs[4];
				Boolean isAdmin = (Boolean) rs[5];
				String matKhau = (String) rs[6];
				String ngayVaoLam = rs[7].toString().substring(0, 10);
				String ngaySinh = rs[8].toString().substring(0, 10);
				String sdt = (String) rs[9];
				String ten = (String) rs[10];
				int trangThai = Integer.parseInt(rs[11].toString());
				NhanVien nv = new NhanVien(id, ten, sdt, cmnd, diaChi, LocalDate.parse(ngayVaoLam),
						LocalDate.parse(ngaySinh), chucVu, matKhau, Boolean.parseBoolean(sdt), hinhAnh, trangThai,
						null);
				lstNhanViens.add(nv);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstNhanViens;
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
