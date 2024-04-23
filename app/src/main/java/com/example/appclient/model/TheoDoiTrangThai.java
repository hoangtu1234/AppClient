/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appclient.model;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public class TheoDoiTrangThai {

    private DonHang dh;
    private KhachHang kh;
    private List<MatHang> listMh;
    private Shipper s;
    private List<TTDH> listTtdh;

    public TheoDoiTrangThai() {
    }

    public TheoDoiTrangThai(DonHang dh, KhachHang kh, List<MatHang> listMh, Shipper s, List<TTDH> listTtdh) {
        this.dh = dh;
        this.kh = kh;
        this.listMh = listMh;
        this.s = s;
        this.listTtdh = listTtdh;
    }

    public DonHang getDh() {
        return dh;
    }

    public void setDh(DonHang dh) {
        this.dh = dh;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public List<MatHang> getListMh() {
        return listMh;
    }

    public void setListMh(List<MatHang> listMh) {
        this.listMh = listMh;
    }

    public Shipper getS() {
        return s;
    }

    public void setS(Shipper s) {
        this.s = s;
    }

    public List<TTDH> getListTtdh() {
        return listTtdh;
    }

    public void setListTtdh(List<TTDH> listTtdh) {
        this.listTtdh = listTtdh;
    }



}
