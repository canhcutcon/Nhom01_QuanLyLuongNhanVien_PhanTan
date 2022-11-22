package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhanVien;

public interface NhanVienDao extends Remote {

	public List<NhanVien> getListNhanVien() throws RemoteException;
	
	public List<NhanVien> getListNhanVien(String maPB) throws RemoteException;

	public NhanVien getNhanVienTheoMa(int id) throws RemoteException;

	public boolean createNhanVien(NhanVien nhanVien) throws RemoteException;

	public boolean deleteNhanVien(NhanVien nhanVien) throws RemoteException;

	public boolean updateNhanVien(NhanVien nhanVien) throws RemoteException;

	public List<NhanVien> getNhanVienTheoDanhMuc(String tenNV, String sdt, String cmnd, String chucVu)
			throws RemoteException;
	
	public boolean checkLoginUser(int maNV,String makhau) throws RemoteException;

}
