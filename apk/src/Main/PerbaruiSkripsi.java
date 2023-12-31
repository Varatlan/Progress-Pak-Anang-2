/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RIGISEFA
 */
public class PerbaruiSkripsi extends javax.swing.JPanel {

    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }
    ArrayList<Test> dataTest;

    private int masukkanData(Connection conn, String judul, String pengarang, String tahun, String halaman) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("INSERT INTO SKRIPSI (judul,pengarang,tahun,halaman) VALUES(?,?,?,?)");
        pst.setString(1, judul);
        pst.setString(2, pengarang);
        pst.setString(3, tahun);
        pst.setString(4, halaman);
        return pst.executeUpdate();
    }
    
    private int editData(Connection conn, String judul, String pengarang, String tahun, String halaman) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("UPDATE SKRIPSI set pengarang = ?,tahun = ?,halaman = ?,where judul = ? ");
        pst.setString(4, judul);
        pst.setString(1, pengarang);
        pst.setString(2, tahun);
        pst.setString(3, halaman);
        return pst.executeUpdate();
    }
    
    private int hapusData(Connection conn, String isbn) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("DELETE From SKRIPSI where isbn = ? ");
        pst.setString(1, isbn);
        return pst.executeUpdate();
    }

    private void Tampil(Connection conn) {
        dataTest.clear();
        try {
            String sql = "select * from skripsi";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Test data = new Test();
                data.setJudul(String.valueOf(rs.getObject(1)));
                data.setPengarang(String.valueOf(rs.getObject(2)));
                data.setTahun(String.valueOf(rs.getObject(3)));
                data.setHalaman(String.valueOf(rs.getObject(4)));
                dataTest.add(data);
            }
            DefaultTableModel model = (DefaultTableModel) jTableSkripsi.getModel();
            model.setRowCount(0);
            for (Test data : dataTest) {

                Object[] baris = new Object[4];
                baris[0] = data.getJudul();
                baris[1] = data.getPengarang();
                baris[2] = data.getTahun();
                baris[3] = data.getHalaman();

                model.addRow(baris);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerbaruiSkripsi.class.getName()).log(Level.SEVERE, null, ex);
        }
        SkripsiJudul.setText("");
        SkripsiPengarang.setText("");
        SkripsiTahun.setText("");
        SkripsiHalaman.setText("");
    }
    
    /**
     * Creates new form PerbaruiSkripsi
     */
    public PerbaruiSkripsi() {
        try {
            dataTest = new ArrayList<>();
            initComponents();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Akhir", "postgres", "bajumuslim");
            Tampil(conn);
        } catch (SQLException ex) {
            Logger.getLogger(Buku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SkripsiJudul = new javax.swing.JTextField();
        SkripsiPengarang = new javax.swing.JTextField();
        SkripsiTahun = new javax.swing.JTextField();
        SkripsiHalaman = new javax.swing.JTextField();
        SkripsiDelete = new javax.swing.JButton();
        SkripsiEdit = new javax.swing.JButton();
        SkripsiInsert = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(153, 102, 0));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Perbarui Skripsi");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel2.setText("judul");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setText("pengarang");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel4.setText("tahun");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel5.setText("halaman");

        SkripsiDelete.setText("Delete");

        SkripsiEdit.setText("Edit");

        SkripsiInsert.setText("Insert");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SkripsiJudul, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(SkripsiPengarang)
                            .addComponent(SkripsiTahun)
                            .addComponent(SkripsiHalaman))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SkripsiDelete, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SkripsiEdit, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SkripsiInsert, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(20, 20, 20)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(SkripsiJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(SkripsiPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SkripsiInsert))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(SkripsiTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SkripsiEdit))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(SkripsiHalaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SkripsiDelete))
                .addContainerGap(154, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SkripsiDelete;
    private javax.swing.JButton SkripsiEdit;
    private javax.swing.JTextField SkripsiHalaman;
    private javax.swing.JButton SkripsiInsert;
    private javax.swing.JTextField SkripsiJudul;
    private javax.swing.JTextField SkripsiPengarang;
    private javax.swing.JTextField SkripsiTahun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
