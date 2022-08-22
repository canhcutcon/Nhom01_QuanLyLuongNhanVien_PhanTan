package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "muc_tien_phat")
public class MucPhat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMucPhat;
	@Column(columnDefinition = "varchar(255) not null")
	private String tenMucPhat;
	@Column(columnDefinition = "double not null")
	private double tienPhat;
	@Column(columnDefinition = "int", nullable = false)
	private int trangThai;
	
	public MucPhat() {
		super();
	}

	public MucPhat(int idMucPhat, String tenMucPhat, double tienPhat, int trangThai) {
		super();
		this.idMucPhat = idMucPhat;
		this.tenMucPhat = tenMucPhat;
		this.tienPhat = tienPhat;
		this.trangThai = trangThai;
	}
	
	public MucPhat(String tenMucPhat, double tienPhat, int trangThai) {
		super();
		this.tenMucPhat = tenMucPhat;
		this.tienPhat = tienPhat;
		this.trangThai = trangThai;
	}

	public int getIdMucPhat() {
		return idMucPhat;
	}

	public void setIdMucPhat(int idMucPhat) {
		this.idMucPhat = idMucPhat;
	}

	public String getTenMucPhat() {
		return tenMucPhat;
	}

	public void setTenMucPhat(String tenMucPhat) {
		this.tenMucPhat = tenMucPhat;
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

	@Override
	public String toString() {
		return "MucPhat [idMucPhat=" + idMucPhat + ", tenMucPhat=" + tenMucPhat + ", tienPhat=" + tienPhat
				+ ", trangThai=" + trangThai + "]";
	}


}
