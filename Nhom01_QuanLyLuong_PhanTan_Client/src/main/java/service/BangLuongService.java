package service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import dao.BangLuongDao;
import entity.BangLuongNhanVien;

public class BangLuongService {
	BangLuongDao bangLuongDao;

	public BangLuongService(String host, String port) {
		// TODO Auto-generated constructor stub
		String url = "rmi://" + host + ":" + port + "/bangLuongDao";
		System.out.println(url);
		try {
			bangLuongDao = (BangLuongDao) Naming.lookup(url);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<BangLuongNhanVien> getListBangLuongNhanVien(int maPB, int ngay, int thang, int nam)
			throws RemoteException {
		return bangLuongDao.getListBangLuongNhanVien(maPB, ngay, thang, nam);
	}

	public BangLuongNhanVien getBangLuongNhanVienTheoMa(int id) throws RemoteException {
		return bangLuongDao.getBangLuongNhanVienTheoMa(id);
	}

	public boolean createBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) throws RemoteException {
		return bangLuongDao.createBangLuongNhanVien(bangLuongNhanVien);
	}

	public boolean updateBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) throws RemoteException {
		return bangLuongDao.updateBangLuongNhanVien(bangLuongNhanVien);
	}
	
	public BangLuongNhanVien getBLTheoMaNV(int maNV, int thang , int nam) throws RemoteException{
		return bangLuongDao.getBLTheoMaNV(maNV, thang, nam);
	}

}
