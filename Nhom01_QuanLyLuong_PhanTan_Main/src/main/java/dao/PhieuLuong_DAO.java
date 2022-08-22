package dao;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import entity.PhieuLuong;
/**
 * Launch the application. Tên Huỳnh Nguyễn Quốc Bảo
 */
public interface PhieuLuong_DAO  extends Serializable{
	public List<PhieuLuong> getListPhieuLuong() throws RemoteException;
	
	public PhieuLuong getPhieuLuongTheoMa(int id) throws RemoteException;
	
	public boolean createPhieuLuong(PhieuLuong phieuLuong) throws RemoteException;
	
	public boolean deletePhieuLuong(PhieuLuong phieuLuong) throws RemoteException;
	
	public boolean updatePhieuLuong(PhieuLuong phieuLuong) throws RemoteException;
	
}
