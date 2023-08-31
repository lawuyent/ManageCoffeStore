/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class thanhtoan {

    String masp;
    String tensp;
    String loaisp;
    int gia;
    int soluong;
    int thanhtien;

    public thanhtoan() {
    }

    public thanhtoan(String masp, String tensp, String loaisp, int gia, int soluong, int thanhtien) {
        this.masp = masp;
        this.tensp = tensp;
        this.loaisp = loaisp;
        this.gia = gia;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    @Override
    public String toString() {
        return "thanhtoan{" + "masp=" + masp + ", tensp=" + tensp + ", loaisp=" + loaisp + ", gia=" + gia + ", soluong=" + soluong + ", thanhtien=" + thanhtien + '}';
    }
    
    
}
