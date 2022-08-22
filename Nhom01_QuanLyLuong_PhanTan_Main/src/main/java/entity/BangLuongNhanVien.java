package entity;

import java.beans.Transient;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * Launch the application. Tên: Huỳnh Nguyễn Quốc Bảo
 */
@Entity
@Table(name = "luong_nhan_vien")

public class BangLuongNhanVien implements Serializable {

	private static final long serialVersionUID = 2306174430773041680L;
	@Id
	@Column(name = "idLuongNhanVien")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLuongNhanVien;
	@Column(nullable = false)
	private double thue;
	@Column(nullable = false)
	private int soNgayLamDuoc;
	@Column(nullable = false)
	private double luongCoBan;
	@Column(nullable = false)
	private String ngayTinhLuong;
	@Column(nullable = false)
	private int chungChi;
	
	//wait for PhieuPhat
	@OneToMany(targetEntity = PhieuPhat.class)
	@JoinColumn(name="idPhieuPhat")
	private Integer maPhieuPhat;
	
	@ManyToOne(targetEntity = NhanVien.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "idNhanVien")
	private NhanVien idNhanVien;
	
	@Column(nullable = false)
	private int trangThai;

	public BangLuongNhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdLuongNhanVien() {
		return idLuongNhanVien;
	}

	public void setIdLuongNhanVien(int idLuongNhanVien) {
		this.idLuongNhanVien = idLuongNhanVien;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

	public int getSoNgayLamDuoc() {
		return soNgayLamDuoc;
	}

	public void setSoNgayLamDuoc(int soNgayLamDuoc) {
		this.soNgayLamDuoc = soNgayLamDuoc;
	}

	public double getLuongCoBan() {
		return luongCoBan;
	}

	public void setLuongCoBan(double luongCoBan) {
		this.luongCoBan = luongCoBan;
	}

	public String getNgayTinhLuong() {
		return ngayTinhLuong;
	}

	public void setNgayTinhLuong(String ngayTinhLuong) {
		this.ngayTinhLuong = ngayTinhLuong;
	}

	public int getChungChi() {
		return chungChi;
	}

	public void setChungChi(int chungChi) {
		this.chungChi = chungChi;
	}

	public int getMaPhieuPhat() {
		return maPhieuPhat;
	}

	public void setMaPhieuPhat(Integer maPhieuPhat) {
		this.maPhieuPhat = maPhieuPhat;
	}

	public NhanVien getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(NhanVien idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public BangLuongNhanVien(double thue, int soNgayLamDuoc, double luongCoBan, String ngayTinhLuong, int chungChi,
			Integer maPhieuPhat, NhanVien idNhanVien, int trangThai) {
		super();
		this.thue = thue;
		this.soNgayLamDuoc = soNgayLamDuoc;
		this.luongCoBan = luongCoBan;
		this.ngayTinhLuong = ngayTinhLuong;
		this.chungChi = chungChi;
		this.maPhieuPhat = maPhieuPhat;
		this.idNhanVien = idNhanVien;
		this.trangThai = trangThai;
	}

	public BangLuongNhanVien(int idLuongNhanVien, double thue, int soNgayLamDuoc, double luongCoBan,
			String ngayTinhLuong, int chungChi, Integer maPhieuPhat, NhanVien idNhanVien, int trangThai) {
		super();
		this.idLuongNhanVien = idLuongNhanVien;
		this.thue = thue;
		this.soNgayLamDuoc = soNgayLamDuoc;
		this.luongCoBan = luongCoBan;
		this.ngayTinhLuong = ngayTinhLuong;
		this.chungChi = chungChi;
		this.maPhieuPhat = maPhieuPhat;
		this.idNhanVien = idNhanVien;
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "BangLuongNhanVien [idLuongNhanVien=" + idLuongNhanVien + ", thue=" + thue + ", soNgayLamDuoc="
				+ soNgayLamDuoc + ", luongCoBan=" + luongCoBan + ", ngayTinhLuong="
				+ ngayTinhLuong + ", chungChi=" + chungChi + ", maPhieuPhat=" + maPhieuPhat + ", idNhanVien="
				+ idNhanVien + ", trangThai=" + trangThai + "]";
	}






}
