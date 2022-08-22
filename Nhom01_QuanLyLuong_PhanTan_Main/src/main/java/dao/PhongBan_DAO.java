package dao;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import entity.PhongBan;
/**
 * Launch the application. Tên: Võ Thị Trà Giang Ngày tạo: 21/08/2022
 */
public interface PhongBan_DAO extends Serializable {
	public List<PhongBan> getListPhongBan() throws RemoteException;
	
	public PhongBan getPhongBanTheoMa(int id) throws RemoteException;
	
	public boolean createPhongBan(PhongBan phongBan) throws RemoteException;
	
	public boolean updatePhongBan(PhongBan phongBan) throws RemoteException;
	
	public boolean deletePhongBan(PhongBan phongBan) throws RemoteException;
}
