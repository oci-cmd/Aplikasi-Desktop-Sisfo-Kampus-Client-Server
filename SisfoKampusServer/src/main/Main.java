/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.master.FakultasServiceServer;
import service.master.ProdiServiceServer;

/**
 *
 * @author Rosidin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Port = 123
            Registry server = LocateRegistry.createRegistry(123);
            FakultasServiceServer fakServer = new FakultasServiceServer();
            server.rebind("fakultas", fakServer);
            ProdiServiceServer prodiServer = new ProdiServiceServer();
            server.rebind("prodi", prodiServer);
            
            SystemTrayServer.createAndShowGUI();
            
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
