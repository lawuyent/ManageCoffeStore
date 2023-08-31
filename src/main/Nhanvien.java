/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.NhanvienDAO;
import entity.nhanvien;
import java.sql.Connection;
import java.sql.Date;
import main.XDate;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TommyPC
 */
public class Nhanvien extends javax.swing.JFrame {

    DefaultTableModel model;
    List<nhanvien> list = new ArrayList<>();
    nhanvien nv = new nhanvien();
    NhanvienDAO dao = new NhanvienDAO();
    int row= -1;
    Connection con;
    PreparedStatement pst;

    public Nhanvien() {
        initComponents();
        init();
    }

    public void init() {
        setLocationRelativeTo(null);
        load();
    }

    void load() {
        model = (DefaultTableModel) tblNhanvien.getModel();
        model.setRowCount(0);
        try {
            String id = txtFind.getText();
            list = dao.selectByKeywords(id);
            for(nhanvien nv: list){
                Object[] row = {
                    nv.getManv(),nv.getTennv(),nv.getPhai()?"Nam":"Nữ",nv.getChucvu(),nv.getLuong(),
                    XDate.toString(nv.getNgaysinh(), "yyyy/MM/dd"),nv.getChucvu(),nv.getDiachi(),nv.getEmail()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }
    
    entity.nhanvien getform() {
        entity.nhanvien nv = new entity.nhanvien();
        nv.setManv(txtManv.getText());
        nv.setTennv(txtTennv.getText());
        nv.setPhai(Boolean.parseBoolean(txtGioitinh.getText()));
        nv.setChucvu(txtChucvu.getText());
        nv.setLuong(Integer.valueOf(txtLuong.getText()));
        nv.setNgaysinh(XDate.toDate(txtNgaysinh.getText(),"yyyy/MM/dd"));
        nv.setSdt(Integer.valueOf(txtDienthoai.getText()));
        nv.setDiachi(txtDiachi.getText());
        nv.setEmail(txtEmail.getText());

        return nv;
    }

    void setform(entity.nhanvien nv) {
        txtManv.setText(nv.getManv());
        txtTennv.setText(nv.getTennv());
        txtGioitinh.setText(String.valueOf(nv.getPhai()));
        txtChucvu.setText(nv.getChucvu());
        txtLuong.setText(String.valueOf(nv.getLuong()));
        txtNgaysinh.setText(XDate.toString(nv.getNgaysinh(),"yyyy/MM/dd"));
        txtDienthoai.setText(String.valueOf(nv.getSdt()));
        txtDiachi.setText(nv.getDiachi());
        txtEmail.setText(nv.getEmail());
    }

    void add() {
        nv = getform();
        try {
            dao.insert(nv);
            load();
            clear();
            MsgBox.alert(this, "Thêm thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm thất bại");
        }
    }

    void update() {
        nv = getform();
        try {
            dao.update(nv);
            load();
            clear();
            MsgBox.alert(this, "Cập nhật thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại");
        }
    }

    void delete() {
        String manv = txtManv.getText();
        if (MsgBox.confirm(this, "Bạn thực sự muốn xoá nhân viên này?")) {
            try {
                dao.delete(manv);
                this.load();
                this.clear();
                MsgBox.alert(this, "Xoá thành công");
            } catch (Exception e) {
                e.printStackTrace();
                MsgBox.alert(this, "Xoá thất bại");
            }
        }
    }

    public void clear() {
        setform(nv);
        this.row = -1;
    }
    
    void find(){
        load();
        this.row = -1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanvien = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtManv = new javax.swing.JTextField();
        txtFind = new javax.swing.JTextField();
        txtChucvu = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDiachi = new javax.swing.JTextField();
        btnfind = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTennv = new javax.swing.JTextField();
        txtGioitinh = new javax.swing.JTextField();
        txtNgaysinh = new javax.swing.JTextField();
        txtDienthoai = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        anhnen = new javax.swing.JLabel();

        jDialog1.setTitle("NHÂN VIÊN");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NHÂN VIÊN");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setText("Bảng quản lý nhân viên");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        tblNhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Họ và tên", "Giới tính", "Chức vụ", "Lương", "Ngày sinh", "Số ĐT", "Địa chỉ ", "Email"
            }
        ));
        tblNhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanvien);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 46, 837, 175));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã NV: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 247, 58, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 227, 886, 10));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Chức vụ:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 289, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Lương:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 330, 58, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Email:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 371, 58, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Địa chỉ:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 412, 58, -1));

        txtManv.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtManv, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 244, 191, -1));

        txtFind.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 244, 191, -1));
        getContentPane().add(txtChucvu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 190, -1));

        txtLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 327, 191, -1));

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 368, 191, -1));

        txtDiachi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtDiachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 409, 191, -1));

        btnfind.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnfind.setText("Tìm kiếm");
        btnfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfindActionPerformed(evt);
            }
        });
        getContentPane().add(btnfind, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 243, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Tên NV: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 289, 68, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Giới tính:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 330, 68, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Ngày sinh:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 371, 80, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Điện thoại:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 412, 80, -1));

        txtTennv.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtTennv, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 286, 200, -1));

        txtGioitinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtGioitinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 327, 200, -1));

        txtNgaysinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtNgaysinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 368, 200, -1));

        txtDienthoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtDienthoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 409, 200, -1));

        btnAdd.setBackground(new java.awt.Color(153, 204, 0));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, -1, -1));

        btnRefresh.setBackground(new java.awt.Color(153, 204, 0));
        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRefresh.setText("Làm mới");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, -1, -1));

        btnEdit.setBackground(new java.awt.Color(153, 204, 0));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, -1, -1));

        btnDelete.setBackground(new java.awt.Color(153, 204, 0));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, -1, -1));

        btnClose.setBackground(new java.awt.Color(153, 204, 0));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClose.setText("Đóng");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, -1, -1));

        anhnen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/nennhanvien.jpg"))); // NOI18N
        getContentPane().add(anhnen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
        new Quanlycoffe().setVisible(true);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void tblNhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvienMouseClicked
        row = tblNhanvien.getSelectedRow();
        if(row == -1) return;
        nv = list.get(row);
        setform(nv);
    }//GEN-LAST:event_tblNhanvienMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        add();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfindActionPerformed
//
//        boolean kt = false;
//        model.setRowCount(0);
//        tblNhanvien.setModel(model);
//        if (txtFind.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Nhập mã sách vào");
//            txtFind.requestFocus();
//        }
//        try {
//            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=QLCAFE", "sa", "songlong");
//            Statement st = con.createStatement();
//            String sql = "select * from nhanvien where manv like '%" + txtFind.getText() + "%'";
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                Vector data = new Vector();
//                data.add(rs.getString("Manv"));
//                data.add(rs.getString("Tennv"));
//                data.add(rs.getBoolean("phai"));
//                data.add(rs.getString("Chucvu"));
//                data.add(rs.getInt("Luong"));
//                data.add(rs.getDate("Ngaysinh"));
//                data.add(rs.getInt("sdt"));
//                data.add(rs.getString("diachi"));
//                data.add(rs.getString("email"));
//                model.addRow(data);
//
//                kt = true;
//
//            }
//            tblNhanvien.setModel(model);
//
//            if (rs.isBeforeFirst() == false && kt == false) {
//                JOptionPane.showMessageDialog(this, "Chưa nhập mã nhân viên .");
//            }
//
//        } catch (Exception ex) {
//            System.out.println(ex);
//            JOptionPane.showMessageDialog(this, "Lỗi!");
//        }
                    find();

    }//GEN-LAST:event_btnfindActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nhanvien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anhnen;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnfind;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblNhanvien;
    private javax.swing.JTextField txtChucvu;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtDienthoai;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtGioitinh;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtManv;
    private javax.swing.JTextField txtNgaysinh;
    private javax.swing.JTextField txtTennv;
    // End of variables declaration//GEN-END:variables
}
