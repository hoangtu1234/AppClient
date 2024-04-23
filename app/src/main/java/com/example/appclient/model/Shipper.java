package com.example.appclient.model;

import java.io.Serializable;

public class Shipper implements Serializable{

    private long id;
    private String ten;
    private Boolean gioiTinh;
    private String SDT;

    public Shipper() {
    }

    public Shipper(long id, String ten, Boolean gioiTinh, String SDT) {
        this.id = id;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.SDT = SDT;
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

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
}
