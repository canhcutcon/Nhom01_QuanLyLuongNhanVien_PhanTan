package app;

import java.rmi.RemoteException;
<<<<<<< HEAD

import Util.HibernateUtil;
import dao.NhanVienDao;
import daoImpl.NhanVienDaoImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
=======
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.BangChamCongDao;
import dao.NhanVienDao;
import dao.PhongBanDao;
import daoImpl.BangChamCongImpl;
import daoImpl.NhanVienDaoImpl;
import daoImpl.PhongBanDaoImpl;
import entity.BangChamCong;
import entity.NhanVien;
import entity.PhongBan;
>>>>>>> 668bbde74e97932b7795eac5d7abbb7cbab8759b

public class test {
	public static void main(String[] args) throws RemoteException {
		
		//Create database
		try {
			NhanVienDao nvDao = new NhanVienDaoImpl();
			PhongBanDao phongBanDao = new PhongBanDaoImpl();
			NhanVien a = nvDao.getNhanVienTheoMa(30);
//			a.setTenNV("Mã Tiểu Linh");
//			System.out.println(nvDao.getNhanVienTheoDanhMuc("Giang", "", "", ""));
//			nvDao.deleteNhanVien(a);
//			addAllNhanVien();
//			nvDao.getListNhanVien().forEach(e -> System.out.println(e));
			BangChamCongDao bangChamCongDao = new BangChamCongImpl();
//			for (int i = 1; i < 31; i++) {
//				BangChamCong bangChamCong = new BangChamCong(i, 11, 2022, 
//			true, false, 1,a);
//				bangChamCongDao.createChamCong(bangChamCong);
//			}
			BangChamCong bangChamCong = bangChamCongDao.getBangChamCongById(1);
			System.out.println(bangChamCong);
			bangChamCong.setDiTre(true);
			bangChamCongDao.updateChamCong(bangChamCong);
//			bangChamCongDao.getListChamCong(1, 11, 2022, 1).forEach(e -> System.out.println(e));
//			System.out.println(bangChamCongDao.getBangChamCongById(1));
			System.out.println(bangChamCongDao.getSoNgayCong(11, 2022, 1, 11));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addAllNhanVien() {
		try {
			NhanVienDao dao = new NhanVienDaoImpl();
			PhongBanDao phongBanDao = new PhongBanDaoImpl();
			List<PhongBan> bans = phongBanDao.getListPhongBan();
			bans.forEach(b -> System.out.println(b));
			List<NhanVien> list = new ArrayList<NhanVien>();
			list.add(new NhanVien("Võ Thị Trà Giang", "0908776678", "123456789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "MANAGER", "123456", true, "", 1, bans.get(0)));
			list.add(new NhanVien("Trần Văn Sỹ", "0908776111", "113456789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "SALARY_MANAGER", "123456", true, "", 1, bans.get(1)));
			list.add(new NhanVien("Mã Tiểu Linh", "090877667", "173456789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "SALARY_MANAGER", "123456", true, "", 1, bans.get(3)));
			list.add(new NhanVien("Huỳnh Nguyễn Quốc Bảo", "0908776112", "133456789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "EMPLOYEE_MANAGER", "123456", true, "", 1, bans.get(2)));
			
			list.add(new NhanVien("Đoàn Ngọc Quốc Bảo", "0908776678", "143456789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "EMPLOYEE", "123456", false, "", 1, bans.get(0)));
			list.add(new NhanVien("Lê Nguyễn Tuân", "090877667", "153456789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "EMPLOYEE", "123456", false, "", 1, bans.get(0)));
			list.add(new NhanVien("Đinh Quang Huy", "090847667", "163456789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "EMPLOYEE", "123456", false, "", 1, bans.get(0)));
			list.add(new NhanVien("Nguyễn Ngọc Tuyết", "090877667", "183456789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "EMPLOYEE", "123456", false, "", 1, bans.get(0)));
			
			list.add(new NhanVien("Thái Trần Thảo My", "090877667", "193456789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "EMPLOYEE", "123456", false, "", 1, bans.get(1)));
			list.add(new NhanVien("Mai Trung Kiên", "090877337", "121456789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "EMPLOYEE", "123456", false, "", 1, bans.get(1)));
			list.add(new NhanVien("Mai Kiên Cường", "090877667", "122456789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "EMPLOYEE", "123456", false, "", 1, bans.get(1)));
			list.add(new NhanVien("Đỗ Ngọc Thảo Vy", "090177667", "124456789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "EMPLOYEE", "123456", false, "", 1, bans.get(1)));
			
			list.add(new NhanVien("Đinh Trần Minh Thư", "090277667", "125456789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "EMPLOYEE", "123456", false, "", 1, bans.get(2)));
			list.add(new NhanVien("Đinh Thị Thu", "090377667", "126456789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "EMPLOYEE", "123456", false, "", 1, bans.get(2)));
			list.add(new NhanVien("Dương Thu Thúy", "090477667", "127456789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "EMPLOYEE", "123456", false, "", 1, bans.get(2)));
			list.add(new NhanVien("Nguyễn Hà Đại Minh", "090577667", "128456789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "EMPLOYEE", "123456", false, "", 1, bans.get(2)));
			
			list.add(new NhanVien("Kim Tú Nghiên", "090677667", "129456789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "EMPLOYEE", "123456", false, "", 1, bans.get(3)));
			list.add(new NhanVien("Dỗ Khánh Tú", "090777667", "123416789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "EMPLOYEE", "123456", false, "", 1, bans.get(3)));
			list.add(new NhanVien("Phác Thái Anh", "090977667", "123256789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "EMPLOYEE", "123456", false, "", 1, bans.get(3)));
			list.add(new NhanVien("Kim Trân Ni", "090077667", "123356789", "Nguyễn Văn Bảo Gò Vấp",LocalDate.now(), LocalDate.now(), "EMPLOYEE", "123456", false, "", 1, bans.get(3)));
			
			list.forEach(e -> {
				try {
					dao.createNhanVien(e);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		NhanVienDao nv = new NhanVienDaoImpl();
		System.out.println(nv.getNhanVienTheoMa(1).getTenNV());
		
	}
	

}
