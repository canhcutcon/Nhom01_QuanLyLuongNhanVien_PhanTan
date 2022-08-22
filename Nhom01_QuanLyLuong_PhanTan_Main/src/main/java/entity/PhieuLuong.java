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
@Table(name = "phieu_luong")

public class PhieuLuong implements Serializable {

	private static final long serialVersionUID = 2306174430773041680L;
	@Id
	@Column(name = "idphieu_luong")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idphieuLuong;
	
	@ManyToOne(targetEntity = NhanVien.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "maNhanVien")
	private NhanVien idNhanVien;
	@Column(nullable = false)
	private String ngayNhan;
	@Column(nullable = false)
	private double tongLuongThucNhan;
	@Column(nullable = false)
	private int trangThai;
	public int getIdphieuLuong() {
		return idphieuLuong;
	}
	public void setIdphieuLuong(int idphieuLuong) {
		this.idphieuLuong = idphieuLuong;
	}
	public NhanVien getIdNhanVien() {
		return idNhanVien;
	}
	public void setIdNhanVien(NhanVien idNhanVien) {
		this.idNhanVien = idNhanVien;
	}
	public String getNgayNhan() {
		// TODO Auto-generated method stub
			return ngayNhan;
	}
	public void setNgayNhan(String ngayNhan) {
		this.ngayNhan = ngayNhan;
	}
	public double getTongLuongThucNhan() {
		return tongLuongThucNhan;
	}
	public void setTongLuongThucNhan(double tongLuongThucNhan) {
		this.tongLuongThucNhan = tongLuongThucNhan;
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
	public PhieuLuong(int idphieuLuong, NhanVien idNhanVien, String ngayNhan, double tongLuongThucNhan, int trangThai) {
		super();
		this.idphieuLuong = idphieuLuong;
		this.idNhanVien = idNhanVien;
		this.ngayNhan = ngayNhan;
		this.tongLuongThucNhan = tongLuongThucNhan;
		this.trangThai = trangThai;
	}
	public PhieuLuong(NhanVien idNhanVien, String ngayNhan, double tongLuongThucNhan, int trangThai) {
		super();
		this.idNhanVien = idNhanVien;
		this.ngayNhan = ngayNhan;
		this.tongLuongThucNhan = tongLuongThucNhan;
		this.trangThai = trangThai;
	}
	public PhieuLuong() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PhieuLuong [idphieuLuong=" + idphieuLuong + ", idNhanVien=" + idNhanVien + ", ngayNhan=" + ngayNhan
				+ ", tongLuongThucNhan=" + tongLuongThucNhan + ", trangThai=" + trangThai + "]";
	}
	
	
	
	
}
