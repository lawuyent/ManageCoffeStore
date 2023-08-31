/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author TommyPC
 */
public class hoadon {
    private String mahd;
    private String manv;
    private Date ngayxuat;
    private float thanhtien; 

    public hoadon() {
    }

    public hoadon(String mahd, String manv, Date ngayxuat, float thanhtien) {
        this.mahd = mahd;
        this.manv = manv;
        this.ngayxuat = ngayxuat;
        this.thanhtien = thanhtien;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
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
