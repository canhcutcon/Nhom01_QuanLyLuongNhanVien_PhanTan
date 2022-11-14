package daoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.BangLuongDao;
import entity.BangLuongNhanVien;

public class BangLuongDaoImpl extends UnicastRemoteObject implements BangLuongDao{

	public BangLuongDaoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7296567180198371088L;

	@Override
	public List<BangLuongNhanVien> getListBangLuongNhanVien() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BangLuongNhanVien getBangLuongNhanVienTheoMa(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	

}
