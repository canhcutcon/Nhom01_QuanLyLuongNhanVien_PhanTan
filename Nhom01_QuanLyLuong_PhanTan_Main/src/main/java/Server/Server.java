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
import dao.LoaiPhatDao;
import dao.NhanVienDao;
import dao.PhieuPhatDao;
import dao.PhongBanDao;
import daoImpl.BangChamCongImpl;
import daoImpl.BangLuongDaoImpl;
import daoImpl.LoaiPhatDaoImpl;
import daoImpl.NhanVienDaoImpl;
import daoImpl.PhieuPhatDaoImpl;
import daoImpl.PhongBanDaoImpl;

public class Server {
	/*
	 * Đặt biến hằng số mà ko final vcl
	 * */
	public static final String CONFIG = "rmi://localhost:8988";
	public static final int PORT = 8988;

	public static void main(String[] args) throws NamingException, RemoteException {
		// TODO Auto-generated method stub

		SecurityManager securityManager= System.getSecurityManager();
		if(securityManager==null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
//			System.setSecurityManager(new SecurityManager());
		}
//
//		Context context = new InitialContext();
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put("java.security.policy", "policy/policy.policy");
		
		Context context = new InitialContext(hashtable);
		try {
			PhongBanDao phongBanDao = new PhongBanDaoImpl();
			NhanVienDao nhanVienDao = new NhanVienDaoImpl();
			LoaiPhatDao loaiPhatDao = new LoaiPhatDaoImpl();
			PhieuPhatDao phieuPhatDao = new PhieuPhatDaoImpl();
			BangChamCongDao bangChamCongDao = new BangChamCongImpl();
			BangLuongDao bangLuongDao = new BangLuongDaoImpl();

			
			LocateRegistry.createRegistry(PORT);
			context.bind(CONFIG + "/phongBanDao", phongBanDao);
			context.bind(CONFIG + "/nhanVienDao", nhanVienDao);
			context.bind(CONFIG + "/loaiPhatDao", loaiPhatDao);
			context.bind(CONFIG + "/phieuPhatDao", phieuPhatDao);
			context.bind(CONFIG + "/bangLuongDao", bangLuongDao);
			context.bind(CONFIG + "/bangChamCongDao", bangChamCongDao);
			System.out.println("Server started at " + LocalDateTime.now() + " on port " + PORT);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}