package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.BangLuongNhanVien;

public interface BangLuongDao extends Remote {

	public List<BangLuongNhanVien> getListBangLuongNhanVien() throws RemoteException;

	public BangLuongNhanVien getBangLuongNhanVienTheoMa(int id) throws RemoteException;

	public boolean createBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) throws RemoteException;

	public boolean updateBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) throws RemoteException;
}
