package service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import dao.PhongBanDao;
import entity.PhongBan;

public class PhongBanServic {
	PhongBanDao phongBanDao;

	public PhongBanServic(String host, String port) {
		// TODO Auto-generated constructor stub
		try {
			String url = "rmi://" + host + ":" + port + "/phongBanDao";
			System.out.println(url);
			phongBanDao = (PhongBanDao) Naming.lookup(url);

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
	
	public List<PhongBan> getAllPhongBan() throws RemoteException{
		return phongBanDao.getListPhongBan();
	}
	
	public PhongBan getPhongBanByName(String name)
	{
		PhongBan phonpgBan =null;
		try {
			List<PhongBan> lst = getAllPhongBan();
			for (PhongBan pb : lst) {
				if(pb.getTenPB().equals(name))
				{
					phonpgBan = pb;
					return phonpgBan;
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
