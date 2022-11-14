package daoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.List;

import dao.BangChamCongDao;
import entity.BangChamCong;

public class BangChamCongImpl extends UnicastRemoteObject implements BangChamCongDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5495703951755090109L;

	public BangChamCongImpl() throws RemoteException{
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public List<BangChamCong> getListChamCong() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createChamCong(BangChamCong bangChamCong) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BangChamCong> getListChamCongTheoNgay(Date date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateChamCong(BangChamCong bangChamCong) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
