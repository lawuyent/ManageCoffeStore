/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ngoct
 */
public class sanpham {

    String masp;
    String tensp;
    String loaisp;
    int soluong;
    int gia;

    public sanpham() {
    }

    public sanpham(String masp, String tensp, String loaisp, int soluong, int gia) {
        this.masp = masp;
        this.tensp = tensp;
        this.loaisp = loaisp;
        this.soluong = soluong;
        this.gia = gia;
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

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "sanpham{" + "masp=" + masp + ", tensp=" + tensp + ", loaisp=" + loaisp + ", soluong=" + soluong + ", gia=" + gia + '}';
    }

}
