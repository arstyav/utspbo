/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import florist.database;
import florist.florist;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class update1 extends javax.swing.JFrame {

   Connection con;
   Statement stmt;
   ResultSet rs;
   
    public update1() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JButton();
        sveupdate = new javax.swing.JButton();
        txtPriceStalk = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        txtPriceDozen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.setContentAreaFilled(false);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 110, 50));

        sveupdate.setContentAreaFilled(false);
        sveupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sveupdateActionPerformed(evt);
            }
        });
        getContentPane().add(sveupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 110, 50));

        txtPriceStalk.setBackground(new java.awt.Color(222, 201, 182));
        txtPriceStalk.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        txtPriceStalk.setForeground(new java.awt.Color(255, 255, 255));
        txtPriceStalk.setBorder(null);
        getContentPane().add(txtPriceStalk, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 210, 30));

        txtID.setBackground(new java.awt.Color(222, 201, 182));
        txtID.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        txtID.setForeground(new java.awt.Color(255, 255, 255));
        txtID.setBorder(null);
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 210, 30));

        txtStock.setBackground(new java.awt.Color(222, 201, 182));
        txtStock.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        txtStock.setForeground(new java.awt.Color(255, 255, 255));
        txtStock.setBorder(null);
        getContentPane().add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 210, 30));

        txtPriceDozen.setBackground(new java.awt.Color(222, 201, 182));
        txtPriceDozen.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        txtPriceDozen.setForeground(new java.awt.Color(255, 255, 255));
        txtPriceDozen.setBorder(null);
        getContentPane().add(txtPriceDozen, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 210, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/LOGIN (17).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        new mainmenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void sveupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sveupdateActionPerformed
        // TODO add your handling code here:
        String ID = txtID.getText().trim();
        int Stock = Integer.parseInt(txtStock.getText().trim());

        // Validate and parse PriceStalk
        int PriceStalk;
        try {
            PriceStalk = Integer.parseInt(txtPriceStalk.getText().trim());
            if (PriceStalk <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "PriceStalk must be a positive integer");
            return; // Stop execution if validation fails
        }

        // Validate and parse PriceDozen
        int PriceDozen;
        try {
            PriceDozen = Integer.parseInt(txtPriceDozen.getText().trim());
            if (PriceDozen <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "PriceDozen must be a positive integer");
            return; // Stop execution if validation fails
        }

        if (ID.isEmpty()) { 
            JOptionPane.showMessageDialog(this, "Empty data is not allowed!");
        } else { 
            florist Florist = new florist();
            Florist.ID = ID;
            Florist.stock = Stock;
            Florist.priceStalk = PriceStalk;
            Florist.priceDozen = PriceDozen;

            if (Florist.update()) {
                JOptionPane.showMessageDialog(this, "Data has been successfully changed!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to change the data!");
            }
        }

    }//GEN-LAST:event_sveupdateActionPerformed

    
 
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(update1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(update1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(update1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(update1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new update1().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton sveupdate;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPriceDozen;
    private javax.swing.JTextField txtPriceStalk;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
