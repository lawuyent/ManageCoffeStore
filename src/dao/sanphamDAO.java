/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import connect.ConnectDAO;
import entity.sanpham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngoct
 */
public class sanphamDAO extends CoffeeDAO<sanpham, String>{
    
    String INSERT_SQL = "INSERT INTO SANPHAM (masp, tensp, loaisp, soluong, gia) VALUES (?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE SANPHAM SET tensp=?,loaisp=?, soluong=?, gia=? WHERE masp=?";
    String DELETE_SQL = "DELETE FROM SANPHAM WHERE masp=?";
    String SELECT_ALL_SQL = "SELECT * FROM SANPHAM";
    String SELECT_BY_ID_SQL = "SELECT * FROM SANPHAM WHERE masp=?";
    

    
    @Override
    public void insert(sanpham entity) {
       ConnectDAO.update(INSERT_SQL,
                entity.getMasp(),
                entity.getTensp(),
                entity.getLoaisp(),
                entity.getSoluong(),
                entity.getGia());
    }

    @Override
    public void update(sanpham entity) {
        ConnectDAO.update(UPDATE_SQL,
                entity.getTensp(),
                entity.getLoaisp(),
                entity.getSoluong(),
                entity.getGia(),
                entity.getMasp());
    }

    @Override
    public void delete(String id) {
        ConnectDAO.update(DELETE_SQL, id);
    }

    @Override
    public sanpham selectById(String id) {
        List<sanpham> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    @Override
    public List<sanpham> selectAll() {     
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<sanpham> selectBySQL(String sql, Object... args) {
        List<sanpham> list = new ArrayList<sanpham>();
        try {
            ResultSet rs = ConnectDAO.query(sql, args);
            while (rs.next()) {
                sanpham entity = new sanpham();
                entity.setMasp(rs.getString("masp"));
                entity.setTensp(rs.getString("tensp"));
                entity.setLoaisp(rs.getString("loaisp"));
                entity.setSoluong(rs.getInt("soluong"));
                entity.setGia(rs.getInt("gia"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

   