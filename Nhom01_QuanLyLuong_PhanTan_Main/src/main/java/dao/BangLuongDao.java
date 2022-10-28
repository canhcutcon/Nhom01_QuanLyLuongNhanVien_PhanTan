package dao;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import entity.BangLuongNhanVien;

public interface BangLuongDao extends Serializable {

	public List<BangLuongNhanVien> getListBangLuongNhanVien() throws RemoteException;

	public BangLuongNhanVien getBangLuongNhanVienTheoMa(int id) throws RemoteException;

	public boolean createBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) throws RemoteException;

	public boolean updateBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) throws RemoteException;
}
