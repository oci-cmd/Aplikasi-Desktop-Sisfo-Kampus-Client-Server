/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prodi;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Rosidin
 */
public class Prodi implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idProdi;
    private Integer idFakultas;
    // tambahan
    private String namaFakultas;
    private String kodeProdi;
    private String namaProdi;
    private String statusProdi;
    private String akreditasi;
    private Date tglBerdiri;
    private String keterangan;

    public String getAkreditasi() {
        return akreditasi;
    }

    public void setAkreditasi(String akreditasi) {
        this.akreditasi = akreditasi;
    }

    public Integer getIdFakultas() {
        return idFakultas;
    }

    public void setIdFakultas(Integer idFakultas) {
        this.idFakultas = idFakultas;
    }

    public Integer getIdProdi() {
        return idProdi;
    }

    public void setIdProdi(Integer idProdi) {
        this.idProdi = idProdi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getKodeProdi() {
        return kodeProdi;
    }

    public void setKodeProdi(String kodeProdi) {
        this.kodeProdi = kodeProdi;
    }

    public String getNamaFakultas() {
        return namaFakultas;
    }

    public void setNamaFakultas(String namaFakultas) {
        this.namaFakultas = namaFakultas;
    }

    public String getNamaProdi() {
        return namaProdi;
    }

    public void setNamaProdi(String namaProdi) {
        this.namaProdi = namaProdi;
    }

    public String getStatusProdi() {
        return statusProdi;
    }

    public void setStatusProdi(String statusProdi) {
        this.statusProdi = statusProdi;
    }

    public Date getTglBerdiri() {
        return tglBerdiri;
    }

    public void setTglBerdiri(Date tglBerdiri) {
        this.tglBerdiri = tglBerdiri;
    }
    
    
    
}
