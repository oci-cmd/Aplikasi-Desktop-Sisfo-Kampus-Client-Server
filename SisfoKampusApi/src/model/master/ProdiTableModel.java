/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prodi;

import entity.master.Prodi;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rosidin
 */
public class ProdiTableModel extends AbstractTableModel {
    
    private String[] HEADER = new String[] {
            "NO","FAKULTAS","KODE PRODI","NAMA PRODI","STATUS PRODI","AKREDITASI","TGL BERDIRI","KETERANGAN"
        };
    private List<Prodi> list = new ArrayList<Prodi>();

    // untuk menampilkan data di JTable
    public void setData(List<Prodi> list) {
        this.list = list;
        fireTableDataChanged();
    }
    
    // untuk menambahkan data di JTable
    public void addProdi(Prodi p) {
        list.add(p);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
    }
    
    // menghapus data pada baris tabel
    public void removeProdi(int index) {
        list.remove(index);
        fireTableRowsDeleted(index, index);
    }
    
    // merubah data pada baris tabel yang di pilih
    public void setProdi(int index, Prodi p) {
        list.set(index, p);
        fireTableRowsUpdated(index, index);
    }
    
    // mendapatkan data pada baris tabel yang di pilih
    public Prodi getProdi(int index) {
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return HEADER.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // "NO","FAKULTAS","KODE PRODI","NAMA PRODI","STATUS PRODI","AKREDITASI","TGL BERDIRI","KETERANGAN"
        Prodi p = list.get(rowIndex);
        SimpleDateFormat nf = new SimpleDateFormat("yyyy-MM-dd");
        switch(columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return p.getNamaFakultas();
            case 2:
                return p.getKodeProdi();
            case 3:
                return p.getNamaProdi();    
            case 4:
                return p.getStatusProdi();    
            case 5:
                return p.getAkreditasi();    
            case 6:
                return nf.format(p.getTglBerdiri());    
            case 7:
                return p.getKeterangan();        
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return HEADER[column];
    }
    
}
