package dao;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import entity.BangLuongNhanVien;
/**
 * Launch the application. Tên Huỳnh Nguyễn Quốc Bảo
 */
public interface BangLuongNhanVien_DAO extends Serializable{
	public List<BangLuongNhanVien> getListBangLuongNhanVien() throws RemoteException;
	
	public BangLuongNhanVien getBangLuongNhanVienTheoMa(int id) throws RemoteException;
	
	public boolean createBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) throws RemoteException;
	
	public boolean deleteBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) throws RemoteException;
	
	public boolean updateBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) throws RemoteException;
	
}
