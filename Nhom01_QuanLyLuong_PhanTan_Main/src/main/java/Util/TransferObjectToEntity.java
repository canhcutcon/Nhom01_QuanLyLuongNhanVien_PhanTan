package Util;

import java.util.ArrayList;
import java.util.List;

import entity.NhanVien;
import entity.PhongBan;

public class TransferObjectToEntity {
	
	public static List<NhanVien> getListNVFromObj(List<?> lstList){
		List<NhanVien> lstNhanViens = new ArrayList<NhanVien>();
		
		for (Object object : lstList) {
			Object[] rs = (Object[])object;		
			int id = Integer.parseInt(rs[0].toString());
			String chucvu = rs[1].toString();
			String cmnd = rs[2].toString();
			String diaChi = rs[3].toString();
			String hinhAnh = rs[4].toString();
			boolean isAdmin = Boolean.parseBoolean(rs[5].toString());
			String matkhau;
		}
		return lstNhanViens;
	}

}
