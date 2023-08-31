/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDAO {

      private static String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static   String dburl = "jdbc:sqlserver://localhost:1433;databaseName=QLCAFE ;encrypt=true;trustServerCertificate=true;";
    private static String user = "sa";
    private static String pass = "songlong";
    static{
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static PreparedStatement getStmt(String sql,Object...args) throws SQLException{
        Connection conn = DriverManager.getConnection(dburl,user,pass);
        PreparedStatement stmt = null;
        if(sql.trim().startsWith("{")){ 
            stmt = conn.prepareCall(sql); //PROC
        }else{
            stmt = conn.prepareStatement(sql); //SQL
        }
        for(int i = 0; i<args.length; i++){
            stmt.setObject(i+1, args[i]);
        }
        return stmt;
    }
    
    public static int update(String sql,Object...args) {
        try {
            PreparedStatement stmt = ConnectDAO.getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public static ResultSet query(String sql,Object...args) throws SQLException{
        PreparedStatement stmt = ConnectDAO.getStmt(sql, args);
        return stmt.executeQuery();
    }
    
    public static Object value(String sql,Object...args){
        try {
            ResultSet rs = ConnectDAO.query(sql, args);
            if(rs.next()){
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
            
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }

}
