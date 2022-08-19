package entity;

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
@Table(name="phong_ban")
public class PhongBan {
	
	@Id
	@Column(name="idphong_ban")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPhongBan;
	
	@Column(columnDefinition = "varchar(255)",nullable = false)
	private String tenPhongBan;
	
	@ManyToOne(targetEntity = NhanVien.class)
	@JoinColumn(name = "quanLyPhongBan")
	private NhanVien quanLyPB;
	
	@Column(nullable = true)
	private int trangThai;

	public PhongBan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongBan(int idPhongBan, String tenPhongBan, NhanVien quanLyPB, int trangThai) {
		super();
		this.idPhongBan = idPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.quanLyPB = quanLyPB;
		this.trangThai = trangThai;
	}

	public PhongBan(String tenPhongBan, NhanVien quanLyPB, int trangThai) {
		super();
		this.tenPhongBan = tenPhongBan;
		this.quanLyPB = quanLyPB;
		this.trangThai = trangThai;
	}

	public int getIdPhongBan() {
		return idPhongBan;
	}

	public void setIdPhongBan(int idPhongBan) {
		this.idPhongBan = idPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public NhanVien getQuanLyPB() {
		return quanLyPB;
	}

	public void setQuanLyPB(NhanVien quanLyPB) {
		this.quanLyPB = quanLyPB;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "PhongBan [idPhongBan=" + idPhongBan + ", tenPhongBan=" + tenPhongBan + ", quanLyPB=" + quanLyPB
				+ ", trangThai=" + trangThai + "]";
	}
	
	

}
