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

	@ManyToOne
	@JoinColumn(name = "ma_nv")
	private NhanVien maNV;

	@Column(name = "ngay_phat", columnDefinition = "datetime")
	private LocalDate ngayPhat;

	@Column(name = "trang_thai")
	private int trangThai;

	@ManyToOne
	@JoinColumn(name = "ma_muc_phat")
	private LoaiPhat loaiPhat;

	public PhieuPhat() {
		// TODO Auto-generated constructor stub
	}

	public PhieuPhat( NhanVien maNV, LocalDate ngayPhat, int trangThai, LoaiPhat loaiPhat) {
		super();
		this.maNV = maNV;
		this.ngayPhat = ngayPhat;
		this.trangThai = trangThai;
		this.loaiPhat = loaiPhat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loaiPhat == null) ? 0 : loaiPhat.hashCode());
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
		result = prime * result + maPhieuPhat;
		result = prime * result + ((ngayPhat == null) ? 0 : ngayPhat.hashCode());
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
		PhieuPhat other = (PhieuPhat) obj;
		if (loaiPhat == null) {
			if (other.loaiPhat != null)
				return false;
		} else if (!loaiPhat.equals(other.loaiPhat))
			return false;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equals(other.maNV))
			return false;
		if (maPhieuPhat != other.maPhieuPhat)
			return false;
		if (ngayPhat == null) {
			if (other.ngayPhat != null)
				return false;
		} else if (!ngayPhat.equals(other.ngayPhat))
			return false;
		if (trangThai != other.trangThai)
			return false;
		return true;
	}

	public int getMaPhieuPhat() {
		return maPhieuPhat;
	}

	public void setMaPhieuPhat(int maPhieuPhat) {
		this.maPhieuPhat = maPhieuPhat;
	}

	public NhanVien getMaNV() {
		return maNV;
	}

	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
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

	public LoaiPhat getLoaiPhat() {
		return loaiPhat;
	}

	public void setLoaiPhats(LoaiPhat loaiPhat) {
		this.loaiPhat = loaiPhat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
