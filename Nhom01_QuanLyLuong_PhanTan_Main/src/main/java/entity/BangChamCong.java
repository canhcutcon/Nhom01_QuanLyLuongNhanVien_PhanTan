package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	@OneToMany(mappedBy = "bangChamCong")
	private List<NhanVien> nhanViens = new ArrayList<NhanVien>();

	public BangChamCong() {
		// TODO Auto-generated constructor stub
	}

	public BangChamCong(int maChamCong, LocalDate ngayCong, boolean diLam, boolean diTre, int trangThai,
			List<NhanVien> nhanViens) {
		super();
		this.maChamCong = maChamCong;
		this.ngayCong = ngayCong;
		this.diLam = diLam;
		this.diTre = diTre;
		this.trangThai = trangThai;
		this.nhanViens = nhanViens;
	}

	public BangChamCong(LocalDate ngayCong, boolean diLam, boolean diTre, int trangThai) {
		super();
		this.ngayCong = ngayCong;
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

	public List<NhanVien> getNhanViens() {
		return nhanViens;
	}

	public void setNhanViens(List<NhanVien> nhanViens) {
		this.nhanViens = nhanViens;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BangChamCong [maChamCong=" + maChamCong + ", ngayCong=" + ngayCong + ", diLam=" + diLam + ", diTre="
				+ diTre + ", trangThai=" + trangThai + ", nhanViens=" + nhanViens + "]";
	}
	
	

}
