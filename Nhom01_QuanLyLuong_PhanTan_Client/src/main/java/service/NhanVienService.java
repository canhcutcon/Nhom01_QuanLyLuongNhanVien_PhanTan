package service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import dao.NhanVienDao;
import dao.PhongBanDao;
import entity.NhanVien;

public class NhanVienService {
	NhanVienDao nhanVienDao;
	public NhanVienService(String ip, String port) {
		// TODO Auto-generated constructor stub
		try {
			String url = "rmi://" + ip + ":" + port + "/nhanVienDao";
			System.out.println(url);
			nhanVienDao = (NhanVienDao) Naming.lookup(url);

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
	
	public boolean addNewNhanVien(NhanVien nhanVien) throws RemoteException
	{
		return nhanVienDao.createNhanVien(nhanVien);
	}
	
	public NhanVien getNhanVienTheoMa(int id) throws RemoteException
	{
		return nhanVienDao.getNhanVienTheoMa(id);
	}
	
	public List<NhanVien> getAllNhanVien() throws RemoteException{
		return nhanVienDao.getListNhanVien();
	}
	
	public List<NhanVien> getAllNhanVien(String maPB) throws RemoteException{
		return nhanVienDao.getListNhanVien(maPB);
	}
	
	
	public boolean updateNhanVien(NhanVien nhanVien) throws RemoteException {
		return nhanVienDao.updateNhanVien(nhanVien);
	}
	
	public boolean deleteNhanVien(NhanVien nhanVien) throws RemoteException {
		return nhanVienDao.deleteNhanVien(nhanVien);
	}
	
	public List<NhanVien> getNhanVienTheoDanhMuc(String tenNV, String sdt, String cmnd, String chucVu) throws RemoteException{
		return nhanVienDao.getNhanVienTheoDanhMuc(tenNV, sdt, cmnd, chucVu);
	}
	 

}
