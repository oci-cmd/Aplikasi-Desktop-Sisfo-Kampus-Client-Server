/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.master;

import java.io.Serializable;

/**
 *
 * @author Rosidin
 */
public class Fakultas implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idFakultas;
    private String kodeFakultas;
    private String namaFakultas;
    private String keterangan;

    public Integer getIdFakultas() {
        return idFakultas;
    }

    public void setIdFakultas(Integer idFakultas) {
        this.idFakultas = idFakultas;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getKodeFakultas() {
        return kodeFakultas;
    }

    public void setKodeFakultas(String kodeFakultas) {
        this.kodeFakultas = kodeFakultas;
    }

    public String getNamaFakultas() {
        return namaFakultas;
    }

    public void setNamaFakultas(String namaFakultas) {
        this.namaFakultas = namaFakultas;
    }
    
    
    @Override
    public String toString() {
        return namaFakultas;
    }
    
}
