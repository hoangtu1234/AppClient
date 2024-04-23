package com.example.appclient.model;

import java.io.Serializable;

public class MatHang implements Serializable{

    private long id;
    private String ten;
    private long gia;
    private int soLuong;
    private String noiBan;
    private long idDonHang;

    public MatHang() {
    }

    public MatHang(long id, String ten, long gia, int soLuong, String noiBan, long idDonHang) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.noiBan = noiBan;
        this.idDonHang = idDonHang;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNoiBan() {
        return noiBan;
    }

    public void setNoiBan(String noiBan) {
        this.noiBan = noiBan;
    }

    public long getIdDonHang() {
        return idDonHang;
    }

    public void setIdDonHang(long idDonHang) {
        this.idDonHang = idDonHang;
    }

}
