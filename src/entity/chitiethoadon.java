/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.util.logging.Logger;

/**
 *
 * @author ANH KIET
 */
public class chitiethoadon {

    private String mahd;
    private String masp;
    private String tennv;
    private int soluong;
    private Date ngayxuat;
    private float thanhtien;

    public chitiethoadon() {
    }

    public chitiethoadon(String mahd, String masp, String tennv, int soluong, Date ngayxuat, float thanhtien) {
        this.mahd = mahd;
        this.masp = masp;
        this.tennv = tennv;
        this.soluong = soluong;
        this.ngayxuat = ngayxuat;
        this.thanhtien = thanhtien;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Date getNgayxuat() {
        return ngayxuat;
    }

    public void setNgayxuat(Date ngayxuat) {
        this.ngayxuat = ngayxuat;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }

   
}
