package com.example.appclient.model;

import java.io.Serializable;
import java.util.Date;

public class DonHang implements Serializable{

    private long id;
    private Date thoiGianDatHang;
    private long tienVanChuyen;
    private long idKhachHang;
    private long idShipper;
    private String maDonHang;

    public DonHang() {
    }

    public DonHang(long id, Date thoiGianDatHang, long tienVanChuyen, int idKhachHang, int idShipper, String maDonHang) {
        this.id = id;
        this.thoiGianDatHang = thoiGianDatHang;
        this.tienVanChuyen = tienVanChuyen;
        this.idKhachHang = idKhachHang;
        this.idShipper = idShipper;
        this.maDonHang = maDonHang;
    }

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getThoiGianDatHang() {
        return thoiGianDatHang;
    }

    public void setThoiGianDatHang(Date thoiGianDatHang) {
        this.thoiGianDatHang = thoiGianDatHang;
    }

    public long getTienVanChuyen() {
        return tienVanChuyen;
    }

    public void setTienVanChuyen(long tienVanChuyen) {
        this.tienVanChuyen = tienVanChuyen;
    }

    public long getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public long getIdShipper() {
        return idShipper;
    }

    public void setIdShipper(int idShipper) {
        this.idShipper = idShipper;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }
    
    
}
