package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "phieu_luong")
public class PhieuLuong implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3414856869408406723L;
	@Id
	@Column(name = "ma_pl")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maPhieuLuong;
	@Column(name = "ngay_nhan")
	private int ngayNhan;
	@Column(name = "thang_nhan")
	private int thangNhan;

	@Column(name = "nam_nhan")
	private int namNhan;

	@Column(name = "tong_tien")
	private double tongTienLuong;

	@Column(name = "thuc_nhan")
	private double thucNhan;

	@ManyToOne
	@JoinColumn(name = "ma_nv")
	private NhanVien nhanVien;

	public PhieuLuong() {
		// TODO Auto-generated constructor stub
	}

	public PhieuLuong(int thangNhan, int namNhan, double tongTienLuong, double thucNhan, NhanVien nhanVien) {
		super();
		this.thangNhan = thangNhan;
		this.namNhan = namNhan;
		this.tongTienLuong = tongTienLuong;
		this.thucNhan = thucNhan;
		this.nhanVien = nhanVien;
	}

	public PhieuLuong(int thangNhan, int namNhan, double tongTienLuong, double thucNhan) {
		super();
		this.thangNhan = thangNhan;
		this.namNhan = namNhan;
		this.tongTienLuong = tongTienLuong;
		this.thucNhan = thucNhan;
	}

	public PhieuLuong(int maPhieuLuong, int thangNhan, int namNhan, double tongTienLuong, double thucNhan,
			NhanVien nhanVien) {
		super();
		this.maPhieuLuong = maPhieuLuong;
		this.thangNhan = thangNhan;
		this.namNhan = namNhan;
		this.tongTienLuong = tongTienLuong;
		this.thucNhan = thucNhan;
		this.nhanVien = nhanVien;
	}

	public int getMaPhieuLuong() {
		return maPhieuLuong;
	}

	public void setMaPhieuLuong(int maPhieuLuong) {
		this.maPhieuLuong = maPhieuLuong;
	}

	public int getThangNhan() {
		return thangNhan;
	}

	public void setThangNhan(int thangNhan) {
		this.thangNhan = thangNhan;
	}

	public int getNamNhan() {
		return namNhan;
	}

	public void setNamNhan(int namNhan) {
		this.namNhan = namNhan;
	}

	public double getTongTienLuong() {
		return tongTienLuong;
	}

	public void setTongTienLuong(double tongTienLuong) {
		this.tongTienLuong = tongTienLuong;
	}

	public double getThucNhan() {
		return thucNhan;
	}

	public void setThucNhan(double thucNhan) {
		this.thucNhan = thucNhan;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PhieuLuong [maPhieuLuong=" + maPhieuLuong + ", thangNhan=" + thangNhan + ", namNhan=" + namNhan
				+ ", tongTienLuong=" + tongTienLuong + ", thucNhan=" + thucNhan + "]";
	}

}
