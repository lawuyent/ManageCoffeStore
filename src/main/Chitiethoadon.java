/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.chitiethoadonDAO;
import entity.chitiethoadon;
import main.XDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TommyPC
 */
public class Chitiethoadon extends javax.swing.JFrame {
    
    DefaultTableModel model ;
    int row;
    chitiethoadon hdct = new chitiethoadon();
    chitiethoadonDAO dao = new chitiethoadonDAO();
    List<chitiethoadon> list = new ArrayList<>();

    public Chitiethoadon() {
        initComponents();
        init();
    }

    void init() {
        load();
        setLocationRelativeTo(null);
    }

    void load() {
        model = (DefaultTableModel) tblChitiethoadon.getModel();
        model.setRowCount(0);
        try {
            String id =   txtFind.getText();
            list =  dao.selectByKeywords(id);
            for(chitiethoadon ct : list){
                Object[] row={
                    ct.getMahd(),ct.getMasp(),ct.getTennv(),
                    XDate.toString(ct.getNgayxuat(), "yyyy/MM/dd"),ct.getSoluong(),ct.getThanhtien()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    chitiethoadon getform() {
        hdct.setMahd(txtMahd.getText());
        hdct.setMasp(txtMasp.getText());
        hdct.setTennv(txtTennv.getText());
        hdct.setNgayxuat((Date) XDate.toDate(txtNgay.getText(),"yyyy/MM/dd"));
        hdct.setSoluong(Integer.parseInt(txtSoluong.getText()));
        hdct.setThanhtien(Integer.parseInt(txtThanhtien.getText()));
        return hdct;
    }

    void setform(chitiethoadon hdct) {
        txtMahd.setText(hdct.getMahd());
        txtMasp.setText(hdct.getMasp());
        txtTennv.setText(hdct.getTennv());
        txtNgay.setText(XDate.toString(hdct.getNgayxuat(),"yyyy/MM/dd"));
        txtSoluong.setText(String.valueOf(hdct.getSoluong()));
        txtThanhtien.setText(String.valueOf(hdct.getThanhtien()));
    }

    void clear() {
        setform(hdct);
        this.row = -1;
    }
    
       void find(){
        load();
        this.row = -1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnFind = new javax.swing.JButton();
        txtMahd = new javax.swing.JTextField();
        txtMasp = new javax.swing.JTextField();
        txtTennv = new javax.swing.JTextField();
        txtFind = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNgay = new javax.swing.JTextField();
        txtSoluong = new javax.swing.JTextField();
        txtThanhtien = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChitiethoadon = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        anhnen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHI TIẾT HÓA ĐƠN");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Thông tin tìm kiếm: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 23, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã hóa đơn:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 102, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Mã sản phẩm:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 102, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tên nhân viên:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        btnFind.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFind.setText("Tìm kiếm");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        getContentPane().add(btnFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 102, -1));

        txtMahd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMahd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMahdActionPerformed(evt);
            }
        });
        getContentPane().add(txtMahd, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 176, -1));

        txtMasp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaspActionPerformed(evt);
            }
        });
        getContentPane().add(txtMasp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 176, -1));

        txtTennv.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTennv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTennvActionPerformed(evt);
            }
        });
        getContentPane().add(txtTennv, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 176, -1));

        txtFind.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindActionPerformed(evt);
            }
        });
        getContentPane().add(txtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 250, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Ngày:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 73, 79, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Số lượng:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 114, 79, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Thành tiền:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 155, -1, -1));

        txtNgay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayActionPerformed(evt);
            }
        });
        getContentPane().add(txtNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 70, 176, -1));

        txtSoluong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSoluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoluongActionPerformed(evt);
            }
        });
        getContentPane().add(txtSoluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 111, 176, -1));

        txtThanhtien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtThanhtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhtienActionPerformed(evt);
            }
        });
        getContentPane().add(txtThanhtien, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 152, 176, -1));

        btnExit.setBackground(new java.awt.Color(102, 51, 0));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, -1, -1));

        tblChitiethoadon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblChitiethoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã sản phẩm", "Nhân viên", "Ngày", "Số lượng", "Thành tiền"
            }
        ));
        tblChitiethoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChitiethoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChitiethoadon);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 267, 793, 232));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 251, 890, 10));

        anhnen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/nenchitiet.jpg"))); // NOI18N
        getContentPane().add(anhnen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMahdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMahdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMahdActionPerformed

    private void txtMaspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaspActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaspActionPerformed

    private void txtTennvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTennvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTennvActionPerformed

    private void txtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtFindActionPerformed

    private void txtNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayActionPerformed

    private void txtSoluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoluongActionPerformed

    private void txtThanhtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhtienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThanhtienActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        new Quanlycoffe().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void tblChitiethoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChitiethoadonMouseClicked
        // TODO add your handling code here:
        row = tblChitiethoadon.getSelectedRow();
        if(row == -1) return;
        hdct = list.get(row);
        setform(hdct);

    }//GEN-LAST:event_tblChitiethoadonMouseClicked

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        find();
    }//GEN-LAST:event_btnFindActionPerformed

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
            java.util.logging.Logger.getLogger(Chitiethoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chitiethoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chitiethoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chitiethoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chitiethoadon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anhnen;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblChitiethoadon;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtMahd;
    private javax.swing.JTextField txtMasp;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTennv;
    private javax.swing.JTextField txtThanhtien;
    // End of variables declaration//GEN-END:variables
}
