package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Launch the application. Tên: Võ Thị Trà Giang Ngày tạo: 21/08/2022
 */
@Entity
@Table(name="chuc_vu")
public class ChucVu implements Serializable{
	@Id
	@Column(name = "idChucVu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idChucVu;
	@Column(columnDefinition = "nvarchar(255)", nullable = false)
	private String chucVu;
	@Column(nullable = false)
	private int trangThai;
	
	public ChucVu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChucVu(String chucVu, int trangThai) {
		super();
		this.chucVu = chucVu;
		this.trangThai = trangThai;
	}

	public ChucVu(int id, String chucVu, int trangThai) {
		super();
		this.idChucVu = id;
		this.chucVu = chucVu;
		this.trangThai = trangThai;
	}

	public int getId() {
		return idChucVu;
	}

	public void setId(int id) {
		this.idChucVu = id;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "ChucVu [id=" + idChucVu + ", chucVu=" + chucVu + ", trangThai=" + trangThai + "]";
	}
	
	

}
