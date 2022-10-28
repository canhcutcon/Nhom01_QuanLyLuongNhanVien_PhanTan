package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "phieu_phat")
public class PhieuPhat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2069455673500480424L;

	@Id
	@Column(name = "ma_phieu_phat")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maPhieuPhat;

	@Column(name = "ngay_phat", columnDefinition = "datetime")
	private LocalDate ngayPhat;

	@Column(name = "trang_thai")
	private int trangThai;

	@Column(name = "tong_tien_phat")
	private double tongTienPhat;

	@ManyToOne
	@JoinColumn(name = "ma_nv")
	private NhanVien nhanVien;

	@OneToMany(mappedBy = "phieuPhat", cascade = CascadeType.ALL)
	private List<ChiTietPhieuPhat> chiTietPhieuPhats = new ArrayList<ChiTietPhieuPhat>();

	public PhieuPhat() {
		// TODO Auto-generated constructor stub
	}

	public PhieuPhat(int maPhieuPhat, LocalDate ngayPhat, int trangThai, double tongTienPhat, NhanVien nhanVien,
			List<ChiTietPhieuPhat> chiTietPhieuPhats) {
		super();
		this.maPhieuPhat = maPhieuPhat;
		this.ngayPhat = ngayPhat;
		this.trangThai = trangThai;
		this.tongTienPhat = tongTienPhat;
		this.nhanVien = nhanVien;
		this.chiTietPhieuPhats = chiTietPhieuPhats;
	}

	public PhieuPhat(LocalDate ngayPhat, int trangThai, double tongTienPhat, NhanVien nhanVien) {
		super();
		this.ngayPhat = ngayPhat;
		this.trangThai = trangThai;
		this.tongTienPhat = tongTienPhat;
		this.nhanVien = nhanVien;
	}

	public int getMaPhieuPhat() {
		return maPhieuPhat;
	}

	public void setMaPhieuPhat(int maPhieuPhat) {
		this.maPhieuPhat = maPhieuPhat;
	}

	public LocalDate getNgayPhat() {
		return ngayPhat;
	}

	public void setNgayPhat(LocalDate ngayPhat) {
		this.ngayPhat = ngayPhat;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public double getTongTienPhat() {
		return tongTienPhat;
	}

	public void setTongTienPhat(double tongTienPhat) {
		this.tongTienPhat = tongTienPhat;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
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
		return "PhieuPhat [maPhieuPhat=" + maPhieuPhat + ", ngayPhat=" + ngayPhat + ", trangThai=" + trangThai
				+ ", tongTienPhat=" + tongTienPhat + ", nhanVien=" + nhanVien + ", chiTietPhieuPhats="
				+ chiTietPhieuPhats + "]";
	}

}
