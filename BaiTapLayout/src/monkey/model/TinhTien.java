/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monkey.model;

/**
 *
 * @author Administrator
 */
public class TinhTien {

    private String ma;
    private int soLuong;
    private float giaBan;
    private float tongTien;
    private float chietKhau;
    private String tenSP;

    public TinhTien() {
    }

    public TinhTien(String ma, int soLuong, float giaBan, float tongTien, float chietKhau, String tenSP) {
        this.ma = ma;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.tongTien = tongTien;
        this.chietKhau = chietKhau;
        this.tenSP = tenSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public float getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(float chietKhau) {
        this.chietKhau = chietKhau;
    }

    @Override
    public String toString() {
        return tenSP;
    }

    
}
