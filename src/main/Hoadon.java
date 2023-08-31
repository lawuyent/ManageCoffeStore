/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.sanphamDAO;
import entity.sanpham;
import entity.thanhtoan;
import java.awt.Container;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Hoadon extends javax.swing.JFrame {

    Connection con;
    DefaultTableModel model;
    sanphamDAO spd = new sanphamDAO();
    List<sanpham> list = new ArrayList<sanpham>();
    List<thanhtoan> listS = new ArrayList<thanhtoan>();
    thanhtoan tt = new thanhtoan();
    String masp;
    String tensp;
    String loaisp;
    int gia;
    int soluong;
    int thanhtien;

    public Hoadon() {
        initComponents();
        init();
    }

    void init() {
        setLocationRelativeTo(null);
        loadsp();
//        loadArrayList();
        load();
    }

    public void selectTab(int index) {
        tabs.setSelectedIndex(index);
    }

    void logout() {
        this.dispose();
        new dangnhap().setVisible(true);
    }

    void loadsp() {
        DefaultTableModel model = (DefaultTableModel) tblSanpham.getModel();
        model.setRowCount(0);
        try {
            list = spd.selectAll();
            for (sanpham sp : list) {
                Object[] row = {
                    sp.getMasp(), sp.getTensp(), sp.getLoaisp(), sp.getGia(), sp.getSoluong()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void themsp(String masp, String tensp, String loaisp, int gia, int soluong, int thanhtien) {
        model = (DefaultTableModel) tblHoadon.getModel();
        Object[] o = new Object[6];
        o[0] = masp;
        o[1] = tensp;
        o[2] = loaisp;
        o[3] = XDate.DinhDangTien(gia);
        o[4] = soluong;
        o[5] = XDate.DinhDangTien(thanhtien) + "vnđ";
        model.addRow(o);
    }

    void load() {
        model = (DefaultTableModel) tblHoadon.getModel();
        model.setRowCount(0);
        try {
            List<thanhtoan> listS = new ArrayList<>();
            for (thanhtoan tt : listS) {
                Object[] row = {
                    tt.getMasp(), tt.getTensp(), tt.getLoaisp(), tt.getSoluong(), tt.getGia(), tt.getThanhtien()
                };
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void delete() {
        model = (DefaultTableModel) tblHoadon.getModel();
        try {
            int masp = tblHoadon.getSelectedRow();
            model.removeRow(masp);
            MsgBox.alert(this, "Xóa thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Xóa thất bại");
        }
    }

    void quytaclamviec() {
        String str = "QUY TẮC KHI LÀM VIỆC:";
        str = str + "\n-Luôn đi làm đúng ca, đúng giờ.";
        str = str + "\n-Luôn mang đồng phục khi đi làm.";
        str = str + "\n-Không sử dụng điện thoại nhiều trong khi làm.";
        str = str + "\n-Không được ăn uống tự do khi chưa được sự đồng ý.";
        str = str + "\n-Đăng xuất tài khoản sau khi hết ca. Không nhờ nhân viên khác chấm công giùm.";
        str = str + "\n*Quy tắc quan trọng: Luôn tươi cười trong mọi hoàn cảnh =)))*.";
        JOptionPane.showMessageDialog(null, str, "Quy tắc làm việc.", JOptionPane.INFORMATION_MESSAGE);
    }

    int tongtien;

    void print() {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("hoadon");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(3);
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã sản phẩm");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Tên sản phẩm");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Loại sản phẩm");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Đơn giá");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Số lượng");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Thành tiền");

            for (int i = 0; i < listS.size(); i++) {
                row = sheet.createRow(4 + i);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(listS.get(i).getMasp());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(listS.get(i).getTensp());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(listS.get(i).getLoaisp());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(listS.get(i).getGia());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(listS.get(i).getSoluong());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(listS.get(i).getThanhtien());

            }

            File f = new File("E://Du an 1//File//hoadon.xlsx");
            try {
                FileOutputStream fos = new FileOutputStream(f);
                workbook.write(fos);
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            MsgBox.alert(this, "In thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi đường dẫn! In thất bại");
        }

    }

    void them() {
        try {
            masp = txtmasp.getText();
            tensp = txttensp.getText();
            loaisp = txtloaisp.getText();
            gia = Integer.parseInt(txtgia.getText());
            soluong = Integer.parseInt(txtSoluong.getText());
            thanhtien = soluong * gia;
            themsp(masp, tensp, loaisp, gia, soluong, thanhtien);
            thanhtoan tt = new thanhtoan(masp, tensp, loaisp, gia, soluong, thanhtien);
            MsgBox.alert(this, "Thêm thành công");
            listS.add(tt);
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm thất bại");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnRule = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoadon = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtTennv1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMahd1 = new javax.swing.JTextField();
        btnTaohd = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        anhnen = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanpham = new javax.swing.JTable();
        txtmasp = new javax.swing.JTextField();
        txttensp = new javax.swing.JTextField();
        txtloaisp = new javax.swing.JTextField();
        txtgia = new javax.swing.JTextField();
        txtSoluong = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TẠO HÓA ĐƠN");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRule.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/quytac.jpg"))); // NOI18N
        btnRule.setText("Quy tắc");
        btnRule.setFocusable(false);
        btnRule.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRule.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRuleActionPerformed(evt);
            }
        });
        jPanel1.add(btnRule, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, -1));

        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        btnLogout.setText("Đăng xuất");
        btnLogout.setFocusable(false);
        btnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 100, -1));

        tblHoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Loại sản phẩm", "Giá", "Số lượng", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(tblHoadon);
        if (tblHoadon.getColumnModel().getColumnCount() > 0) {
            tblHoadon.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 710, 170));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 0));
        jLabel9.setText("Tên nhân viên:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 110, 30));
        jPanel1.add(txtTennv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 170, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 0, 0));
        jLabel10.setText("Mã hóa đơn:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 110, 30));

        txtMahd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMahd1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtMahd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 170, 30));

        btnTaohd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTaohd.setForeground(new java.awt.Color(102, 0, 0));
        btnTaohd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/taohoadon.png"))); // NOI18N
        btnTaohd.setText("Tạo hóa đơn");
        btnTaohd.setFocusable(false);
        btnTaohd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTaohd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTaohd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaohdActionPerformed(evt);
            }
        });
        jPanel1.add(btnTaohd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 120, 80));

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(102, 0, 0));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/319637065_605665938230701_4478990957018603732_n.png"))); // NOI18N
        btnXoa.setText("Xóa đơn");
        btnXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXoa.setInheritsPopupMenu(true);
        btnXoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, 110, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/Coffee.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(791, 16, 340, 390));

        anhnen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/nenhoadon.jpg"))); // NOI18N
        jPanel1.add(anhnen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tabs.addTab("HÓA ĐƠN", jPanel1);

        tblSanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Giá "
            }
        ));
        tblSanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanphamMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblSanphamMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanpham);

        txtmasp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txttensp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtloaisp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtgia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgiaActionPerformed(evt);
            }
        });

        txtSoluong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSoluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoluongActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setText("Thêm sản phẩm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel1.setText("MÃ SẢN PHẨM");

        jLabel3.setText("LOẠI SẢN PHẨM");

        jLabel4.setText("GIÁ ");

        jLabel5.setText("TÊN SẢN PHẨM");

        jLabel6.setText("SỐ LƯỢNG");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setText("DANH SÁCH SẢN PHẨM");
        jLabel8.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtloaisp)
                            .addComponent(txtmasp)
                            .addComponent(txttensp, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtgia)
                                .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(316, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmasp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttensp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtloaisp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86))
        );

        tabs.addTab("DANH SÁCH SẢN PHẨM", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRuleActionPerformed
        quytaclamviec();
    }//GEN-LAST:event_btnRuleActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        logout();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void tblSanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanphamMouseClicked
        // TODO add your handling code here:
//        if(evt.getClickCount()==2){
//             masp = tblSanpham.getValueAt(tblSanpham.getSelectedRow(), 0).toString();
//              soluong = Integer.getInteger(tblSanpham.getValueAt(tblSanpham.getSelectedRow(), 4).toString());
//        }

    }//GEN-LAST:event_tblSanphamMouseClicked

    private void txtgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgiaActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        them();
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtSoluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoluongActionPerformed

    private void txtMahd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMahd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMahd1ActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTaohdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaohdActionPerformed
        // TODO add your handling code here:
        print();
    }//GEN-LAST:event_btnTaohdActionPerformed

    private void tblSanphamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanphamMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            txtmasp.setText(tblSanpham.getValueAt(tblSanpham.getSelectedRow(), 0).toString());
            txttensp.setText(tblSanpham.getValueAt(tblSanpham.getSelectedRow(), 1).toString());
            txtloaisp.setText(tblSanpham.getValueAt(tblSanpham.getSelectedRow(), 2).toString());
            txtgia.setText((tblSanpham.getValueAt(tblSanpham.getSelectedRow(), 3).toString()));
        }
    }//GEN-LAST:event_tblSanphamMousePressed

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
            java.util.logging.Logger.getLogger(Hoadon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hoadon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hoadon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hoadon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hoadon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anhnen;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRule;
    private javax.swing.JButton btnTaohd;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblHoadon;
    private javax.swing.JTable tblSanpham;
    private javax.swing.JTextField txtMahd1;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTennv1;
    private javax.swing.JTextField txtgia;
    private javax.swing.JTextField txtloaisp;
    private javax.swing.JTextField txtmasp;
    private javax.swing.JTextField txttensp;
    // End of variables declaration//GEN-END:variables
}
