/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProdiUnitDialog.java
 *
 * Created on Dec 20, 2021, 3:45:36 PM
 */
package prodi;

import entity.master.Prodi;
import com.toedter.calendar.JDateChooser;
import entity.master.Fakultas;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.JTextComponent;
import service.master.FakultasService;
import service.master.ProdiService;
import tools.ComboAutoFromList;
import tools.KonekToServer;

/**
 *
 * @author Rosidin
 */
public class ProdiUnitDialog extends javax.swing.JDialog {
    private ProdiController controller;
    private Prodi prodi;
    private ProdiService prodiServ = KonekToServer.getProdiService();
    private Integer idFakultas;
    private JTextComponent autoCompleteFakultas;  

    /** Creates new form ProdiUnitDialog */
    public ProdiUnitDialog(InternalFrameProdi parent) {
        setModal(true);
        initComponents();
        setLocationRelativeTo(parent);
        controller = new ProdiController(parent, this);
        buttonSimpan.addActionListener(controller);
        autoCompleteFakultas = (JTextComponent) comboFakultas.getEditor().getEditorComponent();
        autoCompleteFakultas.setDocument(new ComboAutoFromList(comboFakultas));
    }
  
    public void createData() {
        buttonSimpan.setText("Simpan");
        comboFakultas.requestFocusInWindow();
        reset("Tambah Prodi");
        setVisible(true);
    }

    public Prodi changeData(Prodi prodi) {
        this.prodi = prodi;
        buttonSimpan.setText("Ubah");
        reset("Ubah Prodi", prodi.getIdFakultas(), prodi.getNamaFakultas(), 
                prodi.getKodeProdi(), prodi.getNamaProdi(), prodi.getStatusProdi(), 
                prodi.getAkreditasi(), prodi.getTglBerdiri(), prodi.getKeterangan());
        setVisible(true);
        return this.prodi;
    }

    public void reset(String title) {
        reset(title, null, "::PILIH FAKULTAS::", null, null, null, "::PILIH AKREDITASI::", new Date(), null);
    }

    private void reset(String title,Integer idFakultas,String namaFakultas,
            String kodeProdi,String namaProdi,String statusAkreditasi,String akreditasi,
            Date tglBerdiri,String keterangan) {
        setTitle(title);
        reloadFakultas();
        this.idFakultas = idFakultas;
        comboFakultas.setSelectedItem(namaFakultas);
        textKodeProdi.setText(kodeProdi);
        textNamaProdi.setText(namaProdi);
        if(statusAkreditasi == null) {
            rbAktif.setSelected(false);
            rbTdkAktif.setSelected(false);
        } else if(statusAkreditasi.equalsIgnoreCase("aktif")) {
            rbAktif.setSelected(true);
            rbTdkAktif.setSelected(false);
        } else if(statusAkreditasi.equalsIgnoreCase("tidak aktif")) {
            rbAktif.setSelected(false);
            rbTdkAktif.setSelected(true);
        } 
        comboAkreditasi.setSelectedItem(akreditasi);
        textTglBerdiri.setDate(tglBerdiri);
        textKeterangan.setText(keterangan);
    }

    private void reloadFakultas() {
        try {
            comboFakultas.removeAllItems();
            FakultasService fakServ = KonekToServer.getFakultasService();
            List<Fakultas> list = fakServ.read();
            comboFakultas.addItem("::PILIH FAKULTAS::");
            for(Fakultas f : list) {
                comboFakultas.addItem(f);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ProdiUnitDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public JComboBox getComboAkreditasi() {
        return comboAkreditasi;
    }

    public Integer getIdFakultas() {
        return idFakultas;
    }
    
    public JComboBox getComboFakultas() {
        return comboFakultas;
    }

    public JRadioButton getRbAktif() {
        return rbAktif;
    }

    public JRadioButton getRbTdkAktif() {
        return rbTdkAktif;
    }

    public JTextArea getTextKeterangan() {
        return textKeterangan;
    }

    public JTextField getTextKodeProdi() {
        return textKodeProdi;
    }

    public JTextField getTextNamaProdi() {
        return textNamaProdi;
    }

    public JDateChooser getTextTglBerdiri() {
        return textTglBerdiri;
    }

    public JButton getButtonSimpan() {
        return buttonSimpan;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        textKodeProdi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboAkreditasi = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rbAktif = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        textNamaProdi = new javax.swing.JTextField();
        comboFakultas = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textKeterangan = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        textTglBerdiri = new com.toedter.calendar.JDateChooser();
        buttonSimpan = new javax.swing.JButton();
        rbTdkAktif = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        textKodeProdi.setText("jTextField1");
        textKodeProdi.setOpaque(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Kode Prodi :");

        comboAkreditasi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "::PILIH AKREDITASI::", "A", "B", "C" }));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Tgl Berdiri :");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Akreditasi :");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Status Prodi :");

        buttonGroup1.add(rbAktif);
        rbAktif.setText("Aktif");
        rbAktif.setOpaque(false);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nama Prodi :");

        textNamaProdi.setText("jTextField1");
        textNamaProdi.setOpaque(false);

        comboFakultas.setEditable(true);
        comboFakultas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboFakultas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboFakultasItemStateChanged(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nama Fakultas :");

        textKeterangan.setColumns(20);
        textKeterangan.setRows(5);
        jScrollPane1.setViewportView(textKeterangan);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Keterangan : ");

        buttonSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/simpan16.png"))); // NOI18N
        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbTdkAktif);
        rbTdkAktif.setText("Tidak Aktif");
        rbTdkAktif.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textKodeProdi, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                    .addComponent(comboFakultas, 0, 343, Short.MAX_VALUE)
                    .addComponent(textNamaProdi, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                    .addComponent(comboAkreditasi, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbAktif)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbTdkAktif)
                        .addGap(221, 221, 221))
                    .addComponent(textTglBerdiri, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboFakultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textKodeProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textNamaProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbAktif)
                            .addComponent(rbTdkAktif))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(comboAkreditasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(textTglBerdiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSimpan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboAkreditasi, comboFakultas, jLabel3, jLabel4, jLabel6, jLabel7, jLabel8, jLabel9, rbAktif, textKodeProdi, textNamaProdi, textTglBerdiri});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboFakultasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboFakultasItemStateChanged
        try {
            Fakultas f = (Fakultas) comboFakultas.getSelectedItem();
            idFakultas = f.getIdFakultas();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_comboFakultasItemStateChanged

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        if(buttonSimpan.getText().equalsIgnoreCase("ubah")) {
            if(comboFakultas.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Fakultas belum di pilih", "Warning", JOptionPane.WARNING_MESSAGE);
                comboFakultas.requestFocusInWindow();
            } else if(textKodeProdi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Kode Prodi masih kosong", "Warning", JOptionPane.WARNING_MESSAGE);
                textKodeProdi.requestFocusInWindow();
            } else if(textNamaProdi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama Prodi masih kosong", "Warning", JOptionPane.WARNING_MESSAGE);
                textNamaProdi.requestFocusInWindow();
            } else if(rbAktif.isSelected() == false && rbTdkAktif.isSelected() == false) {
                JOptionPane.showMessageDialog(this, "Status Akreditasi Belum ada yang di pilih", "Warning", JOptionPane.WARNING_MESSAGE);
                rbAktif.requestFocusInWindow();
            } else if(comboAkreditasi.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Akreditasi belum di pilih", "Warning", JOptionPane.WARNING_MESSAGE);
                comboAkreditasi.requestFocusInWindow();
            } else if(textKeterangan.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Keterangan masih kosong", "Warning", JOptionPane.WARNING_MESSAGE);
                textKeterangan.requestFocusInWindow();
            } else {
                try {
                    prodi.setIdFakultas(idFakultas);
                    prodi.setNamaFakultas(comboFakultas.getSelectedItem().toString());
                    prodi.setKodeProdi(textKodeProdi.getText().trim());
                    prodi.setNamaProdi(textNamaProdi.getText().trim());
                    if(rbAktif.isSelected()) {
                        prodi.setStatusProdi("Aktif");
                    } else if(rbTdkAktif.isSelected()) {
                        prodi.setStatusProdi("Tidak Aktif");
                    }
                    prodi.setAkreditasi(comboAkreditasi.getSelectedItem().toString());
                    prodi.setTglBerdiri(textTglBerdiri.getDate());
                    prodi.setKeterangan(textKeterangan.getText().trim());
                    prodi = prodiServ.update(prodi);
                    setVisible(false);
                } catch (RemoteException ex) {
                    Logger.getLogger(ProdiUnitDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_buttonSimpanActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JComboBox comboAkreditasi;
    private javax.swing.JComboBox comboFakultas;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbAktif;
    private javax.swing.JRadioButton rbTdkAktif;
    private javax.swing.JTextArea textKeterangan;
    private javax.swing.JTextField textKodeProdi;
    private javax.swing.JTextField textNamaProdi;
    private com.toedter.calendar.JDateChooser textTglBerdiri;
    // End of variables declaration//GEN-END:variables

}
