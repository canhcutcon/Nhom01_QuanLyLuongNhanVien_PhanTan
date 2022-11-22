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

@SuppressWarnings("serial")
@Entity
@Table(name = "bang_luong")
public class BangLuongNhanVien implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3735667916553231485L;

	@Id
	@Column(name = "ma_luong")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maLuong;

	private double thue;

	@Column(name = "phu_cap")
	private double phuCap;

	@Column(name = "ngay")
	private int ngay;

	@Column(name = "thang")
	private int thangLuong;

	@Column(name = "nam")
	private int nam;

	@Column(name = "so_ngay_lam")
	private int soNgayLam;

	@Column(name = "luong_co_ban")
	private double luongCoBan;

	@Column(name = "chung_chi")
	private int soChungChi;

	@Column(name = "trang_thai")
	private int trangThai;

	@Column(name = "tien_phat")
	private double tienPhat;

	@ManyToOne
	@JoinColumn(name = "ma_nv")
	private NhanVien nhanVien;

	public BangLuongNhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BangLuongNhanVien(int maLuong, double thue, double phuCap, int ngay, int thangLuong, int nam, int soNgayLam,
			double luongCoBan, int soChungChi, int trangThai, double tienPhat, NhanVien nhanVien) {
		super();
		this.maLuong = maLuong;
		this.thue = thue;
		this.phuCap = phuCap;
		this.ngay = ngay;
		this.thangLuong = thangLuong;
		this.nam = nam;
		this.soNgayLam = soNgayLam;
		this.luongCoBan = luongCoBan;
		this.soChungChi = soChungChi;
		this.trangThai = trangThai;
		this.tienPhat = tienPhat;
		this.nhanVien = nhanVien;
	}

	public BangLuongNhanVien(double thue, double phuCap, int ngay, int thangLuong, int nam, int soNgayLam,
			double luongCoBan, int soChungChi, int trangThai, double tienPhat, NhanVien nhanVien) {
		super();
		this.thue = thue;
		this.phuCap = phuCap;
		this.ngay = ngay;
		this.thangLuong = thangLuong;
		this.nam = nam;
		this.soNgayLam = soNgayLam;
		this.luongCoBan = luongCoBan;
		this.soChungChi = soChungChi;
		this.trangThai = trangThai;
		this.tienPhat = tienPhat;
		this.nhanVien = nhanVien;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return phuCap;
	}

	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}

	public int getNgay() {
		return ngay;
	}

	public void setNgay(int ngay) {
		this.ngay = ngay;
	}

	public int getThangLuong() {
		return thangLuong;
	}

	public void setThangLuong(int thangLuong) {
		this.thangLuong = thangLuong;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		this.nam = nam;
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

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public double getTienPhat() {
		return tienPhat;
	}

	public void setTienPhat(double tienPhat) {
		this.tienPhat = tienPhat;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	@Override
	public String toString() {
		return "BangLuongNhanVien [maLuong=" + maLuong + ", thue=" + thue + ", PhuCap=" + phuCap + ", ngay=" + ngay
				+ ", thangLuong=" + thangLuong + ", nam=" + nam + ", soNgayLam=" + soNgayLam + ", luongCoBan="
				+ luongCoBan + ", soChungChi=" + soChungChi + ", trangThai=" + trangThai + ", tienPhat=" + tienPhat
				+ "]";
	}

}
