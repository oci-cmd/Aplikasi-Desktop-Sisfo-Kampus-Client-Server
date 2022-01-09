/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dosen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Rosidin
 */
public class DosenController implements ActionListener {
    private InternalFrameDosen frmDosen;
    private DosenUnitDialog dosenDlg;

    public DosenController(InternalFrameDosen frmDosen, DosenUnitDialog dosenDlg) {
        this.frmDosen = frmDosen;
        this.dosenDlg = dosenDlg;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frmDosen.getCrudPanel().getButtonBaru()) {
            dosenDlg.createData();
        } else if(e.getSource() == frmDosen.getCrudPanel().getButtonEdit()) {
            dosenDlg.editData();
        }
    }
    
}
