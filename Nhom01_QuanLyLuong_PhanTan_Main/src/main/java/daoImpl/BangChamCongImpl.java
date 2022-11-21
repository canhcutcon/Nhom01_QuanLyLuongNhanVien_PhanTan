package daoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Util.HibernateUtil;
import dao.BangChamCongDao;
import entity.BangChamCong;
import entity.NhanVien;
import entity.PhongBan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
@SuppressWarnings("serial")
public class BangChamCongImpl extends UnicastRemoteObject implements BangChamCongDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5495703951755090109L;
	private EntityManager entityManager;
	EntityTransaction entityTrans;

	public BangChamCongImpl() throws RemoteException{
		// TODO Auto-generated constructor stub
		this.entityManager = HibernateUtil.getInstance().getEntityManagerFactory().createEntityManager();
	}

	@Override
	public List<BangChamCong> getListChamCong(int ngayCong,int thang, int nam,int maPB) throws RemoteException {
		// TODO Auto-generated method stub
		List<BangChamCong> bangChamCongs = new ArrayList<BangChamCong>();
		List<?> lstList = entityManager.createNativeQuery("select * from bang_cham_cong cc join nhan_vien nv on cc.ma_NV = nv.ma_nv\r\n"
				+ "join phong_ban pb on nv.ma_pb = pb.ma_pb\r\n"
				+ "where (cc.ngay_cong =:x and cc.thang_cong =:z and cc.name_cong =:r and nv.ma_pb =:y)")
				.setParameter("x", ngayCong)
				.setParameter("z", thang)
				.setParameter("r", nam)
				.setParameter("y", maPB)
				.getResultList();
		try {
			for (Object object : lstList) {
				Object[] rs = (Object[]) object;
				int id = Integer.parseInt(rs[0].toString());
				Boolean diLam = (Boolean) rs[1];
				Boolean diTre = (Boolean) rs[2];
				int ngCong = Integer.parseInt(rs[3].toString());
				int trangThai = Integer.parseInt(rs[4].toString());
				int maNV = Integer.parseInt(rs[5].toString());
				int namCong = Integer.parseInt(rs[6].toString());
				int thangCong = Integer.parseInt(rs[7].toString());
				String chucVu = (String) rs[9];
				String cmnd = (String) rs[10];
				String diaChi = (String) rs[11];
				String hinhAnh = (String) rs[12];
				Boolean isAdmin = (Boolean) rs[13];
				String matKhau = (String) rs[14];
				String ngayVaoLam = rs[15].toString().substring(0, 10);
				String ngaySinh = rs[16].toString().substring(0, 10);
				String sdt = (String) rs[17];
				String ten = (String) rs[18];
				int trangThaiNV = Integer.parseInt(rs[19].toString());
				int maPb = Integer.parseInt(rs[20].toString());
				String namePB = (String)rs[22];
				PhongBan phongBan = new PhongBan(maPb, namePB);
				NhanVien nv = new NhanVien(maNV, ten, sdt, cmnd, diaChi, LocalDate.parse(ngayVaoLam),
						LocalDate.parse(ngaySinh), chucVu, matKhau, Boolean.parseBoolean(sdt), hinhAnh, trangThai,
						phongBan);
				BangChamCong bangChamCong = new BangChamCong(id,ngayCong, thangCong, namCong, diLam, diTre, trangThaiNV,nv);
				bangChamCongs.add(bangChamCong);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bangChamCongs;
	}

	@Override
	public boolean createChamCong(BangChamCong bangChamCong) throws RemoteException {
		// TODO Auto-generated method stub
		entityTrans = entityManager.getTransaction();
		try {
			entityTrans.begin();
			entityManager.persist(bangChamCong);
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
	public List<BangChamCong> getListChamCongTheoNgay(Date date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateChamCong(BangChamCong bangChamCong) throws RemoteException {
		// TODO Auto-generated method stub
		entityTrans = entityManager.getTransaction();
		List<BangChamCong> bangChamCongs = entityManager
				.createNativeQuery("select * from bang_cham_cong where ma_cc=:x",BangChamCong.class)
				.setParameter("x", bangChamCong.getMaChamCong())
				.getResultList();
		
		if(bangChamCongs == null)
			return false;
		
		for(BangChamCong temp: bangChamCongs)
		{
			try {
				entityTrans.begin();
				temp.setDiLam(bangChamCong.isDiLam());
				temp.setDiTre(bangChamCong.isDiTre());
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
	public BangChamCong getBangChamCongById(int maCC) throws RemoteException {
		// TODO Auto-generated method stub
		BangChamCong bangChamCong = null;
		Object obj = entityManager.createNativeQuery("select * from bang_cham_cong cc join nhan_vien nv on cc.ma_NV = nv.ma_nv\r\n"
				+ "join phong_ban pb on nv.ma_pb = pb.ma_pb\r\n"
				+ "where ma_cc =:x")
				.setParameter("x", maCC)
				.getSingleResult();
		Object[] rs = (Object[]) obj;
		int id = Integer.parseInt(rs[0].toString());
		Boolean diLam = (Boolean) rs[1];
		Boolean diTre = (Boolean) rs[2];
		int ngCong = Integer.parseInt(rs[3].toString());
		int trangThai = Integer.parseInt(rs[4].toString());
		int maNV = Integer.parseInt(rs[5].toString());
		int namCong = Integer.parseInt(rs[6].toString());
		int thangCong = Integer.parseInt(rs[7].toString());
		String chucVu = (String) rs[9];
		String cmnd = (String) rs[10];
		String diaChi = (String) rs[11];
		String hinhAnh = (String) rs[12];
		Boolean isAdmin = (Boolean) rs[13];
		String matKhau = (String) rs[14];
		String ngayVaoLam = rs[15].toString().substring(0, 10);
		String ngaySinh = rs[16].toString().substring(0, 10);
		String sdt = (String) rs[17];
		String ten = (String) rs[18];
		int trangThaiNV = Integer.parseInt(rs[19].toString());
		int maPb = Integer.parseInt(rs[20].toString());
		String namePB = (String)rs[22];
		PhongBan phongBan = new PhongBan(maPb, namePB);
		NhanVien nv = new NhanVien(maNV, ten, sdt, cmnd, diaChi, LocalDate.parse(ngayVaoLam),
				LocalDate.parse(ngaySinh), chucVu, matKhau, Boolean.parseBoolean(sdt), hinhAnh, trangThai,
				phongBan);
		bangChamCong = new BangChamCong(id,ngCong, thangCong, namCong, diLam, diTre, trangThaiNV,nv);
		return bangChamCong;
	}

	@Override
	public int getSoNgayCong(int thang,int nam, int maPB, int maNV) throws RemoteException {
		// TODO Auto-generated method stub
		Object obj = entityManager.createNativeQuery("select count(*) from bang_cham_cong cc join nhan_vien nv on cc.ma_NV = nv.ma_nv\r\n"
				+ "join phong_ban pb on nv.ma_pb = pb.ma_pb\r\n"
				+ "where (cc.thang_cong =:thang and cc.name_cong =:nam and nv.ma_NV =:maNV and nv.ma_pb =:maPb and cc.di_lam = 1)")
				.setParameter("thang", thang)
				.setParameter("nam",nam)
				.setParameter("maNV", maNV)
				.setParameter("maPb", maPB)
				.getSingleResult();
		int count = Integer.parseInt(obj.toString());
		return count;
	}

	@Override
	public int getSoNgayDiTre(int thang, int nam, int maPB, int maNV) throws RemoteException {
		// TODO Auto-generated method stub
		Object obj = entityManager.createNativeQuery("select count(*) from bang_cham_cong cc join nhan_vien nv on cc.ma_NV = nv.ma_nv\r\n"
				+ "join phong_ban pb on nv.ma_pb = pb.ma_pb\r\n"
				+ "where (cc.thang_cong =:thang and cc.name_cong =:nam and nv.ma_NV =:maNV and nv.ma_pb =:maPb and cc.di_lam = 1 and di_tre = 1)")
				.setParameter("thang", thang)
				.setParameter("nam",nam)
				.setParameter("maNV", maNV)
				.setParameter("maPb", maPB)
				.getSingleResult();
		int count = Integer.parseInt(obj.toString());
		return count;
	}

}
