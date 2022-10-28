package dao;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietPhieuPhat;

public interface ChiTietPhieuPhatDao extends Serializable{
	public ChiTietPhieuPhat getCTPhieuPhatTheoMa(int id) throws RemoteException;

	public boolean createCTPhieuPhat(ChiTietPhieuPhat chiTietPhieuPhat) throws RemoteException;

	public boolean deleteCTPhieuPhat(ChiTietPhieuPhat chiTietPhieuPhat) throws RemoteException;

	public boolean updateCTPhieuPhat(ChiTietPhieuPhat chiTietPhieuPhat) throws RemoteException;

	public List<ChiTietPhieuPhat> getNhanVienTheoDanhMuc(String tenLoaiPhat, String maNhanVien) throws RemoteException;
}
