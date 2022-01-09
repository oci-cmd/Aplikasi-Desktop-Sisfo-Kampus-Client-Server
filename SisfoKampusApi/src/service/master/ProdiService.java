/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.master;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import prodi.Prodi;

/**
 *
 * @author Rosidin
 */
public interface ProdiService extends Remote {
    Prodi create(Prodi p) throws RemoteException;
    List<Prodi> read() throws RemoteException;
    Prodi update(Prodi p) throws RemoteException;
    void delete(Prodi p) throws RemoteException;
    // Cek Duplikat pada Kode Prodi
    Integer cekKodeProdi(String kodeProdi) throws RemoteException;
    // Mendapatkan Id Fakultas berdasarkan Nama Fakultas
    Integer getIdFakultas(String namaFakultas) throws RemoteException;
}
