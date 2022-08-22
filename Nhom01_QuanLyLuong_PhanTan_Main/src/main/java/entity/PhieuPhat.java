package entity;

import java.io.Serializable;

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
@Table(name = "phieu_phat")
public class PhieuPhat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idPhieuPhat")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPhieuPhat;
	
	@ManyToOne(targetEntity = MucPhat.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "maMucPhat")
	private MucPhat mucPhat;
	
	@Column(nullable = false)
	private int trangThai;
	
	@ManyToOne(targetEntity = NhanVien.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;

	public PhieuPhat() {
		super();
	}

	public PhieuPhat(int idPhieuPhat, MucPhat mucPhat, int trangThai, NhanVien nhanVien) {
		super();
		this.idPhieuPhat = idPhieuPhat;
		this.mucPhat = mucPhat;
		this.trangThai = trangThai;
		this.nhanVien = nhanVien;
	}

	public int getIdPhieuPhat() {
		return idPhieuPhat;
	}

	public void setIdPhieuPhat(int idPhieuPhat) {
		this.idPhieuPhat = idPhieuPhat;
	}

	public MucPhat getMucPhat() {
		return mucPhat;
	}

	public void setMucPhat(MucPhat mucPhat) {
		this.mucPhat = mucPhat;
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
		return "PhieuPhat [idPhieuPhat=" + idPhieuPhat + ", mucPhat=" + mucPhat + ", trangThai=" + trangThai
				+ ", nhanVien=" + nhanVien + "]";
	}
}
