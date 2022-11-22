package dao;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

import entity.BangChamCong;

public interface BangChamCongDao extends Remote {
	public List<BangChamCong> getListChamCong(int ngayCong,int thang, int nam,int maPB) throws RemoteException;
	
	public boolean createChamCong(BangChamCong bangChamCong) throws RemoteException;

	public List<BangChamCong> getListChamCongTheoNgay(Date date) throws RemoteException;

	public boolean updateChamCong(BangChamCong bangChamCong) throws RemoteException;
	
	public BangChamCong getBangChamCongById(int maCC) throws RemoteException;
	
	public int getSoNgayCong(int thang, int nam,int maPB, int maNV) throws RemoteException;
	
	public int getSoNgayDiTre(int thang, int nam,int maPB, int maNV) throws RemoteException;
	
}
