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
@Table(name = "chi_tiet_phieu_phat")
public class ChiTietPhieuPhat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4210250465995811760L;
	@Id
	@Column(name = "ma_ct")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maChiTiet;

	@Column(name = "tien_phat")
	private double tienPhat;

	@ManyToOne
	@JoinColumn(name = "ma_lp")
	private LoaiPhat loaiPhat;

	@ManyToOne
	@JoinColumn(name = "ma_phieu_phat")
	private PhieuPhat phieuPhat;

	public ChiTietPhieuPhat() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietPhieuPhat(int maChiTiet, double tienPhat, LoaiPhat loaiPhat, PhieuPhat phieuPhat) {
		super();
		this.maChiTiet = maChiTiet;
		this.tienPhat = tienPhat;
		this.loaiPhat = loaiPhat;
		this.phieuPhat = phieuPhat;
	}

	public ChiTietPhieuPhat(double tienPhat, LoaiPhat loaiPhat) {
		super();
		this.tienPhat = tienPhat;
		this.loaiPhat = loaiPhat;
	}

	public ChiTietPhieuPhat(double tienPhat, LoaiPhat loaiPhat, PhieuPhat phieuPhat) {
		super();
		this.tienPhat = tienPhat;
		this.loaiPhat = loaiPhat;
		this.phieuPhat = phieuPhat;
	}

	public int getMaChiTiet() {
		return maChiTiet;
	}

	public void setMaChiTiet(int maChiTiet) {
		this.maChiTiet = maChiTiet;
	}

	public double getTienPhat() {
		return tienPhat;
	}

	public void setTienPhat(double tienPhat) {
		this.tienPhat = tienPhat;
	}

	public LoaiPhat getLoaiPhat() {
		return loaiPhat;
	}

	public void setLoaiPhat(LoaiPhat loaiPhat) {
		this.loaiPhat = loaiPhat;
	}

	public PhieuPhat getPhieuPhat() {
		return phieuPhat;
	}

	public void setPhieuPhat(PhieuPhat phieuPhat) {
		this.phieuPhat = phieuPhat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuPhat [maChiTiet=" + maChiTiet + ", tienPhat=" + tienPhat + ", loaiPhat=" + loaiPhat
				+ ", phieuPhat=" + phieuPhat + "]";
	}

}
