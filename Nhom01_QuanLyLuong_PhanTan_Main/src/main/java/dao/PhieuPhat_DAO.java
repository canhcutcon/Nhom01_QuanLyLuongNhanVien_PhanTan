package dao;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import entity.PhieuPhat;

public interface PhieuPhat_DAO extends Serializable {
	public  List<PhieuPhat> getListPhieuPhat() throws RemoteException;
	
	public boolean createPhieuPhat(PhieuPhat phieuPhat) throws RemoteException;
	
	public boolean updatePhieuPhat(PhieuPhat phieuPhat) throws RemoteException;
	
	public boolean deletePhieuPhat(PhieuPhat phieuPhat) throws RemoteException;
}
