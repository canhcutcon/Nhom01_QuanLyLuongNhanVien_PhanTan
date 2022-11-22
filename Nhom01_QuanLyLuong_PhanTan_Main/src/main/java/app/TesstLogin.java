package app;

import java.rmi.RemoteException;

import dao.NhanVienDao;
import daoImpl.*;
import entity.NhanVien;

public class TesstLogin {
	public static void main(String[] args) throws RemoteException {
		NhanVienDao nhanVienDao = new NhanVienDaoImpl();
		NhanVien nhanVien = new NhanVien();
		System.out.println(nhanVienDao.checkLoginUser(3, "123456"));
		
	}
}
