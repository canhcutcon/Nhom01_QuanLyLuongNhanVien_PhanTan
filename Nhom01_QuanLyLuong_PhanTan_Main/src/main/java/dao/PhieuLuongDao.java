package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.PhieuLuong;

public interface PhieuLuongDao extends Remote{
	public List<PhieuLuong> getListPhieuLuong(int maNV,int thang, int nam) throws RemoteException;
}
