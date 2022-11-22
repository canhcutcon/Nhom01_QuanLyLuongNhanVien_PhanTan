package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.BangLuongNhanVien;

public interface BangLuongDao extends Remote {

	public List<BangLuongNhanVien> getListBangLuongNhanVien(int maPB,int ngay, int thang, int nam) throws RemoteException;

	public BangLuongNhanVien getBangLuongNhanVienTheoMa(int id) throws RemoteException;

	public boolean createBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) throws RemoteException;

	public boolean updateBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) throws RemoteException;
	
	public BangLuongNhanVien getBLTheoMaNV(int maNV, int thang , int nam) throws RemoteException;
}
