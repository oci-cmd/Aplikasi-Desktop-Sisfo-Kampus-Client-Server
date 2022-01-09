/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mahasiswa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Rosidin
 */
public class MahasiswaController implements ActionListener {
    private InternalFrameMahasiswa frmMhs;
    private MahasiswaUnitDialog mhsDlg;

    public MahasiswaController(InternalFrameMahasiswa frmMhs, MahasiswaUnitDialog mhsDlg) {
        this.frmMhs = frmMhs;
        this.mhsDlg = mhsDlg;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frmMhs.getCrudPanel().getButtonBaru()) {
            mhsDlg.createData();
        } else if(e.getSource() == frmMhs.getCrudPanel().getButtonEdit()) {
            mhsDlg.editData();
        }
    }
    
}
