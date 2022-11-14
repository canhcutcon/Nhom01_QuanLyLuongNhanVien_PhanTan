package Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.BangChamCongDao;
import dao.BangLuongDao;
import dao.ChiTietPhieuPhatDao;
import dao.LoaiPhatDao;
import dao.NhanVienDao;
import dao.PhieuPhatDao;
import dao.PhongBanDao;
import daoImpl.BangChamCongImpl;
import daoImpl.BangLuongDaoImpl;
import daoImpl.ChiTietPhieuPhatImpl;
import daoImpl.LoaiPhatDaoImpl;
import daoImpl.NhanVienDaoImpl;
import daoImpl.PhieuPhatDaoImpl;
import daoImpl.PhongBanDaoImpl;

public class Server {
	public static String CONFIG = "rmi://172.28.150.126:8988";
	public static int PORT = 8988;

	public static void main(String[] args) throws NamingException, RemoteException {
		// TODO Auto-generated method stub
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put("java.security.policy", "policy/policy.policy");

		Context context = new InitialContext(hashtable);

		
		try {
			PhongBanDao phongBanDao = new PhongBanDaoImpl();
			NhanVienDao nhanVienDao = new NhanVienDaoImpl();
			LoaiPhatDao loaiPhatDao = new LoaiPhatDaoImpl();
			PhieuPhatDao phieuPhatDao = new PhieuPhatDaoImpl();
			ChiTietPhieuPhatDao chiTietPhieuPhatDao = new ChiTietPhieuPhatImpl();
			BangChamCongDao bangChamCongDao = new BangChamCongImpl();
			BangLuongDao bangLuongDao = new BangLuongDaoImpl();

			LocateRegistry.createRegistry(PORT);
			context.bind(CONFIG + "/phongBanDao", phongBanDao);
			context.bind(CONFIG + "/nhanVienDao", nhanVienDao);
			context.bind(CONFIG + "/loaiPhatDao", loaiPhatDao);
			context.bind(CONFIG + "/phieuPhatDao", phieuPhatDao);
			context.bind(CONFIG + "/chiTietPhieuPhatDao", chiTietPhieuPhatDao);
			context.bind(CONFIG + "/bangLuongDao", bangLuongDao);
			context.bind(CONFIG + "/bangChamCongDao", bangChamCongDao);
			System.out.println("Server started at " + LocalDateTime.now() + " on port " + PORT);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}