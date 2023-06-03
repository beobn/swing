/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.GioHang;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import Services.IManageGioHangService;
import Services.IManageKhachHangService;
import Services.IManageNhanVienService;
import Services.ManageGioHangService;
import Services.ManageKhachHangService;
import Services.ManageNhanVienService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cuong
 */
public class FrmQLGioHang extends javax.swing.JFrame {
    IManageKhachHangService _iManageKhachHangService = new ManageKhachHangService();
    IManageNhanVienService _iManageNhanVienService = new ManageNhanVienService();
    IManageGioHangService _iManageService = new ManageGioHangService();
    /**
     * Creates new form FrmQLGioHang
     */
    public FrmQLGioHang() {
        initComponents();
        showFull();
    }
    private void showFull(){
        showKhachHang();
        showNhanVien();
        loadDataToTable();
        clearForm();
    }
    private void showKhachHang(){
        cbbKhachHang.removeAllItems();
        List<KhachHang> ds = _iManageKhachHangService.getAll();
        for (KhachHang d : ds) {
            cbbKhachHang.addItem(d.getTen());
        }     
    }
    private void showNhanVien(){
        cbbNhanVien.removeAllItems();
        List<NhanVien> ds = _iManageNhanVienService.getAll();
        for (NhanVien d : ds) {
            cbbNhanVien.addItem(d.getTen());
        }     
    }
    private void clearForm(){
        cbbKhachHang.setSelectedIndex(0);
        cbbNhanVien.setSelectedIndex(0);
        txtMa.setText("");
        txtTenNguoiNhan.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
    }
    private String getIdFromSelectedRow() {
        int selectedRowIndex = tbGioHang.getSelectedRow();
        return (String) this.tbGioHang.getValueAt(selectedRowIndex, 0);
    }
    private GioHang getFromInput() {
        GioHang x = new GioHang();

        String khachHang = _iManageKhachHangService.getAll().get(cbbKhachHang.getSelectedIndex()).getId();
        String nhanVien = _iManageNhanVienService.getAll().get(cbbNhanVien.getSelectedIndex()).getId();      

        String ma = txtMa.getText();
        String tenNguoiNhan = txtTenNguoiNhan.getText();
        String sdt = txtSDT.getText();
        String diaChi= txtDiaChi.getText();
        
        x.setIdKH(khachHang);
        x.setIdNV(nhanVien);
        x.setMa(ma);
        x.setTenNguoiNhan(tenNguoiNhan);
        x.setSdt(sdt);
        x.setDiaChi(diaChi);

        return x;
    }
    private void loadDataToTable() {
        List<GioHang> ds = _iManageService.getAll();
        DefaultTableModel dtm = (DefaultTableModel) this.tbGioHang.getModel();
        dtm.setRowCount(0);
        for (GioHang x : ds) {
            Object[] rowData = {
                x.getId(),
                checkTen(x.getIdKH(),0),
                checkTen(x.getIdNV(),1),
                x.getMa(),
                x.getTenNguoiNhan(),
               new SimpleDateFormat("dd/MM/yyyy").format(x.getNgayTao()),
               new SimpleDateFormat("dd/MM/yyyy").format(x.getNgayThanhToan()),
                x.getDiaChi(),
                x.getSdt()
            };   
            dtm.addRow(rowData);
        }
        clearForm();
    }
     private String checkTen(String tencheck, Integer index){
        String ten="";
        if(index==0){
            List<KhachHang> ds = _iManageKhachHangService.getAll();
            for (KhachHang d : ds) {
                if(d.getId().equals(tencheck)){
                    ten = d.getTen();
                }
            }
        }else if(index==1){
            List<NhanVien> ds = _iManageNhanVienService.getAll();
            for (NhanVien d : ds) {
                if(d.getId().equals(tencheck)){
                    ten = d.getTen();
                }
            }
        }
        
        return ten;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbbKhachHang = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbbNhanVien = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTenNguoiNhan = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbGioHang = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Quản Lý Giỏ Hàng");

        jLabel2.setText("Khách Hàng");

        cbbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbKhachHangMouseClicked(evt);
            }
        });
        cbbKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKhachHangActionPerformed(evt);
            }
        });

        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nhân Viên");

        cbbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbNhanVienMouseClicked(evt);
            }
        });

        jLabel4.setText("Mã");

        jLabel5.setText("Tên người nhận");

        jLabel6.setText("Địa chỉ");

        jLabel7.setText("SDT");

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tbGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Khách Hàng", "Nhân Viên", "Mã", "Tên người nhận", "Ngày Tạo", "Ngày Thanh Toán", "Địa Chỉ", "SĐT"
            }
        ));
        tbGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGioHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbGioHang);

        jButton6.setText("+");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTenNguoiNhan)
                                        .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                                        .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cbbNhanVien, 0, 288, Short.MAX_VALUE)
                                                .addComponent(cbbKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(txtMa)))))
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTenNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhachHangMouseClicked
        showKhachHang();
    }//GEN-LAST:event_cbbKhachHangMouseClicked

    private void cbbKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhachHangActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new FrmQLKhachHang().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbNhanVienMouseClicked
        showNhanVien();
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNhanVienMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        GioHang newx;

        newx = getFromInput();
        if (_iManageService.create(newx) != null) {
            JOptionPane.showMessageDialog(this, "Thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Thất bại");
        }
        showFull();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        GioHang upDated;
            int selectedRowIndex = tbGioHang.getSelectedRow();
            upDated = getFromInput();
            String updatedid = getIdFromSelectedRow();
            upDated.setId(updatedid);
        try {
            upDated.setNgayTao( new SimpleDateFormat("dd/MM/yyyy").parse((String) this.tbGioHang.getValueAt(selectedRowIndex, 5)));
            upDated.setNgayThanhToan(new SimpleDateFormat("dd/MM/yyyy").parse((String) this.tbGioHang.getValueAt(selectedRowIndex, 6)));

        } catch (ParseException ex) {
            System.out.println("Lo ngay");
        }
            if (_iManageService.update(upDated) != null) {
                JOptionPane.showMessageDialog(this, "Thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Thất bại");
            }
            loadDataToTable();
        

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String selectedId = getIdFromSelectedRow();
        _iManageService.delete(selectedId);
            loadDataToTable();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGioHangMouseClicked
        // TODO add your handling code here:
        int row = this.tbGioHang.getSelectedRow();
        if (row == -1) {
            return;
        }

        String khachHang = this.tbGioHang.getValueAt(row, 1).toString();
        String nhanVien = this.tbGioHang.getValueAt(row, 2).toString();
        String ma = this.tbGioHang.getValueAt(row, 3).toString();
        String tenNguoiNhan = this.tbGioHang.getValueAt(row, 4).toString();
        String diaChi = this.tbGioHang.getValueAt(row, 7).toString();
        String sdt = this.tbGioHang.getValueAt(row, 8).toString();
        
        this.cbbKhachHang.setSelectedItem(khachHang);
        this.cbbNhanVien.setSelectedItem(nhanVien);
        this.txtMa.setText(ma);
        this.txtTenNguoiNhan.setText(tenNguoiNhan);
        this.txtSDT.setText(sdt);
        this.txtDiaChi.setText(diaChi);
    }//GEN-LAST:event_tbGioHangMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmQLGioHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmQLGioHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmQLGioHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmQLGioHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmQLGioHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JComboBox<String> cbbNhanVien;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbGioHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNguoiNhan;
    // End of variables declaration//GEN-END:variables
}