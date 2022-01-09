/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.master.FakultasService;
import service.master.ProdiService;

/**
 *
 * @author Rosidin
 */
public class KonekToServer {
    private static Registry registry;
    private static FakultasService fakultasService;
    private static ProdiService prodiService;

    public static Registry getRegistry() {
        if(registry==null) {
            try {
                // Port = 123
                registry = LocateRegistry.getRegistry(getUrl("url"), 123);
            } catch (RemoteException ex) {
                Logger.getLogger(KonekToServer.class.getName()).log(Level.SEVERE, null, ex);                
            }
        }
        return registry;
    }

    public static ProdiService getProdiService() {
        try {
            prodiService = (ProdiService) getRegistry().lookup("prodi");
        } catch (RemoteException ex) {
            Logger.getLogger(KonekToServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(KonekToServer.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return prodiService;
    }
    
    public static FakultasService getFakultasService() {
        try {
            fakultasService = (FakultasService) getRegistry().lookup("fakultas");
        } catch (RemoteException ex) {
            Logger.getLogger(KonekToServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(KonekToServer.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return fakultasService;
    }
    
    private static String getUrl(String key) {
         String value = null;
         try {
           Properties pro = new Properties();
           pro.load(new FileInputStream("server.ini"));
           value = pro.getProperty(key);
         } catch (MissingResourceException e) {
           System.out.println(e + " : Couldn't find value for: " + key);
         } catch (IOException ioe) {
             System.out.println(ioe);
         }
         return value;
    }
    
    
}
