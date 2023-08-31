/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import main.XDate;

public class nhanvien {

    private String manv, tennv;
    private Boolean phai;
    private String chucvu;
    private int luong;
    private Date ngaysinh = XDate.addDays(new Date(), -365*20);
    private int sdt;
    private String diachi, email;

    public nhanvien() {
    }

    public nhanvien(String manv, String tennv, Boolean phai, String chucvu, int luong, int sdt, String diachi, String email) {
        this.manv = manv;
        this.tennv = tennv;
        this.phai = phai;
        this.chucvu = chucvu;
        this.luong = luong;
        this.sdt = sdt;
        this.diachi = diachi;
        this.email = email;
    }

  

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public Boolean getPhai() {
        return phai;
    }

    public void setPhai(Boolean phai) {
        this.phai = phai;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
