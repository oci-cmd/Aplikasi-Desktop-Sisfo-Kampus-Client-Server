/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CrudPanel.java
 *
 * Created on Aug 13, 2021, 8:54:24 AM
 */
package main;

import javax.swing.JButton;

/**
 *
 * @author Rosidin
 */
public class CrudPanel extends javax.swing.JPanel {

    /** Creates new form CrudPanel */
    public CrudPanel() {
        initComponents();
    }

    public JButton getButtonBaru() {
        return buttonBaru;
    }

    public JButton getButtonEdit() {
        return buttonEdit;
    }

    public JButton getButtonHapus() {
        return buttonHapus;
    }

    public JButton getButtonRefresh() {
        return buttonRefresh;
    }
    
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonBaru = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(1, 0));

        buttonBaru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/tambah16.png"))); // NOI18N
        buttonBaru.setText("Baru");
        add(buttonBaru);

        buttonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/edit16.png"))); // NOI18N
        buttonEdit.setText("Edit");
        add(buttonEdit);

        buttonHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/hapus16.png"))); // NOI18N
        buttonHapus.setText("Hapus");
        add(buttonHapus);

        buttonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/refresh16.png"))); // NOI18N
        buttonRefresh.setText("Refresh");
        add(buttonRefresh);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBaru;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonRefresh;
    // End of variables declaration//GEN-END:variables
}