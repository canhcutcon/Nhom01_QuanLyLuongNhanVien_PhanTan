package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.PhongBan;

public interface PhongBanDao extends Remote {

	public List<PhongBan> getListPhongBan() throws RemoteException;

	public PhongBan getPhongBanTheoMa(int id) throws RemoteException;

	public boolean createPhongBan(PhongBan phongBan) throws RemoteException;

	public boolean updatePhongBan(PhongBan phongBan) throws RemoteException;

	public boolean deletePhongBan(PhongBan phongBan) throws RemoteException;

}
