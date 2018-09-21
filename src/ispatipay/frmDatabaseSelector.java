/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ispatipay;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;



/**
 *
 * @author DANEM682
 */
public class frmDatabaseSelector extends javax.swing.JFrame {

    /**
     * Creates new form frmDatabaseSelector
     */
    public frmDatabaseSelector() {
        initComponents();
    }

    Connection c = null;
    frmLogin frmLogin = new frmLogin();
    
    private static frmDatabaseSelector obj = null;

    public static frmDatabaseSelector getObj(){
        if ( obj == null ) {
            obj = new frmDatabaseSelector();
        }

        return obj;
    }

    private boolean isConnectionSet() throws SQLException {
        return ( !c.isClosed() );
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JPanel();
        lblDatabase = new javax.swing.JLabel();
        cboDatabase = new javax.swing.JComboBox();
        lblDBUsername = new javax.swing.JLabel();
        txtDBUsername = new javax.swing.JTextField();
        chkDBPassword = new javax.swing.JCheckBox();
        txtDBPassword = new javax.swing.JPasswordField();
        lblDBPath = new javax.swing.JLabel();
        txtDBPath = new javax.swing.JTextField();
        cmdOkay = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();
        cmdBrowse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Select a Database");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        pnlContainer.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblDatabase.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDatabase.setText("Database");

        cboDatabase.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboDatabase.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "MySQL", "Oracle", "Sqlite" }));
        cboDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDatabaseActionPerformed(evt);
            }
        });

        lblDBUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDBUsername.setText("Username");

        txtDBUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDBUsername.setEnabled(false);

        chkDBPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkDBPassword.setText("Password");
        chkDBPassword.setEnabled(false);
        chkDBPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDBPasswordActionPerformed(evt);
            }
        });

        txtDBPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDBPassword.setEnabled(false);

        lblDBPath.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDBPath.setText("Path");

        txtDBPath.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDBPath.setEnabled(false);

        cmdOkay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdOkay.setText("Okay");
        cmdOkay.setEnabled(false);
        cmdOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOkayActionPerformed(evt);
            }
        });

        cmdClose.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdClose.setText("Close");
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        cmdBrowse.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdBrowse.setText("Browse");
        cmdBrowse.setEnabled(false);
        cmdBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlContainerLayout.createSequentialGroup()
                        .addComponent(lblDatabase)
                        .addGap(44, 44, 44)
                        .addComponent(cboDatabase, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlContainerLayout.createSequentialGroup()
                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDBUsername, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkDBPassword)
                            .addComponent(lblDBPath, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDBPath)
                            .addComponent(txtDBUsername)
                            .addComponent(txtDBPassword)))
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addComponent(cmdBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(cmdOkay, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDatabase)
                    .addComponent(cboDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDBUsername)
                    .addComponent(txtDBUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkDBPassword)
                    .addComponent(txtDBPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDBPath)
                    .addComponent(txtDBPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdClose)
                    .addComponent(cmdOkay)
                    .addComponent(cmdBrowse))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        dispose();
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void cboDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDatabaseActionPerformed
        String db = (String) cboDatabase.getSelectedItem();

        if ( db == "MySQL" || db == "Oracle" ) {
            txtDBUsername.setEnabled(true);
            txtDBPath.setEnabled(false);
            txtDBPath.setText("");
            chkDBPassword.setEnabled(true);
            cmdOkay.setEnabled(true);
            cmdBrowse.setEnabled(false);
        }
        else if ( db == "Sqlite" ) {
            txtDBPath.setEnabled(true);
            txtDBUsername.setEnabled(false);
            chkDBPassword.setEnabled(false);
            chkDBPassword.setSelected(false);
            txtDBPassword.setEnabled(false);
            txtDBPassword.setText("");
            cmdOkay.setEnabled(true);
            cmdBrowse.setEnabled(true);
        }
        else {
            txtDBUsername.setEnabled(false);
            txtDBPath.setEnabled(false);
            txtDBPath.setText("");
            cmdOkay.setEnabled(false);
            cmdBrowse.setEnabled(false);
            chkDBPassword.setEnabled(false);
            chkDBPassword.setSelected(false);
            txtDBPassword.setText("");
            txtDBPassword.setEnabled(false);
            
        }
    }//GEN-LAST:event_cboDatabaseActionPerformed

    private void chkDBPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDBPasswordActionPerformed
        if ( chkDBPassword.isSelected() ) {
            txtDBPassword.setEnabled(true);
        }
        else {
            txtDBPassword.setEnabled(false);
            txtDBPassword.setText("");
        }
    }//GEN-LAST:event_chkDBPasswordActionPerformed

    private void cmdBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBrowseActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter ff = new FileNameExtensionFilter("SQLite Database File (.sqlite, .sqlite3, .db)", "sqlite3", "sqlite", "db");
        fc.setFileFilter(ff);
        fc.showOpenDialog(null);
        File f = fc.getSelectedFile();
        String dbPath = f.getAbsolutePath();
        txtDBPath.setText(dbPath);
    }//GEN-LAST:event_cmdBrowseActionPerformed

    private void cmdOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOkayActionPerformed
        String database = (String) cboDatabase.getSelectedItem();
        String params[] = {"", ""};

        String dbUser = txtDBUsername.getText();
        String dbPass = txtDBPassword.getText();
        String dbPath = txtDBPath.getText();

        if ( database == "Sqlite" ) {
            params[0] = dbPath;
            
        }
        else {
            params[0] = dbUser;
            params[1] = ( dbPass.length() == 0 )  ? dbUser : dbPass;
        }

        c = dbConnector.connectTo(database, params);

        try {
            if( isConnectionSet() ) {
//                frmLogin.setConn(c);
                dispose();
            }
        }
        catch ( Exception e ) {
            System.err.println("Please try again");
        }
    }//GEN-LAST:event_cmdOkayActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        this.toFront();
    }//GEN-LAST:event_formWindowLostFocus

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDatabaseSelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDatabaseSelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDatabaseSelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDatabaseSelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDatabaseSelector().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboDatabase;
    private javax.swing.JCheckBox chkDBPassword;
    private javax.swing.JButton cmdBrowse;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdOkay;
    private javax.swing.JLabel lblDBPath;
    private javax.swing.JLabel lblDBUsername;
    private javax.swing.JLabel lblDatabase;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPasswordField txtDBPassword;
    private javax.swing.JTextField txtDBPath;
    private javax.swing.JTextField txtDBUsername;
    // End of variables declaration//GEN-END:variables
}