package dao;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhanVien;

public interface NhanVienDao extends Serializable {

public List<NhanVien> getListNhanVien() throws RemoteException;
	
	public NhanVien getNhanVienTheoMa(int id) throws RemoteException;
	
	public boolean createNhanVien(NhanVien nhanVien) throws RemoteException;
	
	public boolean deleteNhanVien(NhanVien nhanVien) throws RemoteException;
	
	public boolean updateNhanVien(NhanVien nhanVien) throws RemoteException;
	
	public List<NhanVien> getNhanVienTheoDanhMuc(String tenNV, String sdt, String cmnd, String chucVu) throws RemoteException;

}
