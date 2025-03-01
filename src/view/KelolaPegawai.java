package view;

import controller.PegawaiController;
import model.Pegawai;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import view.MainMenu;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;

public class KelolaPegawai extends javax.swing.JFrame {

    private PegawaiController pegawaiController;

    public KelolaPegawai() {
        initComponents();
        pegawaiController = new PegawaiController();
        loadTablePegawai();

        // Tambahkan listener untuk menangani klik pada tabel
        tblPegawai.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                fillFormFromTable();
            }
        });
    }

    private void fillFormFromTable() {
        int selectedRow = tblPegawai.getSelectedRow();
        if (selectedRow >= 0) {
            // Ambil data dari tabel
            int idPegawai = (int) tblPegawai.getValueAt(selectedRow, 0);
            String namaPegawai = (String) tblPegawai.getValueAt(selectedRow, 1);
            String jabatan = (String) tblPegawai.getValueAt(selectedRow, 2);
            String gaji = tblPegawai.getValueAt(selectedRow, 3).toString();

            // Isi data ke TextField
            txtIdPegawai.setText(String.valueOf(idPegawai));
            txtNamaPegawai.setText(namaPegawai);
            txtJabatan.setText(jabatan);
            txtGaji.setText(gaji);
        }
    }

    private void loadTablePegawai() {
        DefaultTableModel model = (DefaultTableModel) tblPegawai.getModel();
        model.setRowCount(0);

        List<Pegawai> pegawaiList = pegawaiController.getAllPegawai();
        for (Pegawai pegawai : pegawaiList) {
            Object[] row = {
                pegawai.getIdPegawai(),
                pegawai.getNamaPegawai(),
                pegawai.getJabatan(),
                String.format("%.2f", pegawai.getGaji()) // Format gaji menjadi 2 desimal
            };
            model.addRow(row);
        }
    }

    private void resetForm() {
        txtIdPegawai.setText("");
        txtNamaPegawai.setText("");
        txtJabatan.setText("");
        txtGaji.setText("");
        tblPegawai.clearSelection(); // Kosongkan seleksi di tabel
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnResetPegawai = new javax.swing.JButton();
        btnTambahPegawai = new javax.swing.JButton();
        btnHapusPegawai = new javax.swing.JButton();
        btnUbahPegawai = new javax.swing.JButton();
        txtGaji = new javax.swing.JTextField();
        txtIdPegawai = new javax.swing.JTextField();
        txtJabatan = new javax.swing.JTextField();
        txtNamaPegawai = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPegawai = new javax.swing.JTable();
        btnKembali = new javax.swing.JButton();
        btnReportPegawai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("KELOLA DATA PEGAWAI");

        jLabel2.setText("NIP Pegawai");

        jLabel3.setText("Gaji");

        jLabel4.setText("Jabatan");

        jLabel5.setText("Nama Pegawai");

        btnResetPegawai.setText("Reset Data");
        btnResetPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPegawaiActionPerformed(evt);
            }
        });

        btnTambahPegawai.setText("Tambah Data");
        btnTambahPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahPegawaiActionPerformed(evt);
            }
        });

        btnHapusPegawai.setText("Hapus Data");
        btnHapusPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusPegawaiActionPerformed(evt);
            }
        });

        btnUbahPegawai.setText("Ubah Data");
        btnUbahPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahPegawaiActionPerformed(evt);
            }
        });

        txtIdPegawai.setEditable(false);

        tblPegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Pegawao", "Nama Pegawai", "Jabatan", "Gaji"
            }
        ));
        jScrollPane1.setViewportView(tblPegawai);

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnReportPegawai.setText("Report");
        btnReportPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportPegawaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(89, 89, 89)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnTambahPegawai)
                                .addGap(18, 18, 18)
                                .addComponent(btnUbahPegawai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHapusPegawai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnResetPegawai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnKembali)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReportPegawai))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtIdPegawai, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                                .addComponent(txtNamaPegawai)
                                .addComponent(txtJabatan)
                                .addComponent(txtGaji))))
                    .addComponent(jLabel1))
                .addGap(0, 100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIdPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNamaPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResetPegawai)
                    .addComponent(btnTambahPegawai)
                    .addComponent(btnHapusPegawai)
                    .addComponent(btnUbahPegawai)
                    .addComponent(btnKembali)
                    .addComponent(btnReportPegawai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahPegawaiActionPerformed
        try {
            String nama = txtNamaPegawai.getText();
            String jabatan = txtJabatan.getText();
            double gaji = Double.parseDouble(txtGaji.getText()); // Validasi angka

            // Membuat objek Pegawai dan menyimpan ke database
            Pegawai pegawai = new Pegawai(0, nama, jabatan, gaji);
            pegawaiController.addPegawai(pegawai);

            // Refresh tabel dan reset form
            loadTablePegawai();
            resetForm();

            // Menampilkan notifikasi pop-up
            JOptionPane.showMessageDialog(this, "Data pegawai berhasil ditambahkan!",
                    "Sukses", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Gaji harus berupa angka!",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menambahkan data!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTambahPegawaiActionPerformed

    private void btnUbahPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahPegawaiActionPerformed
        try {
            int selectedRow = tblPegawai.getSelectedRow();
            if (selectedRow >= 0) {
                int idPegawai = (int) tblPegawai.getValueAt(selectedRow, 0);
                String nama = txtNamaPegawai.getText();
                String jabatan = txtJabatan.getText();
                double gaji = Double.parseDouble(txtGaji.getText());

                Pegawai pegawai = new Pegawai(idPegawai, nama, jabatan, gaji);
                pegawaiController.updatePegawai(pegawai);

                loadTablePegawai();
                resetForm();

                // Notifikasi pop-up
                JOptionPane.showMessageDialog(this, "Data pegawai berhasil diubah!",
                        "Sukses", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Gaji harus berupa angka!",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengubah data!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUbahPegawaiActionPerformed

    private void btnHapusPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusPegawaiActionPerformed
        try {
            int selectedRow = tblPegawai.getSelectedRow();
            if (selectedRow >= 0) {
                int idPegawai = (int) tblPegawai.getValueAt(selectedRow, 0);
                pegawaiController.deletePegawai(idPegawai);

                loadTablePegawai();
                resetForm();

                // Notifikasi pop-up
                JOptionPane.showMessageDialog(this, "Data pegawai berhasil dihapus!",
                        "Sukses", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnHapusPegawaiActionPerformed

    private void btnResetPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPegawaiActionPerformed
        resetForm();
    }//GEN-LAST:event_btnResetPegawaiActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // Membuka form MainMenu
        new MainMenu().setVisible(true);

        // Menutup form KelolaPegawai
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnReportPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportPegawaiActionPerformed
        try {
            // Lokasi file PDF
            String fileName = "Laporan_Pegawai.pdf";

            // Membuat dokumen PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName));

            // Membuka dokumen
            document.open();

            // Menambahkan judul laporan
            document.add(new Paragraph("Laporan Data Pegawai", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
            document.add(new Paragraph(" "));

            // Membuat tabel PDF
            PdfPTable table = new PdfPTable(4); // 4 kolom
            table.setWidthPercentage(100);
            table.addCell("ID Pegawai");
            table.addCell("Nama Pegawai");
            table.addCell("Jabatan");
            table.addCell("Gaji");

            // Ambil data dari tabel GUI
            DefaultTableModel model = (DefaultTableModel) tblPegawai.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                table.addCell(model.getValueAt(i, 0).toString());
                table.addCell(model.getValueAt(i, 1).toString());
                table.addCell(model.getValueAt(i, 2).toString());
                table.addCell(model.getValueAt(i, 3).toString());
            }

            // Tambahkan tabel ke dokumen
            document.add(table);

            // Menutup dokumen
            document.close();

            // Notifikasi sukses
            JOptionPane.showMessageDialog(this, "Laporan berhasil disimpan di file " + fileName, "Sukses", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat membuat laporan!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnReportPegawaiActionPerformed

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
            java.util.logging.Logger.getLogger(KelolaPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KelolaPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KelolaPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KelolaPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KelolaPegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapusPegawai;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnReportPegawai;
    private javax.swing.JButton btnResetPegawai;
    private javax.swing.JButton btnTambahPegawai;
    private javax.swing.JButton btnUbahPegawai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPegawai;
    private javax.swing.JTextField txtGaji;
    private javax.swing.JTextField txtIdPegawai;
    private javax.swing.JTextField txtJabatan;
    private javax.swing.JTextField txtNamaPegawai;
    // End of variables declaration//GEN-END:variables
}
