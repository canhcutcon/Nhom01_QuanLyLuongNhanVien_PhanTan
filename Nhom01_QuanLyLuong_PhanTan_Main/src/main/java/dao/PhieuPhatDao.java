package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.PhieuPhat;

public interface PhieuPhatDao extends Remote {

public  List<PhieuPhat> getListPhieuPhat() throws RemoteException;
	
	public boolean createPhieuPhat(PhieuPhat phieuPhat) throws RemoteException;
	
	public boolean updatePhieuPhat(PhieuPhat phieuPhat) throws RemoteException;
}
