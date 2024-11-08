
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author USER
 */
public class PenghitungKataFrame extends javax.swing.JFrame {

    /**
     * Creates new form PenghitungKataFrame
     */
    public PenghitungKataFrame() {
        initComponents();
        
        // Menambahkan event listener untuk tombol Hitung
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            hitungKata();
        }
    });
        // Menambahkan event listener untuk tombol Simpan
        btnSimpan.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            simpanKeFile();
    }
});
    }
    
    private void hitungKata() {
        String teks = txtAreaKata.getText();
        int jmlhKata = teks.trim().isEmpty() ? 0 : teks.split("\\s+").length;
        int jmlhKarakter = teks.length();
        int jmlhKalimat = teks.split("[.!?]").length;
        int jmlhParagraf = teks.trim().isEmpty() ? 0 : teks.split("\\n\\s*\\n").length;

        // Mencari kata tertentu
        String kataDicari = txtCariKata.getText().trim();
            int jmlhKataDitemukan = 0;
            if (!kataDicari.isEmpty()) {
        // Mengimport pattern dan matcher untuk pencarian agar ketika dicari tidak muncul lebihan angka
            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(kataDicari) + "\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(teks);
            while (matcher.find()) {
                jmlhKataDitemukan++;
                }
            }

        labelKata.setText("Jumlah Kata: " + jmlhKata);
        labelKarakter.setText("Jumlah Karakter: " + jmlhKarakter);
        labelKalimat.setText("Jumlah Kalimat: " + jmlhKalimat);
        labelParagraf.setText("Jumlah Paragraf: " + jmlhParagraf);
        labelHasilCari.setText("Jumlah Kata Ditemukan: " + jmlhKataDitemukan);
}
    private void simpanKeFile() {
    try {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            java.io.File file = fileChooser.getSelectedFile();
            try (java.io.FileWriter writer = new java.io.FileWriter(file)) {
                writer.write("Teks:\n" + txtAreaKata.getText() + "\n\n");
                writer.write(labelKata.getText() + "\n");
                writer.write(labelKarakter.getText() + "\n");
                writer.write(labelKalimat.getText() + "\n");
                writer.write(labelParagraf.getText() + "\n");
                writer.write(labelHasilCari.getText() + "\n");
                JOptionPane.showMessageDialog(this, "File berhasil disimpan.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Terjadi error saat menyimpan file: " + e.getMessage());
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaKata = new javax.swing.JTextArea();
        btnHitung = new javax.swing.JButton();
        labelKata = new javax.swing.JLabel();
        labelKarakter = new javax.swing.JLabel();
        labelKalimat = new javax.swing.JLabel();
        labelParagraf = new javax.swing.JLabel();
        txtCariKata = new javax.swing.JTextField();
        labelHasilCari = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 102, 255));
        jPanel1.setForeground(new java.awt.Color(242, 242, 242));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setText("Aplikasi Penghitung Kata");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Form Penghitung Kata", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txtAreaKata.setColumns(20);
        txtAreaKata.setRows(5);
        jScrollPane1.setViewportView(txtAreaKata);

        btnHitung.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        labelKata.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelKata.setText("Jumlah Kata");

        labelKarakter.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelKarakter.setText("Jumlah Karakter");

        labelKalimat.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelKalimat.setText("Jumlah Kalimat");

        labelParagraf.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelParagraf.setText("Jumlah Paragraf");

        txtCariKata.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        labelHasilCari.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelHasilCari.setText("Hasil Pencarian Kata");

        btnSimpan.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnSimpan.setText("Simpan");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Cari Kata");

        btnHapus.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnKeluar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnHitung)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnKeluar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCariKata, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelHasilCari)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelKata)
                        .addGap(18, 18, 18)
                        .addComponent(labelKarakter)
                        .addGap(18, 18, 18)
                        .addComponent(labelKalimat)
                        .addGap(18, 18, 18)
                        .addComponent(labelParagraf))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCariKata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelHasilCari))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelKata)
                    .addComponent(labelKarakter)
                    .addComponent(labelKalimat)
                    .addComponent(labelParagraf)))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHitungActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        txtAreaKata.setText("");
        txtCariKata.setText("");

        // Menghapus inputan dan label
        labelKata.setText("Jumlah Kata: 0");
        labelKarakter.setText("Jumlah Karakter: 0");
        labelKalimat.setText("Jumlah Kalimat: 0");
        labelParagraf.setText("Jumlah Paragraf: 0");
        labelHasilCari.setText("Jumlah Kata Ditemukan: 0");       
    }//GEN-LAST:event_btnHapusActionPerformed

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
            java.util.logging.Logger.getLogger(PenghitungKataFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenghitungKataFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenghitungKataFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenghitungKataFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenghitungKataFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelHasilCari;
    private javax.swing.JLabel labelKalimat;
    private javax.swing.JLabel labelKarakter;
    private javax.swing.JLabel labelKata;
    private javax.swing.JLabel labelParagraf;
    private javax.swing.JTextArea txtAreaKata;
    private javax.swing.JTextField txtCariKata;
    // End of variables declaration//GEN-END:variables
}
