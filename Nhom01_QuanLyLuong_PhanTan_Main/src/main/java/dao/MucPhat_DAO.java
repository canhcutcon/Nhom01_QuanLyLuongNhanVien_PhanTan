package dao;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import entity.MucPhat;

public interface MucPhat_DAO extends Serializable {

	public List<MucPhat> getListMucPhat() throws RemoteException;

	public boolean createMucPhat(MucPhat mucPhat) throws RemoteException;
	
	public boolean updateMucPhat(MucPhat mucPhat) throws RemoteException;
	
	public boolean deleteMucPhat(MucPhat mucPhat) throws RemoteException;
}
