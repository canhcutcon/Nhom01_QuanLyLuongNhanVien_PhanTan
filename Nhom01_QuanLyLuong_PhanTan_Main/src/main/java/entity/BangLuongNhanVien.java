package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bang_luong")
public class BangLuongNhanVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 562606000692588963L;

	@Id
	@Column(name = "ma_luong")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maLuong;

	private double thue;

	@Column(name = "phu_cap")
	private double PhuCap;

	@Column(name = "ngay_tinh_luong", columnDefinition = "datetime")
	private String ngayTinhLuong;

	@Column(name = "so_ngay_lam")
	private int soNgayLam;

	@Column(name = "luong_co_ban")
	private double luongCoBan;

	@Column(name = "chung_chi")
	private int soChungChi;

	@Column(name = "ngay_nhan", columnDefinition = "datetime")
	private LocalDate ngayNhan;

	@Column(name = "trang_thai")
	private int trangThai;

	@Column(name = "tien_phat")
	private double tienPhat;
	
	@ManyToOne
	@JoinColumn(name = "ma_nv")
	private NhanVien nhanVien;

	public BangLuongNhanVien() {
		// TODO Auto-generated constructor stub
	}

	public BangLuongNhanVien(int maLuong, double thue, double phuCap, String ngayTinhLuong, int soNgayLam,
			double luongCoBan, int soChungChi, LocalDate ngayNhan, int trangThai, double tienPhat,
			NhanVien nhanVien) {
		super();
		this.maLuong = maLuong;
		this.thue = thue;
		PhuCap = phuCap;
		this.ngayTinhLuong = ngayTinhLuong;
		this.soNgayLam = soNgayLam;
		this.luongCoBan = luongCoBan;
		this.soChungChi = soChungChi;
		this.ngayNhan = ngayNhan;
		this.trangThai = trangThai;
		this.tienPhat = tienPhat;
		this.nhanVien = nhanVien;
	}

	public int getMaLuong() {
		return maLuong;
	}

	public void setMaLuong(int maLuong) {
		this.maLuong = maLuong;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

	public double getPhuCap() {
		return PhuCap;
	}

	public void setPhuCap(double phuCap) {
		PhuCap = phuCap;
	}

	public String getNgayTinhLuong() {
		return ngayTinhLuong;
	}

	public void setNgayTinhLuong(String ngayTinhLuong) {
		this.ngayTinhLuong = ngayTinhLuong;
	}

	public int getSoNgayLam() {
		return soNgayLam;
	}

	public void setSoNgayLam(int soNgayLam) {
		this.soNgayLam = soNgayLam;
	}

	public double getLuongCoBan() {
		return luongCoBan;
	}

	public void setLuongCoBan(double luongCoBan) {
		this.luongCoBan = luongCoBan;
	}

	public int getSoChungChi() {
		return soChungChi;
	}

	public void setSoChungChi(int soChungChi) {
		this.soChungChi = soChungChi;
	}

	public LocalDate getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(LocalDate ngayNhan) {
		this.ngayNhan = ngayNhan;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public double getLuongThucNhan() {
		return tienPhat;
	}

	public void setLuongThucNhan(double luongThucNhan) {
		this.tienPhat = luongThucNhan;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	
	@Override
	public String toString() {
		return "BangLuongNhanVien [maLuong=" + maLuong + ", thue=" + thue + ", PhuCap=" + PhuCap + ", ngayTinhLuong="
				+ ngayTinhLuong + ", soNgayLam=" + soNgayLam + ", luongCoBan=" + luongCoBan + ", soChungChi="
				+ soChungChi + ", ngayNhan=" + ngayNhan + ", trangThai=" + trangThai + ", luongThucNhan="
				+ tienPhat + ", nhanVien=" + nhanVien + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(PhuCap, luongCoBan, tienPhat, maLuong, ngayNhan, ngayTinhLuong, nhanVien, soChungChi,
				soNgayLam, thue, trangThai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BangLuongNhanVien other = (BangLuongNhanVien) obj;
		return Double.doubleToLongBits(PhuCap) == Double.doubleToLongBits(other.PhuCap)
				&& Double.doubleToLongBits(luongCoBan) == Double.doubleToLongBits(other.luongCoBan)
				&& Double.doubleToLongBits(tienPhat) == Double.doubleToLongBits(other.tienPhat)
				&& maLuong == other.maLuong && Objects.equals(ngayNhan, other.ngayNhan)
				&& Objects.equals(ngayTinhLuong, other.ngayTinhLuong) && Objects.equals(nhanVien, other.nhanVien)
				&& soChungChi == other.soChungChi && soNgayLam == other.soNgayLam
				&& Double.doubleToLongBits(thue) == Double.doubleToLongBits(other.thue) && trangThai == other.trangThai;
	}
	
	

}
