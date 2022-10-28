package daoImpl;

import java.rmi.RemoteException;
import java.util.List;

import dao.ChiTietPhieuPhatDao;
import entity.ChiTietPhieuPhat;

public class ChiTietPhieuPhatImpl implements ChiTietPhieuPhatDao{

	public ChiTietPhieuPhatImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ChiTietPhieuPhat getCTPhieuPhatTheoMa(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createCTPhieuPhat(ChiTietPhieuPhat chiTietPhieuPhat) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCTPhieuPhat(ChiTietPhieuPhat chiTietPhieuPhat) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCTPhieuPhat(ChiTietPhieuPhat chiTietPhieuPhat) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ChiTietPhieuPhat> getNhanVienTheoDanhMuc(String tenLoaiPhat, String maNhanVien) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
