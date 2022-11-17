package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.LoaiPhat;

public interface LoaiPhatDao extends Remote{
	public List<LoaiPhat> getListMucPhat() throws RemoteException;

	public boolean createMucPhat(LoaiPhat mucPhat) throws RemoteException;
	
	public boolean updateMucPhat(LoaiPhat mucPhat) throws RemoteException;
	
	public boolean deleteMucPhat(LoaiPhat mucPhat) throws RemoteException;
}
