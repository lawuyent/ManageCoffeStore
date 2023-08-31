/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.ConnectDAO;
import entity.nhanvien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author TommyPC
 */
public class NhanvienDAO extends CoffeeDAO<entity.nhanvien, String> {

    java.sql.Date sqlDate;
    String Insert_SQL = "insert into NHANVIEN (manv , tennv, phai, chucvu , luong, ngaysinh , sdt, diachi, email) values(?,?,?,?,?,?,?,?,?)";
    String Update_SQL = "update NHANVIEN set tennv=?, phai=?, chucvu=? , luong=?, ngaysinh=? , sdt=?, diachi=?, email=? where manv=?";
    String Delete_SQL = "delete from NHANVIEN where manv =?";
    String SeleteAll_SQL = "selecet * from NHANVIEN";
    String SelecetByID_SQL = "selecet * from NHANVIEN where manv=?";

    @Override
    public void insert(nhanvien entity) {
        ConnectDAO.update(Insert_SQL, entity.getManv(), entity.getTennv(), entity.getPhai(), entity.getChucvu(), entity.getLuong(), entity.getNgaysinh(), entity.getSdt(), entity.getDiachi(), entity.getEmail());
    }

    public Date convertDate(java.util.Date date) {
        sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }

    @Override
    public void update(nhanvien entity) {
        ConnectDAO.update(Update_SQL, entity.getTennv(), entity.getPhai(), entity.getChucvu(), entity.getLuong(), entity.getNgaysinh(), entity.getSdt(), entity.getDiachi(), entity.getEmail(), entity.getManv());
    }

    @Override
    public void delete(String id) {
        ConnectDAO.update(Delete_SQL, id);
    }

    @Override
    public nhanvien selectById(String id) {
        List<nhanvien> list = this.selectBySQL(SelecetByID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<nhanvien> selectAll() {
        return this.selectBySQL(SeleteAll_SQL);
    }

    @Override
    protected List<nhanvien> selectBySQL(String sql, Object... args) {
        List<nhanvien> list = new ArrayList<>();
        try {
            ResultSet rs = ConnectDAO.query(sql, args);
            while (rs.next()) {
                nhanvien entity = new nhanvien();
                entity.setManv(rs.getString("manv"));
                entity.setTennv(rs.getString("tennv"));
                entity.setPhai(rs.getBoolean("phai"));
                entity.setChucvu(rs.getString("chucvu"));
                entity.setLuong(rs.getInt("luong"));
                entity.setNgaysinh(rs.getDate("ngaysinh"));
                entity.setSdt(rs.getInt("sdt"));
                entity.setDiachi(rs.getString("diachi"));
                entity.setEmail(rs.getString("email"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
     public List<nhanvien> selectByKeywords(String id){
        String sql = "SELECT * FROM nhanvien WHERE manv LIKE ?";
        return this.selectBySQL(sql, "%"+id+"%");
    }
    
    
}
