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

@Entity
@Table(name ="bang_cham_cong")
public class BangChamCong implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5253825226804084141L;
	
	@Id
	@Column(name = "ma_cc")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maChamCong;
	
	@Column(name = "ngay_cong", columnDefinition = "datetime")
	private LocalDate ngayCong;
	
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

	public BangChamCong(int maChamCong, LocalDate ngayCong, boolean diLam, boolean diTre, int trangThai,
			NhanVien nhanVien) {
		super();
		this.maChamCong = maChamCong;
		this.ngayCong = ngayCong;
		this.diLam = diLam;
		this.diTre = diTre;
		this.trangThai = trangThai;
		this.nhanVien = nhanVien;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (diLam ? 1231 : 1237);
		result = prime * result + (diTre ? 1231 : 1237);
		result = prime * result + maChamCong;
		result = prime * result + ((ngayCong == null) ? 0 : ngayCong.hashCode());
		result = prime * result + ((nhanVien == null) ? 0 : nhanVien.hashCode());
		result = prime * result + trangThai;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BangChamCong other = (BangChamCong) obj;
		if (diLam != other.diLam)
			return false;
		if (diTre != other.diTre)
			return false;
		if (maChamCong != other.maChamCong)
			return false;
		if (ngayCong == null) {
			if (other.ngayCong != null)
				return false;
		} else if (!ngayCong.equals(other.ngayCong))
			return false;
		if (nhanVien == null) {
			if (other.nhanVien != null)
				return false;
		} else if (!nhanVien.equals(other.nhanVien))
			return false;
		if (trangThai != other.trangThai)
			return false;
		return true;
	}

	public int getMaChamCong() {
		return maChamCong;
	}

	public void setMaChamCong(int maChamCong) {
		this.maChamCong = maChamCong;
	}

	public LocalDate getNgayCong() {
		return ngayCong;
	}

	public void setNgayCong(LocalDate ngayCong) {
		this.ngayCong = ngayCong;
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
	
	
	
	
	

}
