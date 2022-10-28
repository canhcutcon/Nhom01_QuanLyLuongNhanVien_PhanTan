package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

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
	@Column(name = "ma_nv")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maNV;

	@Column(name = "ten_nv")
	private String tenNV;
	
	private String sdt;
	
	private String cmnd;
	
	@Column(name = "dia_chi")
	private String diaChi;
	
	@Column(name = "ngay_vao_lam",columnDefinition = "datetime")
	private String ngayVaoLam;
	
	@Column(name = "ngay_sinh",columnDefinition = "datetime")
	private String ngaySinh;
	
	@Column(name = "chuc_vu")
	private String chucVu;
	
	@Column(name = "mat_khau")	
	private String matKhau;
	
	@Column(name = "is_admin")
	private Boolean idAdmin;
	
	@Column(name = "hinh_anh")
	private String hinhAnh;
	
	@Column(name = "trang_thai")
	private int trangThai;

	@ManyToOne
	@JoinColumn(name = "ma_pb")
	private PhongBan phongBan;
	
	@ManyToOne
	@JoinColumn(name = "ma_cc")
	private BangChamCong bangChamCong;
	
	@OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
	private List<PhieuPhat> phieuPhats = new ArrayList<PhieuPhat>();
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ma_luong", unique = true)
    private BangLuongNhanVien bangLuongNhanVien;
	
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(int maNV, String tenNV, String sdt, String cmnd, String diaChi, String ngayVaoLam, String ngaySinh,
			String chucVu, String matKhau, Boolean idAdmin, String hinhAnh, int trangThai, PhongBan phongBan,
			BangChamCong bangChamCong, List<PhieuPhat> phieuPhats, BangLuongNhanVien bangLuongNhanVien) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.sdt = sdt;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
		this.ngayVaoLam = ngayVaoLam;
		this.ngaySinh = ngaySinh;
		this.chucVu = chucVu;
		this.matKhau = matKhau;
		this.idAdmin = idAdmin;
		this.hinhAnh = hinhAnh;
		this.trangThai = trangThai;
		this.phongBan = phongBan;
		this.bangChamCong = bangChamCong;
		this.phieuPhats = phieuPhats;
		this.bangLuongNhanVien = bangLuongNhanVien;
	}

	public NhanVien(String tenNV, String sdt, String cmnd, String diaChi, String ngayVaoLam, String ngaySinh,
			String chucVu, String matKhau, Boolean idAdmin, String hinhAnh, int trangThai, PhongBan phongBan) {
		super();
		this.tenNV = tenNV;
		this.sdt = sdt;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
		this.ngayVaoLam = ngayVaoLam;
		this.ngaySinh = ngaySinh;
		this.chucVu = chucVu;
		this.matKhau = matKhau;
		this.idAdmin = idAdmin;
		this.hinhAnh = hinhAnh;
		this.trangThai = trangThai;
		this.phongBan = phongBan;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
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

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public Boolean getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Boolean idAdmin) {
		this.idAdmin = idAdmin;
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

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public BangChamCong getBangChamCong() {
		return bangChamCong;
	}

	public void setBangChamCong(BangChamCong bangChamCong) {
		this.bangChamCong = bangChamCong;
	}

	public List<PhieuPhat> getPhieuPhats() {
		return phieuPhats;
	}

	public void setPhieuPhats(List<PhieuPhat> phieuPhats) {
		this.phieuPhats = phieuPhats;
	}

	public BangLuongNhanVien getBangLuongNhanVien() {
		return bangLuongNhanVien;
	}

	public void setBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) {
		this.bangLuongNhanVien = bangLuongNhanVien;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", sdt=" + sdt + ", cmnd=" + cmnd + ", diaChi=" + diaChi
				+ ", ngayVaoLam=" + ngayVaoLam + ", ngaySinh=" + ngaySinh + ", chucVu=" + chucVu + ", matKhau="
				+ matKhau + ", idAdmin=" + idAdmin + ", hinhAnh=" + hinhAnh + ", trangThai=" + trangThai + ", phongBan="
				+ phongBan + ", bangChamCong=" + bangChamCong + ", phieuPhats=" + phieuPhats + ", bangLuongNhanVien="
				+ bangLuongNhanVien + "]";
	}

	

}
