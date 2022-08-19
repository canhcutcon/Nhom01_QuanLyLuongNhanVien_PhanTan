package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.*;

public interface ChucVu_DAO extends Remote {
	
	public List<ChucVu> getListChucVU() throws RemoteException;
	
	public ChucVu getChucVuTheoMa(int maCV) throws RemoteException;
	
	public boolean createChucVu(ChucVu chucVu) throws RemoteException;
	
	public boolean deleteChucVu(ChucVu chucVu) throws RemoteException;
	
	public boolean updateChucVu(ChucVu chucVu) throws RemoteException;

}
