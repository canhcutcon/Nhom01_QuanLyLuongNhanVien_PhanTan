package daoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Util.HibernateUtil;
import dao.NhanVienDao;
import dao.PhieuPhatDao;
import entity.LoaiPhat;
import entity.NhanVien;
import entity.PhieuPhat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PhieuPhatDaoImpl extends UnicastRemoteObject implements PhieuPhatDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 211070984887927662L;
	EntityManager entityManager;
	EntityTransaction entityTrans;
	
	public PhieuPhatDaoImpl() throws RemoteException{
		// TODO Auto-generated constructor stub
		this.entityManager = HibernateUtil.getInstance().getEntityManager();
	}

	@Override
	public List<PhieuPhat> getListPhieuPhat() throws RemoteException {
			
		// TODO Auto-generated method stub
				List<PhieuPhat> lstPhieuPhats = new ArrayList<PhieuPhat>();
				List<?> lstList = entityManager.createNativeQuery("select * from phieu_phat pp join nhan_vien nv on pp.ma_nv = nv.ma_nv\r\n"
						+ "join muc_tien_phat lp on pp.ma_muc_phat = lp.id\r\n"
						+ "where pp.trang_thai=1")
						.getResultList();

				try {
					for (Object object : lstList) {
						Object[] rs = (Object[]) object;
						int id = Integer.parseInt(rs[0].toString());
						LocalDate ngayPhat = LocalDate.parse(rs[1].toString().substring(0, 10)) ;
						int trangThai = Integer.parseInt(rs[2].toString());
						int maMucPhat = Integer.parseInt(rs[3].toString());
						int maNhanVien = Integer.parseInt(rs[4].toString());
						String chucVu = (String) rs[6];
						String cmnd = (String) rs[7];
						String diaChi = (String) rs[8];
						String hinhAnh = (String) rs[9];
						Boolean isAdmin = (Boolean) rs[10];
						String matKhau = (String) rs[11];
						String ngayVaoLam = rs[12].toString().substring(0, 10);
						String ngaySinh = rs[13].toString().substring(0, 10);
						String sdt = (String) rs[14];
						String ten = (String) rs[15];
						int trangThaiNV = Integer.parseInt(rs[16].toString());
						
						int maPb = Integer.parseInt(rs[17].toString());
						int maLp = Integer.parseInt(rs[18].toString());
						String nameLP = (String)rs[19];
						Double tienPhat = Double.parseDouble(rs[20].toString());
						int trangThaiLp = Integer.parseInt(rs[21].toString());
						NhanVien nv = new NhanVien(maNhanVien, ten, sdt, cmnd, diaChi, LocalDate.parse(ngayVaoLam),
								LocalDate.parse(ngaySinh), chucVu, matKhau, Boolean.parseBoolean(sdt), hinhAnh, trangThaiNV,
								null);
						LoaiPhat loaiPhat = new LoaiPhat(id,nameLP,tienPhat,trangThaiLp);
		
						lstPhieuPhats.add(new PhieuPhat(id, nv , ngayPhat,trangThai, loaiPhat));

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return lstPhieuPhats;
				
	}

	@Override
	public boolean createPhieuPhat(PhieuPhat phieuPhat) throws RemoteException {
		// TODO Auto-generated method stub
		entityTrans = entityManager.getTransaction();
		try {
			entityTrans.begin();
			entityManager.persist(phieuPhat);
			entityTrans.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			entityTrans.rollback();
		}
		return false;
	}

	@Override
	public boolean updatePhieuPhat(PhieuPhat phieuPhat) throws RemoteException {
		// TODO Auto-generated method stub
		List<PhieuPhat> lstPhieuPhats = entityManager.createNativeQuery("select * from phieu_phat where ma_phieu_phat=:x")
				.setParameter("x", phieuPhat.getMaPhieuPhat())
				.getResultList();
		try {
			entityTrans.begin();
			for(PhieuPhat temp: lstPhieuPhats) {
				temp.setTrangThai(phieuPhat.getTrangThai());
			}
			
		}catch (Exception e) {
			entityTrans.rollback();
		}
		return false;
	}



}
