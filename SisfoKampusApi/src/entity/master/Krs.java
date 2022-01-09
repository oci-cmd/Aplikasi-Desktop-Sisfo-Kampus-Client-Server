/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.master;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Rosidin
 */
public class Krs implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idKrs;
    private Integer idPengampu;
    private String namaDosen;
    private Integer idMhs;
    private String namaMhs;
    private Date tglKrs;

    public Integer getIdKrs() {
        return idKrs;
    }

    public void setIdKrs(Integer idKrs) {
        this.idKrs = idKrs;
    }

    public Integer getIdMhs() {
        return idMhs;
    }

    public void setIdMhs(Integer idMhs) {
        this.idMhs = idMhs;
    }

    public Integer getIdPengampu() {
        return idPengampu;
    }

    public void setIdPengampu(Integer idPengampu) {
        this.idPengampu = idPengampu;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }

    public String getNamaMhs() {
        return namaMhs;
    }

    public void setNamaMhs(String namaMhs) {
        this.namaMhs = namaMhs;
    }

    public Date getTglKrs() {
        return tglKrs;
    }

    public void setTglKrs(Date tglKrs) {
        this.tglKrs = tglKrs;
    }

    
}
