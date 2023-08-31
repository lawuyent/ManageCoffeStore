/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.ConnectDAO;
import entity.login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.Nhanvien;

/**
 *
 * @author ngoct
 */
public class loginDAO extends CoffeeDAO<login, String>{
    String INSERT_SQL = "insert into dangnhap(manv, matkhau, chucvu) values (?,?,?) ";
    String UPDATE_SQL = "update dangnhap set matkhau=?, chucvu=? when manv=? ";
    String DELETE_SQL = "delete from dangnhap when manv=?";
    String SELECTALL_SQL = "Select * from dangnhap";
    String SELECTBYID_SQL = "Select from dangnhap when manv =?";

    @Override
    public void insert(login entity) {
        ConnectDAO.update(INSERT_SQL, entity.getManv(),entity.getMatkhau(),entity.getChucvu());
    }

    @Override
    public void update(login entity) {
       ConnectDAO.update(UPDATE_SQL,entity.getMatkhau(),entity.getChucvu(), entity.getManv());
    }

    @Override
    public void delete(String id) {
       ConnectDAO.update(DELETE_SQL, id);
    }

    @Override
    public login selectById(String id) {
         List<login> list = selectBySQL(SELECTBYID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<login> selectAll() {
        return selectBySQL(SELECTALL_SQL);
    }

    @Override
    protected List<login> selectBySQL(String sql, Object... args) {
         List<login> list = new ArrayList<>();
        try {
            ResultSet rs = ConnectDAO.query(sql, args);
            while (rs.next()) {
                login entity = new login();
                entity.setManv(rs.getString("manv"));
                entity.setMatkhau(rs.getString("matkhau"));
                entity.setChucvu(rs.getString("chucvu"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
