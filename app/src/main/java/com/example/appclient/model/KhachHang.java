package com.example.appclient.model;

import java.io.Serializable;

public class KhachHang implements Serializable {

    private long id;
    private String ten;
    private int gioiTinh;
    private String SDT;
    private String token;

    private String email;

    private String pass;

    public KhachHang() {
    }

    public KhachHang(long id, String ten, int gioiTinh, String SDT) {
        this.id = id;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.SDT = SDT;
    }

    public KhachHang(long id, String ten, int gioiTinh, String SDT, String token, String email, String pass) {
        this.id = id;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.SDT = SDT;
        this.token = token;
        this.email = email;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
