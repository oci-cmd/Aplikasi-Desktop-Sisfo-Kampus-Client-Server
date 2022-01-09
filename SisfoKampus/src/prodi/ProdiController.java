/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prodi;

import java.awt.Component;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.master.ProdiService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import tools.CustomizeSwing;
import tools.KonekToServer;

/**
 *
 * @author Rosidin
 */
public class ProdiController implements ActionListener {
    private InternalFrameProdi frmProdi;
    private ProdiUnitDialog prodiUnitDlg;
    private Prodi prodi;
    private Integer selected;
    private ProdiService prodiServ = KonekToServer.getProdiService();

    public ProdiController(InternalFrameProdi frmProdi, ProdiUnitDialog prodiUnitDlg) {
        this.frmProdi = frmProdi;
        this.prodiUnitDlg = prodiUnitDlg;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frmProdi.getCrudPanel().getButtonBaru()) {
            prodiUnitDlg.createData();            
        } else if(e.getSource() == frmProdi.getCrudPanel().getButtonEdit()) {
            editController();
        } else if(e.getSource() == frmProdi.getCrudPanel().getButtonHapus()) {
            deleteController();
        } else if(e.getSource() == frmProdi.getCrudPanel().getButtonRefresh()) {
            refreshController();
        } else if(e.getSource() == prodiUnitDlg.getButtonSimpan()) {
            simpanController();            
        }
    }
    
    public void editController() {
        selected = frmProdi.getTableData().getSelectedRow();
        if (selected != -1) {
            int index = frmProdi.getTableData().convertRowIndexToModel(frmProdi.getTableData().getSelectedRow());
            prodi = frmProdi.getTableModel().getProdi(index);
            Prodi result = prodiUnitDlg.changeData(prodi);
            if (result != null) {
                frmProdi.getTableModel().setProdi(index, result);
                CustomizeSwing.autoResizeColumn(frmProdi.getTableData());
            }
        } else {
            JOptionPane.showMessageDialog(prodiUnitDlg, "Pilih data yang akan diubah", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void deleteController() {
        selected = frmProdi.getTableData().getSelectedRow();
	if (selected != -1) {
            int index = frmProdi.getTableData().convertRowIndexToModel(frmProdi.getTableData().getSelectedRow());
            if(confirm(frmProdi, "Hapus Prodi", "Anda yakin akan menghapus data Prodi")) {
                try {
                    prodi = frmProdi.getTableModel().getProdi(index);
                    prodiServ.delete(prodi);
                    frmProdi.getTableModel().removeProdi(index);
                    CustomizeSwing.autoResizeColumn(frmProdi.getTableData());
                } catch (RemoteException ex) {
                    Logger.getLogger(ProdiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(prodiUnitDlg, "Pilih data yang akan dihapus", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public Boolean confirm(Component parent, String title, String message) {
        return JOptionPane.YES_NO_OPTION == JOptionPane.showConfirmDialog(parent,
		message, title, JOptionPane.YES_NO_OPTION);
    }

    public void refreshController() {
        try {
            List<Prodi> list = prodiServ.read();
            frmProdi.getTableModel().setData(list);
            CustomizeSwing.autoResizeColumn(frmProdi.getTableData());
        } catch (RemoteException ex) {
            Logger.getLogger(ProdiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void simpanController() {
        if(prodiUnitDlg.getComboFakultas().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(prodiUnitDlg, "Fakultas Belum Di Pilih", "Error", JOptionPane.ERROR_MESSAGE);
            prodiUnitDlg.getComboFakultas().requestFocusInWindow();
        } else if(prodiUnitDlg.getTextKodeProdi().getText().isEmpty()) {
            JOptionPane.showMessageDialog(prodiUnitDlg, "Kode Prodi masih kosong", "Error", JOptionPane.ERROR_MESSAGE);
            prodiUnitDlg.getTextKodeProdi().requestFocusInWindow();
        } else if(prodiUnitDlg.getTextNamaProdi().getText().isEmpty()) {
            JOptionPane.showMessageDialog(prodiUnitDlg, "Nama Prodi masih kosong", "Warning", JOptionPane.WARNING_MESSAGE);
            prodiUnitDlg.getTextNamaProdi().requestFocusInWindow();
        } else if(prodiUnitDlg.getRbAktif().isSelected() == false && prodiUnitDlg.getRbAktif().isSelected() == false) {
            JOptionPane.showMessageDialog(prodiUnitDlg, "Status Akreditasi Belum ada yang di pilih", "Warning", JOptionPane.WARNING_MESSAGE);
            prodiUnitDlg.getRbAktif().requestFocusInWindow();
        } else if(prodiUnitDlg.getComboAkreditasi().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(prodiUnitDlg, "Akreditasi belum di pilih", "Warning", JOptionPane.WARNING_MESSAGE);
            prodiUnitDlg.getComboAkreditasi().requestFocusInWindow();
        } else if(prodiUnitDlg.getTextKeterangan().getText().isEmpty()) {
            JOptionPane.showMessageDialog(prodiUnitDlg, "Keterangan masih kosong", "Warning", JOptionPane.WARNING_MESSAGE);
            prodiUnitDlg.getTextKeterangan().requestFocusInWindow();
        } else {
           if(prodiUnitDlg.getButtonSimpan().getText().equalsIgnoreCase("simpan")) {
                try {
                    Prodi p = new Prodi();
                    p.setIdFakultas(prodiUnitDlg.getIdFakultas());
                    p.setNamaFakultas(prodiUnitDlg.getComboFakultas().getSelectedItem().toString());
                    p.setKodeProdi(prodiUnitDlg.getTextKodeProdi().getText().trim());
                    p.setNamaProdi(prodiUnitDlg.getTextNamaProdi().getText().trim());
                    if(prodiUnitDlg.getRbAktif().isSelected()) {
                        p.setStatusProdi("Aktif");
                    } else if(prodiUnitDlg.getRbTdkAktif().isSelected()) {
                        p.setStatusProdi("Tidak Aktif");
                    }
                    p.setAkreditasi(prodiUnitDlg.getComboAkreditasi().getSelectedItem().toString());
                    p.setTglBerdiri(prodiUnitDlg.getTextTglBerdiri().getDate());
                    p.setKeterangan(prodiUnitDlg.getTextKeterangan().getText().trim());
                    prodi = prodiServ.create(p);
                    JOptionPane.showMessageDialog(prodiUnitDlg, "Data berhasil disimpan", "Information", JOptionPane.INFORMATION_MESSAGE);
                    if (prodi != null) {
                        frmProdi.getTableModel().addProdi(prodi);
                        CustomizeSwing.autoResizeColumn(frmProdi.getTableData());
                    }
                    prodiUnitDlg.reset("Tambah Prodi");
                    prodiUnitDlg.getComboFakultas().requestFocusInWindow();
                } catch (RemoteException ex) {
                    Logger.getLogger(ProdiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
       }
    }
    
}
