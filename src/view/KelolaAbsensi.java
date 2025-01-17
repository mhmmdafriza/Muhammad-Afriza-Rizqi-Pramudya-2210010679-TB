package view;

import controller.AbsensiController;
import model.Absensi;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Date;
import view.MainMenu;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JOptionPane;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;

public class KelolaAbsensi extends javax.swing.JFrame {

    private AbsensiController absensiController;

    public KelolaAbsensi() {
        initComponents();
        absensiController = new AbsensiController();
        loadTableAbsensi();

        // Tambahkan listener untuk menangani klik pada tabel
        tblAbsensi.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                fillFormFromTable();
            }
        });
    }

    private void loadTableAbsensi() {
        DefaultTableModel model = (DefaultTableModel) tblAbsensi.getModel();
        model.setRowCount(0);

        List<Absensi> absensiList = absensiController.getAllAbsensi();
        for (Absensi absensi : absensiList) {
            Object[] row = {
                absensi.getIdAbsensi(),
                absensi.getIdPegawai(),
                absensi.getTanggal(),
                absensi.getStatusKehadiran()
            };
            model.addRow(row);
        }
    }

    private void fillFormFromTable() {
        int selectedRow = tblAbsensi.getSelectedRow();
        if (selectedRow >= 0) {
            // Ambil data dari tabel
            int idAbsensi = (int) tblAbsensi.getValueAt(selectedRow, 0);
            int idPegawai = (int) tblAbsensi.getValueAt(selectedRow, 1);
            Date tanggal = (Date) tblAbsensi.getValueAt(selectedRow, 2);
            String statusKehadiran = (String) tblAbsensi.getValueAt(selectedRow, 3);

            // Isi data ke komponen
            txtIdAbsensi.setText(String.valueOf(idAbsensi));
            txtIdPegawaiAbsensi.setText(String.valueOf(idPegawai));
            dateChooserTanggal.setDate(tanggal);
            comboStatusKehadiran.setSelectedItem(statusKehadiran);
        }
    }

    private void resetForm() {
        txtIdAbsensi.setText("");
        txtIdPegawaiAbsensi.setText("");
        dateChooserTanggal.setDate(null);
        comboStatusKehadiran.setSelectedIndex(0);
        tblAbsensi.clearSelection(); // Kosongkan seleksi di tabel
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAbsensi = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnTambahAbsensi = new javax.swing.JButton();
        btnResetAbsensi = new javax.swing.JButton();
        btnUbahAbsensi = new javax.swing.JButton();
        btnHapusAbsensi = new javax.swing.JButton();
        txtIdAbsensi = new javax.swing.JTextField();
        txtIdPegawaiAbsensi = new javax.swing.JTextField();
        comboStatusKehadiran = new javax.swing.JComboBox<>();
        btnKembali = new javax.swing.JButton();
        btnReportAbsensi = new javax.swing.JButton();
        dateChooserTanggal = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblAbsensi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Absensi", "ID Pegawai", "Tanggal", "Status Kehadiran"
            }
        ));
        jScrollPane1.setViewportView(tblAbsensi);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("KELOLA DATA ABSENSI");

        jLabel2.setText("Status");

        jLabel3.setText("ID Absensi");

        jLabel4.setText("Tanggal");

        jLabel5.setText("ID Pegawai");

        btnTambahAbsensi.setText("Tambah");
        btnTambahAbsensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahAbsensiActionPerformed(evt);
            }
        });

        btnResetAbsensi.setText("Reset");
        btnResetAbsensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetAbsensiActionPerformed(evt);
            }
        });

        btnUbahAbsensi.setText("Ubah");
        btnUbahAbsensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahAbsensiActionPerformed(evt);
            }
        });

        btnHapusAbsensi.setText("Hapus");
        btnHapusAbsensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusAbsensiActionPerformed(evt);
            }
        });

        txtIdAbsensi.setEditable(false);

        comboStatusKehadiran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hadir", "Tidak Hadir", "Sakit", "Izin" }));

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnReportAbsensi.setText("Report");
        btnReportAbsensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportAbsensiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(118, 118, 118)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtIdAbsensi, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtIdPegawaiAbsensi, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboStatusKehadiran, 0, 191, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnTambahAbsensi)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnHapusAbsensi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(2, 2, 2))))
                                    .addComponent(dateChooserTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReportAbsensi)
                                .addGap(18, 18, 18)
                                .addComponent(btnKembali)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(btnUbahAbsensi))
                            .addComponent(btnResetAbsensi, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdAbsensi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTambahAbsensi)
                            .addComponent(btnUbahAbsensi))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdPegawaiAbsensi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btnHapusAbsensi)
                            .addComponent(btnResetAbsensi))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(dateChooserTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboStatusKehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnKembali)
                            .addComponent(btnReportAbsensi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahAbsensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahAbsensiActionPerformed
        try {
            int idPegawai = Integer.parseInt(txtIdPegawaiAbsensi.getText());
            Date tanggal = dateChooserTanggal.getDate();
            String statusKehadiran = comboStatusKehadiran.getSelectedItem().toString();

            Absensi absensi = new Absensi(0, idPegawai, tanggal, statusKehadiran);
            absensiController.addAbsensi(absensi);

            loadTableAbsensi();
            resetForm();

            // Notifikasi pop-up
            JOptionPane.showMessageDialog(this, "Data absensi berhasil ditambahkan!",
                    "Sukses", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menambahkan data!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnTambahAbsensiActionPerformed

    private void btnUbahAbsensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahAbsensiActionPerformed
        try {
            int selectedRow = tblAbsensi.getSelectedRow();
            if (selectedRow >= 0) {
                int idAbsensi = Integer.parseInt(txtIdAbsensi.getText());
                int idPegawai = Integer.parseInt(txtIdPegawaiAbsensi.getText());
                Date tanggal = dateChooserTanggal.getDate();
                String statusKehadiran = comboStatusKehadiran.getSelectedItem().toString();

                Absensi absensi = new Absensi(idAbsensi, idPegawai, tanggal, statusKehadiran);
                absensiController.updateAbsensi(absensi);

                loadTableAbsensi();
                resetForm();

                // Notifikasi pop-up
                JOptionPane.showMessageDialog(this, "Data absensi berhasil diubah!",
                        "Sukses", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengubah data!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUbahAbsensiActionPerformed

    private void btnHapusAbsensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusAbsensiActionPerformed
        try {
            int selectedRow = tblAbsensi.getSelectedRow();
            if (selectedRow >= 0) {
                int idAbsensi = Integer.parseInt(txtIdAbsensi.getText());
                absensiController.deleteAbsensi(idAbsensi);

                loadTableAbsensi();
                resetForm();

                // Notifikasi pop-up
                JOptionPane.showMessageDialog(this, "Data absensi berhasil dihapus!",
                        "Sukses", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();

        }
    }//GEN-LAST:event_btnHapusAbsensiActionPerformed

    private void btnResetAbsensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetAbsensiActionPerformed
        resetForm();
    }//GEN-LAST:event_btnResetAbsensiActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        new MainMenu().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnReportAbsensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportAbsensiActionPerformed
        try {
            // Lokasi file PDF
            String fileName = "Laporan_Absensi.pdf";

            // Membuat dokumen PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName));

            // Membuka dokumen
            document.open();

            // Menambahkan judul laporan
            document.add(new Paragraph("Laporan Data Absensi", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
            document.add(new Paragraph(" "));

            // Membuat tabel PDF
            PdfPTable table = new PdfPTable(4); // 4 kolom
            table.setWidthPercentage(100);
            table.addCell("ID Absensi");
            table.addCell("ID Pegawai");
            table.addCell("Tanggal");
            table.addCell("Status Kehadiran");

            // Ambil data dari tabel GUI
            DefaultTableModel model = (DefaultTableModel) tblAbsensi.getModel();
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
    }//GEN-LAST:event_btnReportAbsensiActionPerformed

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
            java.util.logging.Logger.getLogger(KelolaAbsensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KelolaAbsensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KelolaAbsensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KelolaAbsensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KelolaAbsensi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapusAbsensi;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnReportAbsensi;
    private javax.swing.JButton btnResetAbsensi;
    private javax.swing.JButton btnTambahAbsensi;
    private javax.swing.JButton btnUbahAbsensi;
    private javax.swing.JComboBox<String> comboStatusKehadiran;
    private com.toedter.calendar.JDateChooser dateChooserTanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAbsensi;
    private javax.swing.JTextField txtIdAbsensi;
    private javax.swing.JTextField txtIdPegawaiAbsensi;
    // End of variables declaration//GEN-END:variables
}
