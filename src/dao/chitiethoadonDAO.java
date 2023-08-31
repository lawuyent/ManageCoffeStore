/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.ConnectDAO;
import entity.chitiethoadon;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class chitiethoadonDAO extends CoffeeDAO<chitiethoadon, String> {

    String INSERT_SQL = "INSERT INTO CHITIETHOADON (mahd, masp, ngayxuat, soluong, tennv, thanhtien) VALUES ( ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE CHITIETHOADON SET masp=?, ngayxuat=?, soluong=?, tennv=?, thanhtien=? WHERE mahd=?";
    String DELETE_SQL = "DELETE FROM CHITIETHOADON WHERE mahd=?";
    String SELECT_ALL_SQL = "SELECT * FROM CHITIETHOADON";
    String SELECT_BY_ID_SQL = "SELECT * FROM CHITIETHOADON WHERE mahd=?";

    @Override
    public void insert(chitiethoadon entity) {
        ConnectDAO.update(INSERT_SQL,
                entity.getMahd(),
                entity.getMasp(),
                entity.getNgayxuat(),
                entity.getSoluong(),
                entity.getTennv(),
                entity.getThanhtien());
    }

    @Override
    public void update(chitiethoadon entity) {
        ConnectDAO.update(INSERT_SQL,
                entity.getMasp(),
                entity.getNgayxuat(),
                entity.getSoluong(),
                entity.getTennv(),
                entity.getThanhtien(),
                entity.getMahd());
                }

    @Override
    public void delete(String id) {
        ConnectDAO.update(DELETE_SQL, id);
    }

    @Override
    public chitiethoadon selectById(String id) {
        List<chitiethoadon> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<chitiethoadon> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<chitiethoadon> selectBySQL(String sql, Object... args) {
        List<chitiethoadon> list = new ArrayList<>();
        try {
            ResultSet rs = ConnectDAO.query(sql, args);
            while (rs.next()) {
                chitiethoadon entity = new chitiethoadon();
                entity.setMahd(rs.getString("mahd"));
                entity.setMasp(rs.getString("masp"));
                entity.setNgayxuat(rs.getDate("ngayxuat"));
                entity.setSoluong(rs.getInt("soluong"));
                entity.setTennv(rs.getString("tennv"));
                entity.setThanhtien(rs.getFloat("thanhtien"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<chitiethoadon> selectByKeywords(String id) {
        String sql = "SELECT * FROM chitiethoadon WHERE mahd LIKE ?";
        return this.selectBySQL(sql, "%" + id + "%");
    }

}
