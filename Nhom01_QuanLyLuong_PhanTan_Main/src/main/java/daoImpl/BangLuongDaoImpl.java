package daoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Util.HibernateUtil;
import dao.BangLuongDao;
import entity.BangChamCong;
import entity.BangLuongNhanVien;
import entity.NhanVien;
import entity.PhongBan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@SuppressWarnings("serial")
public class BangLuongDaoImpl extends UnicastRemoteObject implements BangLuongDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7296567180198371088L;
	private EntityManager entityManager;
	EntityTransaction entityTrans;

	public BangLuongDaoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		this.entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
	}

	@Override
	public List<BangLuongNhanVien> getListBangLuongNhanVien(int maPB, int ngay, int thang, int nam)
			throws RemoteException {
		// TODO Auto-generated method stub
		List<BangLuongNhanVien> bangLuongNhanViens = new ArrayList<BangLuongNhanVien>();
		List<?> lstList = entityManager
				.createNativeQuery("select * FROM bang_luong bl join nhan_vien nv on bl.ma_nv = nv.ma_nv\r\n"
						+ "join phong_ban pb on nv.ma_pb = pb.ma_pb\r\n"
						+ "where (bl.thang =:thang and bl.nam =:nam and nv.ma_pb =:maPB)")
				.setParameter("thang", thang).setParameter("nam", nam).setParameter("maPB", maPB).getResultList();
		try {
			for (Object object : lstList) {
				Object[] rs = (Object[]) object;
				int id = Integer.parseInt(rs[0].toString());
				double luongCoBan = Double.parseDouble(rs[1].toString());
				int namTL = Integer.parseInt(rs[2].toString());
				int ngayTL = Integer.parseInt(rs[3].toString());
				double phuCap = Double.parseDouble(rs[4].toString());
				int chungChi = Integer.parseInt(rs[5].toString());
				int soNgaylam = Integer.parseInt(rs[6].toString());
				int thangTL = Integer.parseInt(rs[7].toString());
				double thue = Double.parseDouble(rs[8].toString());
				double tienPhat = Double.parseDouble(rs[9].toString());
				int trangThaiTL = Integer.parseInt(rs[10].toString());
				int maNV = Integer.parseInt(rs[11].toString());
				String chucVu = (String) rs[13];
				String cmnd = (String) rs[14];
				String diaChi = (String) rs[15];
				String hinhAnh = (String) rs[16];
				Boolean isAdmin = (Boolean) rs[17];
				String matKhau = (String) rs[18];
				String ngayVaoLam = rs[19].toString().substring(0, 10);
				String ngaySinh = rs[20].toString().substring(0, 10);
				String sdt = (String) rs[21];
				String ten = (String) rs[22];
				int trangThaiNV = Integer.parseInt(rs[23].toString());
				int maPb = Integer.parseInt(rs[24].toString());
				String namePB = (String) rs[26];
				PhongBan phongBan = new PhongBan(maPb, namePB);
				NhanVien nv = new NhanVien(maNV, ten, sdt, cmnd, diaChi, LocalDate.parse(ngayVaoLam),
						LocalDate.parse(ngaySinh), chucVu, matKhau, Boolean.parseBoolean(sdt), hinhAnh, 1, phongBan);
				BangLuongNhanVien luongNhanVien = new BangLuongNhanVien(id, thue, phuCap, ngayTL, thangTL, namTL,
						soNgaylam, luongCoBan, chungChi, 1, tienPhat, nv);
				bangLuongNhanViens.add(luongNhanVien);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bangLuongNhanViens;
	}

	@Override
	public BangLuongNhanVien getBangLuongNhanVienTheoMa(int maLuong) throws RemoteException {
		// TODO Auto-generated method stub
		BangLuongNhanVien luongNhanViens = null;
		Object obj = entityManager
				.createNativeQuery("select * FROM bang_luong bl join nhan_vien nv on bl.ma_nv = nv.ma_nv "
						+ " join phong_ban pb on nv.ma_pb = pb.ma_pb where ma_luong =:x")
				.setParameter("x", maLuong).getSingleResult();
		Object[] rs = (Object[]) obj;
		int id = Integer.parseInt(rs[0].toString());
		double luongCoBan = Double.parseDouble(rs[1].toString());
		int namTL = Integer.parseInt(rs[2].toString());
		int ngayTL = Integer.parseInt(rs[3].toString());
		double phuCap = Double.parseDouble(rs[4].toString());
		int chungChi = Integer.parseInt(rs[5].toString());
		int soNgaylam = Integer.parseInt(rs[6].toString());
		int thangTL = Integer.parseInt(rs[7].toString());
		double thue = Double.parseDouble(rs[8].toString());
		double tienPhat = Double.parseDouble(rs[9].toString());
		int trangThaiTL = Integer.parseInt(rs[10].toString());
		int maNV = Integer.parseInt(rs[11].toString());
		String chucVu = (String) rs[13];
		String cmnd = (String) rs[14];
		String diaChi = (String) rs[15];
		String hinhAnh = (String) rs[16];
		Boolean isAdmin = (Boolean) rs[17];
		String matKhau = (String) rs[18];
		String ngayVaoLam = rs[19].toString().substring(0, 10);
		String ngaySinh = rs[20].toString().substring(0, 10);
		String sdt = (String) rs[21];
		String ten = (String) rs[22];
		int trangThaiNV = Integer.parseInt(rs[23].toString());
		int maPb = Integer.parseInt(rs[24].toString());
		String namePB = (String) rs[26];
		PhongBan phongBan = new PhongBan(maPb, namePB);
		NhanVien nv = new NhanVien(maNV, ten, sdt, cmnd, diaChi, LocalDate.parse(ngayVaoLam), LocalDate.parse(ngaySinh),
				chucVu, matKhau, Boolean.parseBoolean(sdt), hinhAnh, 1, phongBan);
		luongNhanViens = new BangLuongNhanVien(id, thue, phuCap, ngayTL, thangTL, namTL, soNgaylam, luongCoBan,
				chungChi, 1, tienPhat, nv);
		return luongNhanViens;
	}

	@Override
	public boolean createBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) throws RemoteException {
		// TODO Auto-generated method stub
		entityTrans = entityManager.getTransaction();
		try {
			entityTrans.begin();
			entityManager.persist(bangLuongNhanVien);
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
	public boolean updateBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) throws RemoteException {
		// TODO Auto-generated method stub
		entityTrans = entityManager.getTransaction();
		List<BangLuongNhanVien> luongNhanViens = entityManager
				.createNativeQuery("select * FROM bang_luong bl where ma_luong=:x", BangLuongNhanVien.class)
				.setParameter("x", bangLuongNhanVien.getMaLuong()).getResultList();

		if (luongNhanViens == null)
			return false;

		for (BangLuongNhanVien temp : luongNhanViens) {
			try {
				entityTrans.begin();
				temp.setThue(bangLuongNhanVien.getThue());
				temp.setLuongCoBan(bangLuongNhanVien.getLuongCoBan());
				temp.setPhuCap(bangLuongNhanVien.getPhuCap());
				temp.setTienPhat(bangLuongNhanVien.getTienPhat());
				temp.setSoNgayLam(bangLuongNhanVien.getSoNgayLam());
				temp.setSoChungChi(bangLuongNhanVien.getSoChungChi());
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

	@Override
	public BangLuongNhanVien getBLTheoMaNV(int maNV, int thang, int nam) throws RemoteException {
		// TODO Auto-generated method stub
		BangLuongNhanVien luongNhanViens = null;
		Object obj = entityManager
				.createNativeQuery("select * FROM bang_luong bl join nhan_vien nv on bl.ma_nv = nv.ma_nv "
						+ "join phong_ban pb on nv.ma_pb = pb.ma_pb where ( nv.ma_nv =:maNV and bl.thang =:thang and bl.nam =:nam)")
				.setParameter("maNV", maNV)
				.setParameter("thang", thang)
				.setParameter("nam", nam)
				.getSingleResult();
		Object[] rs = (Object[]) obj;
		int id = Integer.parseInt(rs[0].toString());
		double luongCoBan = Double.parseDouble(rs[1].toString());
		int namTL = Integer.parseInt(rs[2].toString());
		int ngayTL = Integer.parseInt(rs[3].toString());
		double phuCap = Double.parseDouble(rs[4].toString());
		int chungChi = Integer.parseInt(rs[5].toString());
		int soNgaylam = Integer.parseInt(rs[6].toString());
		int thangTL = Integer.parseInt(rs[7].toString());
		double thue = Double.parseDouble(rs[8].toString());
		double tienPhat = Double.parseDouble(rs[9].toString());
		int trangThaiTL = Integer.parseInt(rs[10].toString());
		String chucVu = (String) rs[13];
		String cmnd = (String) rs[14];
		String diaChi = (String) rs[15];
		String hinhAnh = (String) rs[16];
		Boolean isAdmin = (Boolean) rs[17];
		String matKhau = (String) rs[18];
		String ngayVaoLam = rs[19].toString().substring(0, 10);
		String ngaySinh = rs[20].toString().substring(0, 10);
		String sdt = (String) rs[21];
		String ten = (String) rs[22];
		int trangThaiNV = Integer.parseInt(rs[23].toString());
		int maPb = Integer.parseInt(rs[24].toString());
		String namePB = (String) rs[26];
		PhongBan phongBan = new PhongBan(maPb, namePB);
		NhanVien nv = new NhanVien(maNV, ten, sdt, cmnd, diaChi, LocalDate.parse(ngayVaoLam), LocalDate.parse(ngaySinh),
				chucVu, matKhau, Boolean.parseBoolean(sdt), hinhAnh, 1, phongBan);
		luongNhanViens = new BangLuongNhanVien(id, thue, phuCap, ngayTL, thangTL, namTL, soNgaylam, luongCoBan,
				chungChi, 1, tienPhat, nv);
		return luongNhanViens;
	}

}
