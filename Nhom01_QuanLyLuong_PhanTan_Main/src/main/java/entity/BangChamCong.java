package entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bang_cham_cong")
public class BangChamCong implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idBangChamCong")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBangChamCong;
	@Column(columnDefinition ="datetime null")
	private Date ngayCong;
	@Column(columnDefinition ="int not null")
	private int chamCong;
	
	@ManyToOne(targetEntity = NhanVien.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "maNV")
	private NhanVien nhanVien;
	
	@Column(columnDefinition ="int null")
	private int trangThai;

	public BangChamCong() {
		super();
	}

	public BangChamCong(int idBangChamCong, Date ngayCong, int chamCong, NhanVien nhanVien, int trangThai) {
		super();
		this.idBangChamCong = idBangChamCong;
		this.ngayCong = ngayCong;
		this.chamCong = chamCong;
		this.nhanVien = nhanVien;
		this.trangThai = trangThai;
	}

	public int getIdBangChamCong() {
		return idBangChamCong;
	}

	public void setIdBangChamCong(int idBangChamCong) {
		this.idBangChamCong = idBangChamCong;
	}

	public Date getNgayCong() {
		return ngayCong;
	}

	public void setNgayCong(Date ngayCong) {
		this.ngayCong = ngayCong;
	}

	public int getChamCong() {
		return chamCong;
	}

	public void setChamCong(int chamCong) {
		this.chamCong = chamCong;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "BangChamCong [idBangChamCong=" + idBangChamCong + ", ngayCong=" + ngayCong + ", chamCong=" + chamCong
				+ ", nhanVien=" + nhanVien + ", trangThai=" + trangThai + "]";
	}
	
	
	
	

}
