package main;

import dao.hoadonDAO;
import entity.hoadon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Doanhthu extends javax.swing.JFrame {

    DefaultTableModel model;
    int row;
    hoadon hd = new hoadon();
    hoadonDAO dao = new hoadonDAO();
    List <hoadon> list = new ArrayList<>();

    public Doanhthu() {
        initComponents();
        init();
    }

    void init() {
        setLocationRelativeTo(null);
        load();
    }

    void load() {
        model = (DefaultTableModel) tblHoadon.getModel();
        model.setRowCount(0);
        try {
                String id = txtFind.getText();
                list = dao.selectByKeywords(id);
                for(hoadon hd : list){
                    Object[] row ={
                        hd.getMahd(),hd.getManv(),XDate.toString(hd.getNgayxuat(), "yyyy/MM/dd"),hd.getThanhtien()
                    };
                    model.addRow(row);
                }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void find(){
        load();
        this.row = -1;
    }

    void tong() {
        DecimalFormat x = new DecimalFormat("###,###,###");
        int tong = 0;
        for (int i = 0; i < tblHoadon.getRowCount(); i++) {
            tong += Float.parseFloat(tblHoadon.getValueAt(i, 3).toString());
        }
        txtTongtien.setText(x.format(tong));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        btnTong = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        txtTongtien = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoadon = new javax.swing.JTable();
        anhnen = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DOANH THU");
        setMinimumSize(new java.awt.Dimension(808, 543));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("TỔNG TIỀN :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, 30));

        txtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindActionPerformed(evt);
            }
        });
        getContentPane().add(txtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 280, 30));

        btnExit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExit.setText("Đóng");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 80, 30));

        btnTong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTong.setText("Tổng tiền");
        btnTong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTongActionPerformed(evt);
            }
        });
        getContentPane().add(btnTong, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        btnFind.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnFind.setText("TÌM KIẾM THEO NGÀY:");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        getContentPane().add(btnFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 30));

        txtTongtien.setEditable(false);
        txtTongtien.setBackground(new java.awt.Color(255, 204, 255));
        txtTongtien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTongtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongtienActionPerformed(evt);
            }
        });
        getContentPane().add(txtTongtien, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 260, 30));

        tblHoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mahd", "Manv", "Ngayxuat", "Thanhtien"
            }
        ));
        tblHoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoadon);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 222, 790, 310));

        anhnen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/nendoanhthu.jpg"))); // NOI18N
        getContentPane().add(anhnen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        find();
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        new Quanlycoffe().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void tblHoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoadonMouseClicked

    }//GEN-LAST:event_tblHoadonMouseClicked

    private void txtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindActionPerformed
        // TODO add your handling code here:
        find();
    }//GEN-LAST:event_txtFindActionPerformed

    private void txtTongtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongtienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongtienActionPerformed

    private void btnTongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTongActionPerformed
        // TODO add your handling code here:
        tong();
    }//GEN-LAST:event_btnTongActionPerformed

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
            java.util.logging.Logger.getLogger(Doanhthu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Doanhthu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Doanhthu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Doanhthu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Doanhthu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anhnen;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnTong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHoadon;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtTongtien;
    // End of variables declaration//GEN-END:variables
}
