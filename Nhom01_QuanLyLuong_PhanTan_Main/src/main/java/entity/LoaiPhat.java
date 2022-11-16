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
@Table(name = "muc_tien_phat")
public class LoaiPhat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2126773171731199974L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maLoaiPhat;

	@Column(name = "ten_muc_phat", columnDefinition = "varchar(255) not null")
	private String tenLoai;

	@Column(name = "tien_phat", columnDefinition = "double not null")
	private double tienPhat;

	@Column(name = "trang_thai", nullable = false)
	private int trangThai;

	
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
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maLoaiPhat;
		result = prime * result + ((tenLoai == null) ? 0 : tenLoai.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tienPhat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		LoaiPhat other = (LoaiPhat) obj;
		if (maLoaiPhat != other.maLoaiPhat)
			return false;
		if (tenLoai == null) {
			if (other.tenLoai != null)
				return false;
		} else if (!tenLoai.equals(other.tenLoai))
			return false;
		if (Double.doubleToLongBits(tienPhat) != Double.doubleToLongBits(other.tienPhat))
			return false;
		if (trangThai != other.trangThai)
			return false;
		return true;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
