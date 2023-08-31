/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import connect.ConnectDAO;
import entity.hoadon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TommyPC
 */
public class hoadonDAO extends CoffeeDAO<hoadon, String> {

    String INSERT_SQL = "INSERT INTO QLHOADIEN (mahd, manv, ngayxuat,thanhtien) VALUES (?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE QLHOADON SET mahd=?, ngayxuat=?, thanhtien=?, ngayxuat=? WHERE mahd=?";
    String DELETE_SQL = "DELETE FROM QLHOADON WHERE mahd=?";
    String SELECT_ALL_SQL = "SELECT * FROM QLHOADON";
    String SELECT_BY_ID_SQL = "SELECT * FROM QLHOADON WHERE mahd=?";

    
    @Override
    public void insert(hoadon entity) {
        ConnectDAO.update(INSERT_SQL,
                entity.getMahd(),
                entity.getManv(),
                entity.getNgayxuat(),
                entity.getThanhtien());
    }

    @Override
    public void update(hoadon entity) {
        ConnectDAO.update(UPDATE_SQL,
                entity.getMahd(),
                entity.getManv(),
                entity.getNgayxuat(),
                entity.getThanhtien());
    }

    @Override
    public hoadon selectById(String id) {
        List<hoadon> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<hoadon> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<hoadon> selectBySQL(String sql, Object... args) {
        List<hoadon> list = new ArrayList<>();
        try {
            ResultSet rs = ConnectDAO.query(sql, args);
            while (rs.next()) {
                hoadon entity = new hoadon();
                entity.setMahd(rs.getString("mahd"));
                entity.setManv(rs.getString("manv"));
                entity.setNgayxuat(rs.getDate("ngayxuat"));
                entity.setThanhtien(rs.getFloat("thanhtien"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {
        ConnectDAO.update(DELETE_SQL, id);
    }

     public List<hoadon> selectByKeywords(String id){
        String sql = "SELECT * FROM qlhoadon WHERE ngayxuat LIKE ?";
        return this.selectBySQL(sql, "%"+id+"%");
    }
    
}
