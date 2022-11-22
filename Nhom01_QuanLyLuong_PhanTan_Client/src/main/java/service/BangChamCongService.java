package service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import dao.BangChamCongDao;
import entity.BangChamCong;

public class BangChamCongService {
	BangChamCongDao bangChamCongDao;

	public BangChamCongService(String host, String port) {
		// TODO Auto-generated constructor stub
		try {
			String url = "rmi://" + host + ":" + port + "/bangChamCongDao";
			System.out.println(url);
			bangChamCongDao = (BangChamCongDao) Naming.lookup(url);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean addBangChamCong(BangChamCong bangChamCong) throws RemoteException {
		return bangChamCongDao.createChamCong(bangChamCong);
	}

	public List<BangChamCong> getListChamCong(int ngayCong, int thang, int nam, int maPB) throws RemoteException {
		return bangChamCongDao.getListChamCong(ngayCong, thang, nam, maPB);
	}

	public boolean updateChamCong(BangChamCong bangChamCong) throws RemoteException {
		return bangChamCongDao.updateChamCong(bangChamCong);
	}

	public BangChamCong getBangChamCongById(int maCC) throws RemoteException {
		return bangChamCongDao.getBangChamCongById(maCC);
	}

	public int getSoNgayCong(int thang, int nam, int maPB, int maNV) throws RemoteException {
		return bangChamCongDao.getSoNgayCong(thang, nam, maPB, maNV);
	}
}
