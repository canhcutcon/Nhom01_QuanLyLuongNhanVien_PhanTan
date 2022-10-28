package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "loai_phat")
public class LoaiPhat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2126773171731199974L;

	@Id
	@Column(name = "ma_lp")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maLoaiPhat;

	@Column(name = "ten_loai", columnDefinition = "varchar(255) not null")
	private String tenLoai;

	@Column(name = "tien_phat", columnDefinition = "double not null")
	private double tienPhat;

	@Column(name = "trang_thai", nullable = false)
	private int trangThai;

	@OneToMany(mappedBy = "loaiPhat")
	private List<ChiTietPhieuPhat> chiTietPhieuPhats = new ArrayList<ChiTietPhieuPhat>();

	public LoaiPhat() {
		// TODO Auto-generated constructor stub
	}

	public LoaiPhat(int maLoaiPhat, String tenLoai, double tienPhat, int trangThai) {
		super();
		this.maLoaiPhat = maLoaiPhat;
		this.tenLoai = tenLoai;
		this.tienPhat = tienPhat;
		this.trangThai = trangThai;
	}

	public LoaiPhat(String tenLoai, double tienPhat, int trangThai) {
		super();
		this.tenLoai = tenLoai;
		this.tienPhat = tienPhat;
		this.trangThai = trangThai;
	}

	public int getMaLoaiPhat() {
		return maLoaiPhat;
	}

	public void setMaLoaiPhat(int maLoaiPhat) {
		this.maLoaiPhat = maLoaiPhat;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public double getTienPhat() {
		return tienPhat;
	}

	public void setTienPhat(double tienPhat) {
		this.tienPhat = tienPhat;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public List<ChiTietPhieuPhat> getChiTietPhieuPhats() {
		return chiTietPhieuPhats;
	}

	public void setChiTietPhieuPhats(List<ChiTietPhieuPhat> chiTietPhieuPhats) {
		this.chiTietPhieuPhats = chiTietPhieuPhats;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "LoaiPhat [maLoaiPhat=" + maLoaiPhat + ", tenLoai=" + tenLoai + ", tienPhat=" + tienPhat + ", trangThai="
				+ trangThai + ", chiTietPhieuPhats=" + chiTietPhieuPhats + "]";
	}

}
