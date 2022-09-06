package entity;

import java.beans.Transient;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * Launch the application. Tên: Võ Thị Trà Giang Ngày tạo: 21/08/2022
 */
@Entity
@Table(name = "nhan_vien")
public class NhanVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2383884828589610531L;
	@Id
	@Column(name = "idNhanVien")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNhanVien;
	@Column(columnDefinition = "nvarchar(255)", nullable = false)
	private String hoTen;
	@Column(columnDefinition = "nvarchar(255)", nullable = true)
	private String sdt;
	@Column(columnDefinition = "nvarchar(15)", nullable = false)
	private String cmnd;
	@Column(columnDefinition = "nvarchar(15)", nullable = true)
	private String diaChi;
	@Column(columnDefinition = "nvarchar(255)", nullable = false)
	private String ngayVaoLam;
	@Column(columnDefinition = "nvarchar(20)", nullable = false)
	private String ngaySinh;

//	@OneToOne(targetEntity = ChucVu.class)
//	@JoinColumn(name="idChucVu")

	@ManyToOne(targetEntity = ChucVu.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "idChucVu")
	private ChucVu chucVu;
	
	@ManyToOne(targetEntity = PhongBan.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "idPhongBan")
	private PhongBan phongBan;

	@Column(columnDefinition = "nvarchar(255)", nullable = true)
	private String matKhau;
	@Column(columnDefinition = "nvarchar(255)", nullable = true)
	private String hinhAnh;
	@Column(nullable = false)
	private int trangThai;

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public NhanVien(String hoTen, String sdt, String cmnd, String diaChi, String ngayVaoLam, String ngaySinh,
			ChucVu chucVu, PhongBan phongBan, String matKhau, String hinhAnh, int trangThai) {
		super();
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
		this.ngayVaoLam = ngayVaoLam;
		this.ngaySinh = ngaySinh;
		this.chucVu = chucVu;
		this.phongBan = phongBan;
		this.matKhau = matKhau;
		this.hinhAnh = hinhAnh;
		this.trangThai = trangThai;
	}


	public NhanVien(String hoTen, String sdt, String cmnd, String diaChi, String ngayVaoLam, String ngaySinh,
			ChucVu chucVu, String matKhau, String hinhAnh, int trangThai) {
		super();
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
		this.ngayVaoLam = ngayVaoLam;
		this.ngaySinh = ngaySinh;
		this.chucVu = chucVu;
		this.matKhau = matKhau;
		this.hinhAnh = hinhAnh;
		this.trangThai = trangThai;
	}

	public NhanVien(int id, String hoTen, String sdt, String cmnd, String diaChi, String ngayVaoLam, String ngaySinh,
			ChucVu chucVu, String matKhau, String hinhAnh, int trangThai) {
		super();
		this.idNhanVien = id;
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
		this.ngayVaoLam = ngayVaoLam;
		this.ngaySinh = ngaySinh;
		this.chucVu = chucVu;
		this.matKhau = matKhau;
		this.hinhAnh = hinhAnh;
		this.trangThai = trangThai;
	}

	public int getId() {
		return idNhanVien;
	}

	public void setId(int id) {
		this.idNhanVien = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(String ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public ChucVu getChucVu() {
		return chucVu;
	}

	public void setChucVu(ChucVu chucVu) {
		this.chucVu = chucVu;
	}
	
	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "NhanVien [id=" + idNhanVien + ", hoTen=" + hoTen + ", sdt=" + sdt + ", cmnd=" + cmnd + ", diaChi="
				+ diaChi + ", ngayVaoLam=" + ngayVaoLam + ", ngaySinh=" + ngaySinh + ", chucVu=" + chucVu + ", matKhau="
				+ matKhau + ", hinhAnh=" + hinhAnh + ", trangThai=" + trangThai + "]";
	}

}
