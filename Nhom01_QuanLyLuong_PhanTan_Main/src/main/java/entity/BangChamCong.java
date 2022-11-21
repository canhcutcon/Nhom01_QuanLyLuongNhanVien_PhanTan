package entity;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "bang_cham_cong")
public class BangChamCong implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -46506931331423044L;

	@Id
	@Column(name = "ma_cc")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maChamCong;

	@Column(name = "ngay_cong")
	private int ngayCong;

	@Column(name = "thang_cong")
	private int thangCong;

	@Column(name = "name_cong")
	private int namCong;

	@Column(name = "di_lam")
	private boolean diLam;

	@Column(name = "di_tre")
	private boolean diTre;

	@Column(name = "trang_thai")
	private int trangThai;

	@ManyToOne
	@JoinColumn(name = "ma_NV")
	private NhanVien nhanVien;

	public BangChamCong() {
		// TODO Auto-generated constructor stub
	}

	public BangChamCong(int maChamCong, int ngayCong, int thangCong, int namCong, boolean diLam, boolean diTre,
			int trangThai, NhanVien nhanVien) {
		super();
		this.maChamCong = maChamCong;
		this.ngayCong = ngayCong;
		this.thangCong = thangCong;
		this.namCong = namCong;
		this.diLam = diLam;
		this.diTre = diTre;
		this.trangThai = trangThai;
		this.nhanVien = nhanVien;
	}

	public BangChamCong(int ngayCong, int thangCong, int namCong, boolean diLam, boolean diTre, int trangThai,
			NhanVien nhanVien) {
		super();
		this.ngayCong = ngayCong;
		this.thangCong = thangCong;
		this.namCong = namCong;
		this.diLam = diLam;
		this.diTre = diTre;
		this.trangThai = trangThai;
		this.nhanVien = nhanVien;
	}

	public BangChamCong(int maChamCong, int ngayCong, int thangCong, int namCong, boolean diLam, boolean diTre,
			int trangThai) {
		super();
		this.maChamCong = maChamCong;
		this.ngayCong = ngayCong;
		this.thangCong = thangCong;
		this.namCong = namCong;
		this.diLam = diLam;
		this.diTre = diTre;
		this.trangThai = trangThai;
	}

	public BangChamCong(int ngayCong, int thangCong, int namCong, boolean diLam, boolean diTre, int trangThai) {
		super();
		this.ngayCong = ngayCong;
		this.thangCong = thangCong;
		this.namCong = namCong;
		this.diLam = diLam;
		this.diTre = diTre;
		this.trangThai = trangThai;
	}

	public int getMaChamCong() {
		return maChamCong;
	}

	public void setMaChamCong(int maChamCong) {
		this.maChamCong = maChamCong;
	}

	public int getNgayCong() {
		return ngayCong;
	}

	public void setNgayCong(int ngayCong) {
		this.ngayCong = ngayCong;
	}

	public int getThangCong() {
		return thangCong;
	}

	public void setThangCong(int thangCong) {
		this.thangCong = thangCong;
	}

	public int getNamCong() {
		return namCong;
	}

	public void setNamCong(int namCong) {
		this.namCong = namCong;
	}

	public boolean isDiLam() {
		return diLam;
	}

	public void setDiLam(boolean diLam) {
		this.diLam = diLam;
	}

	public boolean isDiTre() {
		return diTre;
	}

	public void setDiTre(boolean diTre) {
		this.diTre = diTre;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
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
		return "BangChamCong [maChamCong=" + maChamCong + ", ngayCong=" + ngayCong + ", thangCong=" + thangCong
				+ ", namCong=" + namCong + ", diLam=" + diLam + ", diTre=" + diTre + ", trangThai=" + trangThai;
	}

}
