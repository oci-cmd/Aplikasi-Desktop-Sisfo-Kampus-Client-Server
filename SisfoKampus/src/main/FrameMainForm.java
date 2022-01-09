/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrameMainForm.java
 *
 * Created on Aug 13, 2021, 8:41:21 AM
 */
package main;

import dosen.InternalFrameDosen;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import mahasiswa.InternalFrameMahasiswa;
import matakuliah.InternalFrameMataKuliah;
import prodi.InternalFrameProdi;
import tahunakademik.InternalFrameTahunAkademik;
import user.InternalFrameUbahPassword;

/**
 *
 * @author Rosidin
 */
public class FrameMainForm extends javax.swing.JFrame {

    /** Creates new form FrameMainForm */
    public FrameMainForm() {
        initComponents();
        //ini untuk judul aplikasi Main Utama
        setTitle("::Sistem Informasi AKademik Kampus UNU Cirebon::");
        // posisi di tengah
        setLocationRelativeTo(null);
        // maximize true
        setExtendedState(MAXIMIZED_BOTH); 
        // inisialisasi shorcut pada keyboard
        initShorcuts();
    }

    private void initShorcuts() {
        // shorcut keyboard Ctrl+O untuk Log Out
        menuItemLogOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        // shorcut keyboard Ctrl+X untuk Keluar dari Aplikasi
        menuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        // shorcut keyboard Ctrl+M untuk Buka Modul Mahasiswa
        menuItemDosen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        // shorcut keyboard Ctrl+D untuk Buka Modul Dosen
        menuItemMahasiswa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        // shorcut keyboard Ctrl+P untuk Buka Modul Password
        menuItemUbahPassword.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        // shorcut keyboard Ctrl+T untuk Buka Modul Tahun Akademik
        menuItemTahunAkademik.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        // shorcut keyboard Ctrl+K untuk Buka Modul Password
        menuItemMataKuliah.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuItemUbahPassword = new javax.swing.JMenuItem();
        menuItemLogOut = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();
        menuAkademik = new javax.swing.JMenu();
        menuItemTahunAkademik = new javax.swing.JMenuItem();
        menuItemMataKuliah = new javax.swing.JMenuItem();
        menuItemKrs = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuItemMahasiswa = new javax.swing.JMenuItem();
        menuItemDosen = new javax.swing.JMenuItem();
        menuItemFakultas = new javax.swing.JMenuItem();
        menuItemProdi = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);

        menuFile.setMnemonic('F');
        menuFile.setText("File");

        menuItemUbahPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/user-password-icon16.png"))); // NOI18N
        menuItemUbahPassword.setText("Ubah Password");
        menuItemUbahPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemUbahPasswordActionPerformed(evt);
            }
        });
        menuFile.add(menuItemUbahPassword);

        menuItemLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Log-Out-icon16.png"))); // NOI18N
        menuItemLogOut.setText("Log Out");
        menuItemLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLogOutActionPerformed(evt);
            }
        });
        menuFile.add(menuItemLogOut);

        menuItemExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/exit16.png"))); // NOI18N
        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        menuFile.add(menuItemExit);

        jMenuBar1.add(menuFile);

        menuAkademik.setMnemonic('A');
        menuAkademik.setText("Akademik");

        menuItemTahunAkademik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/education-university16.png"))); // NOI18N
        menuItemTahunAkademik.setText("Tahun Akademik");
        menuItemTahunAkademik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTahunAkademikActionPerformed(evt);
            }
        });
        menuAkademik.add(menuItemTahunAkademik);

        menuItemMataKuliah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/books16.png"))); // NOI18N
        menuItemMataKuliah.setText("Mata Kuliah");
        menuItemMataKuliah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMataKuliahActionPerformed(evt);
            }
        });
        menuAkademik.add(menuItemMataKuliah);

        menuItemKrs.setText("KRS (Kartu Rencana Studi)");
        menuAkademik.add(menuItemKrs);

        jMenuBar1.add(menuAkademik);

        jMenu1.setMnemonic('M');
        jMenu1.setText("Data Master");

        menuItemMahasiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/woman-student16.png"))); // NOI18N
        menuItemMahasiswa.setText("Data Mahasiswa");
        menuItemMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMahasiswaActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemMahasiswa);

        menuItemDosen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Teachers-icon16.png"))); // NOI18N
        menuItemDosen.setText("Data Dosen");
        menuItemDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDosenActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemDosen);

        menuItemFakultas.setText("Data Fakultas");
        jMenu1.add(menuItemFakultas);

        menuItemProdi.setText("Data Prodi");
        menuItemProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProdiActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemProdi);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemUbahPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemUbahPasswordActionPerformed
        InternalFrameUbahPassword frm = new InternalFrameUbahPassword();
        desktopPane.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_menuItemUbahPasswordActionPerformed

    private void menuItemMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMahasiswaActionPerformed
        InternalFrameMahasiswa frm = new InternalFrameMahasiswa();
        desktopPane.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_menuItemMahasiswaActionPerformed

    private void menuItemDosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDosenActionPerformed
        InternalFrameDosen frm = new InternalFrameDosen();
        desktopPane.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_menuItemDosenActionPerformed

    private void menuItemLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLogOutActionPerformed
        setVisible(false);
        new FrameLogin().setVisible(true);
    }//GEN-LAST:event_menuItemLogOutActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void menuItemTahunAkademikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTahunAkademikActionPerformed
        InternalFrameTahunAkademik frm = new InternalFrameTahunAkademik();
        desktopPane.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_menuItemTahunAkademikActionPerformed

    private void menuItemMataKuliahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMataKuliahActionPerformed
        InternalFrameMataKuliah frm = new InternalFrameMataKuliah();
        desktopPane.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_menuItemMataKuliahActionPerformed

    private void menuItemProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProdiActionPerformed
        InternalFrameProdi frm = new InternalFrameProdi();
        desktopPane.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_menuItemProdiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrameMainForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAkademik;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuItemDosen;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemFakultas;
    private javax.swing.JMenuItem menuItemKrs;
    private javax.swing.JMenuItem menuItemLogOut;
    private javax.swing.JMenuItem menuItemMahasiswa;
    private javax.swing.JMenuItem menuItemMataKuliah;
    private javax.swing.JMenuItem menuItemProdi;
    private javax.swing.JMenuItem menuItemTahunAkademik;
    private javax.swing.JMenuItem menuItemUbahPassword;
    // End of variables declaration//GEN-END:variables
}