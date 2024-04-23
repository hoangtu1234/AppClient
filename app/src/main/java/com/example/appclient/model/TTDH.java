package com.example.appclient.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class TTDH implements Serializable{




	private long id;
    private String dia_diem;
    private Date thoiGianCapNhat;
    private long idDonHang;





    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDia_diem() {
		return dia_diem;
	}
	public void setDia_diem(String dia_diem) {
		this.dia_diem = dia_diem;
	}
	public Date getThoiGianCapNhat() {
		return thoiGianCapNhat;
	}
	public void setThoiGianCapNhat(Date thoiGianCapNhat) {
		this.thoiGianCapNhat = thoiGianCapNhat;
	}
	public long getIdDonHang() {
		return idDonHang;
	}
	public void setIdDonHang(long idDonHang) {
		this.idDonHang = idDonHang;
	}
}
