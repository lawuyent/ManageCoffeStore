/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ANH KIET
 */
public class login {
    private String manv;
    private String matkhau;
    private String chucvu;

    public login() {
    }

    public login(String manv, String matkhau, String chucvu) {
        this.manv = manv;
        this.matkhau = matkhau;
        this.chucvu = chucvu;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    @Override
    public String toString() {
        return "login{" + "manv=" + manv + ", matkhau=" + matkhau + ", chucvu=" + chucvu + '}';
    }

    
}
