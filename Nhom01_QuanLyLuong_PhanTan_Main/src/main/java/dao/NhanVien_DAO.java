package dao;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhanVien;

public interface NhanVien_DAO extends Serializable{
	public List<NhanVien> getListNhanVien() throws RemoteException;
	
	public NhanVien getNhanVienTheoMa(int id) throws RemoteException;
	
	public boolean createNhanVien(NhanVien nhanVien) throws RemoteException;
	
	public boolean deleteNhanVien(NhanVien nhanVien) throws RemoteException;
	
	public boolean updateNhanVien(NhanVien nhanVien) throws RemoteException;
	
	public List<NhanVien> getNhanVienTheoDanhMuc(int maNV, String tenNV, String sdt, String cmnd, int chucVu) throws RemoteException;
}
