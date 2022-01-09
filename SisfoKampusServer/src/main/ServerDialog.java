/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ServerDialog.java
 *
 * Created on Dec 20, 2021, 4:15:28 PM
 */
package main;

import javax.swing.ImageIcon;

/**
 *
 * @author Rosidin
 */
public class ServerDialog extends javax.swing.JDialog {

    /** Creates new form ServerDialog */
    public ServerDialog() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Server Sisfo Kampus");
        setIconImage(new ImageIcon(getClass().getResource("/resource/black-server.png")).getImage());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonServer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonServer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/stop.png"))); // NOI18N
        buttonServer.setText("Stop");
        buttonServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonServer, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonServer, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonServerActionPerformed
        System.exit(0);
}//GEN-LAST:event_buttonServerActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonServer;
    // End of variables declaration//GEN-END:variables
}
