/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.master;

import entity.master.Fakultas;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Rosidin
 */
public interface FakultasService extends Remote {
    Fakultas create(Fakultas f) throws RemoteException;
    List<Fakultas> read() throws RemoteException;
    Fakultas update(Fakultas f) throws RemoteException;
    void delete(Fakultas f) throws RemoteException;
}
