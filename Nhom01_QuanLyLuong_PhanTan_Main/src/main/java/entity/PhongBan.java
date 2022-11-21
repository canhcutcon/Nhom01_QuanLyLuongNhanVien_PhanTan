package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "phong_ban")
public class PhongBan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7942409844739226189L;

	@Id
	@Column(name = "ma_pb")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maPB;

	@Column(name = "ten_pb", columnDefinition = "varchar(255)", nullable = false)
	private String tenPB;

	@Column(name = "trang_thai", nullable = true)
	private int trangThai;

	@OneToMany(mappedBy = "phongBan")
	private List<NhanVien> nhanViens = new ArrayList<NhanVien>();

	public PhongBan() {
		// TODO Auto-generated constructor stub
	}

	public PhongBan(int maPB, String tenPB, int trangThai, List<NhanVien> nhanViens) {
		super();
		this.maPB = maPB;
		this.tenPB = tenPB;
		this.trangThai = trangThai;
		this.nhanViens = nhanViens;
	}

	public PhongBan(String tenPB, int trangThai, List<NhanVien> nhanViens) {
		super();
		this.tenPB = tenPB;
		this.trangThai = trangThai;
		this.nhanViens = nhanViens;
	}

	public PhongBan(int maPB, String tenPB, int trangThai) {
		super();
		this.maPB = maPB;
		this.tenPB = tenPB;
		this.trangThai = trangThai;
	}

	public int getMaPB() {
		return maPB;
	}

	public void setMaPB(int maPB) {
		this.maPB = maPB;
	}

	public String getTenPB() {
		return tenPB;
	}

	public void setTenPB(String tenPB) {
		this.tenPB = tenPB;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public List<NhanVien> getNhanViens() {
		return nhanViens;
	}

	public void setNhanViens(List<NhanVien> nhanViens) {
		this.nhanViens = nhanViens;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PhongBan [maPB=" + maPB + ", tenPB=" + tenPB + ", trangThai=" + trangThai + "]";
	}

}
