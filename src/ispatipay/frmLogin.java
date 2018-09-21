/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ispatipay;

import java.io.File;
import java.sql.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author DANEM682
 */
public class frmLogin extends javax.swing.JFrame {

    /**
     * Creates new form frmLogin
     */
    public frmLogin() {
        initComponents();
    }

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
/**
    static String database;
    static String[] params;

    public String getDatabase() {
        return database;
    }

    public String[] getParams() {
        return params;
    }
    
    public void setDatabase(String db) {
        this.database = db;
    }

    public void setParams(String[] opt) {
        this.params = opt;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection c) {
        this.conn = c;
    }
*/
    private boolean isItemsSet() {
        return ( txtUsername.getText().length() > 0 && txtPassword.getText().length() > 0 );
    }

    private boolean isConnectionSet() throws SQLException {
        return ( !conn.isClosed() );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgDBSelector = new javax.swing.JDialog();
        pnlDBContainer = new javax.swing.JPanel();
        lblDBName = new javax.swing.JLabel();
        cboDBName = new javax.swing.JComboBox();
        lblDBUser = new javax.swing.JLabel();
        txtDBUser = new javax.swing.JTextField();
        chkDBPass = new javax.swing.JCheckBox();
        txtDBPass = new javax.swing.JPasswordField();
        lblDBLocation = new javax.swing.JLabel();
        txtDBLocation = new javax.swing.JTextField();
        cmdDBOkay = new javax.swing.JButton();
        cmdDBClose = new javax.swing.JButton();
        cmdDBBrowse = new javax.swing.JButton();
        pnlContainer = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        cmdLogin = new javax.swing.JButton();
        cmdCancel = new javax.swing.JButton();
        cmdSetDB = new javax.swing.JButton();

        dlgDBSelector.setTitle("Select a database");
        dlgDBSelector.setModal(true);
        dlgDBSelector.setResizable(false);

        pnlDBContainer.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblDBName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDBName.setText("Database");

        cboDBName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboDBName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "MySQL", "Oracle", "Sqlite" }));
        cboDBName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDBNameActionPerformed(evt);
            }
        });

        lblDBUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDBUser.setText("Username");

        txtDBUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDBUser.setEnabled(false);

        chkDBPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkDBPass.setText("Password");
        chkDBPass.setEnabled(false);
        chkDBPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDBPassActionPerformed(evt);
            }
        });

        txtDBPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDBPass.setEnabled(false);

        lblDBLocation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDBLocation.setText("Path");

        txtDBLocation.setEditable(false);
        txtDBLocation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDBLocation.setEnabled(false);

        cmdDBOkay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdDBOkay.setText("Okay");
        cmdDBOkay.setEnabled(false);
        cmdDBOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDBOkayActionPerformed(evt);
            }
        });

        cmdDBClose.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdDBClose.setText("Close");
        cmdDBClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDBCloseActionPerformed(evt);
            }
        });

        cmdDBBrowse.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdDBBrowse.setText("Browse");
        cmdDBBrowse.setEnabled(false);
        cmdDBBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDBBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDBContainerLayout = new javax.swing.GroupLayout(pnlDBContainer);
        pnlDBContainer.setLayout(pnlDBContainerLayout);
        pnlDBContainerLayout.setHorizontalGroup(
            pnlDBContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDBContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDBContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDBContainerLayout.createSequentialGroup()
                        .addComponent(lblDBName)
                        .addGap(44, 44, 44)
                        .addComponent(cboDBName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDBContainerLayout.createSequentialGroup()
                        .addGroup(pnlDBContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDBUser, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkDBPass)
                            .addComponent(lblDBLocation, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDBContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDBLocation)
                            .addComponent(txtDBUser)
                            .addComponent(txtDBPass)))
                    .addGroup(pnlDBContainerLayout.createSequentialGroup()
                        .addComponent(cmdDBBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(cmdDBOkay, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmdDBClose, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlDBContainerLayout.setVerticalGroup(
            pnlDBContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDBContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDBContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDBName)
                    .addComponent(cboDBName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDBContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDBUser)
                    .addComponent(txtDBUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDBContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkDBPass)
                    .addComponent(txtDBPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDBContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDBLocation)
                    .addComponent(txtDBLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(pnlDBContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdDBClose)
                    .addComponent(cmdDBOkay)
                    .addComponent(cmdDBBrowse))
                .addContainerGap())
        );

        javax.swing.GroupLayout dlgDBSelectorLayout = new javax.swing.GroupLayout(dlgDBSelector.getContentPane());
        dlgDBSelector.getContentPane().setLayout(dlgDBSelectorLayout);
        dlgDBSelectorLayout.setHorizontalGroup(
            dlgDBSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgDBSelectorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDBContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        dlgDBSelectorLayout.setVerticalGroup(
            dlgDBSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgDBSelectorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDBContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        dlgDBSelector.getAccessibleContext().setAccessibleParent(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login to Ispatipay");
        setResizable(false);

        pnlContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsername.setText("Username");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsernameKeyReleased(evt);
            }
        });

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPassword.setText("Password");

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });

        cmdLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdLogin.setText("Login");
        cmdLogin.setEnabled(false);
        cmdLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoginActionPerformed(evt);
            }
        });

        cmdCancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdCancel.setText("Cancel");
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        cmdSetDB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdSetDB.setText("Set Database");
        cmdSetDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSetDBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainerLayout.createSequentialGroup()
                        .addComponent(cmdSetDB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(cmdLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername)
                            .addComponent(lblPassword))
                        .addGap(18, 18, 18)
                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername)
                            .addComponent(txtPassword))))
                .addContainerGap())
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainerLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdLogin)
                    .addComponent(cmdCancel)
                    .addComponent(cmdSetDB))
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

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void cmdSetDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSetDBActionPerformed
//        frmDatabaseSelector dbSelect = frmDatabaseSelector.getObj();
//        dbSelect.setVisible(true);
        dlgDBSelector.setResizable(false);
        dlgDBSelector.setSize(402, 244);
        dlgDBSelector.setLocationRelativeTo(null);
        dlgDBSelector.setVisible(true);
    }//GEN-LAST:event_cmdSetDBActionPerformed

    private void txtUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyReleased
        try {
            if ( isItemsSet() && isConnectionSet() ) {
                cmdLogin.setEnabled(true);
            }
            else {
                cmdLogin.setEnabled(false);
            }
        }
        catch ( Exception e ) {
        
        }
    }//GEN-LAST:event_txtUsernameKeyReleased

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        try {
            if ( isItemsSet() && isConnectionSet() ) {
                cmdLogin.setEnabled(true);
            }
            else {
                cmdLogin.setEnabled(false);
            }
        }
        catch ( Exception e ) {
        
        }
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void cmdLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoginActionPerformed
        String user = txtUsername.getText();
        String pass = Hash.generateHash(txtPassword.getText(), ""); ;

        try {
            if ( true ) {
                frmMain mf = new frmMain();
                mf.setVisible(true);
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Incorrect login credentials, please try again", "Incorrect Credentials", JOptionPane.WARNING_MESSAGE);
            }
        }
        catch ( Exception e ) {
            
        }
    }//GEN-LAST:event_cmdLoginActionPerformed

    private void cboDBNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDBNameActionPerformed
        String db = (String) cboDBName.getSelectedItem();

        if ( db == "MySQL" || db == "Oracle" ) {
            txtDBUser.setEnabled(true);
            txtDBLocation.setEnabled(false);
            txtDBLocation.setText("");
            chkDBPass.setEnabled(true);
            cmdDBOkay.setEnabled(true);
            cmdDBBrowse.setEnabled(false);
        }
        else if ( db == "Sqlite" ) {
            txtDBLocation.setEnabled(true);
            txtDBUser.setEnabled(false);
            chkDBPass.setEnabled(false);
            chkDBPass.setSelected(false);
            txtDBPass.setEnabled(false);
            txtDBPass.setText("");
            cmdDBOkay.setEnabled(true);
            cmdDBBrowse.setEnabled(true);
        }
        else {
            txtDBUser.setEnabled(false);
            txtDBLocation.setEnabled(false);
            txtDBLocation.setText("");
            cmdDBOkay.setEnabled(false);
            cmdDBBrowse.setEnabled(false);
            chkDBPass.setEnabled(false);
            chkDBPass.setSelected(false);
            txtDBPass.setText("");
            txtDBPass.setEnabled(false);
        }
    }//GEN-LAST:event_cboDBNameActionPerformed

    private void chkDBPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDBPassActionPerformed
        if ( chkDBPass.isSelected() ) {
            txtDBPass.setEnabled(true);
        }
        else {
            txtDBPass.setEnabled(false);
            txtDBPass.setText("");
        }
    }//GEN-LAST:event_chkDBPassActionPerformed

    private void cmdDBOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDBOkayActionPerformed
        String database = (String) cboDBName.getSelectedItem();
        String params[] = {"", ""};

        String dbUser = txtDBUser.getText();
        String dbPass = txtDBPass.getText();
        String dbPath = txtDBLocation.getText();

        if ( database == "Sqlite" ) {
            params[0] = dbPath;

        }
        else {
            params[0] = dbUser;
            params[1] = ( dbPass.length() == 0 )  ? dbUser : dbPass;
        }

        conn = dbConnector.connectTo(database, params);

        try {
            if ( isConnectionSet() ) {
                JOptionPane.showMessageDialog(null, "Successfully connected to Database", 
                    "Connection Success!", JOptionPane.INFORMATION_MESSAGE);
                dlgDBSelector.hide();
            }
        }
        catch ( Exception e ) {
            JOptionPane.showMessageDialog(null, "Cannot connect to Database!\nPlease try again.", 
                "Connection Failed!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmdDBOkayActionPerformed

    private void cmdDBCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDBCloseActionPerformed
        dlgDBSelector.hide();
    }//GEN-LAST:event_cmdDBCloseActionPerformed

    private void cmdDBBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDBBrowseActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter ff = new FileNameExtensionFilter("SQLite Database File (.sqlite, .sqlite3, .db)", "sqlite3", "sqlite", "db");
        fc.setFileFilter(ff);
        fc.showOpenDialog(null);
        File f = fc.getSelectedFile();
        String dbPath = f.getAbsolutePath();
        txtDBLocation.setText(dbPath);
    }//GEN-LAST:event_cmdDBBrowseActionPerformed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboDBName;
    private javax.swing.JComboBox cboDatabase;
    private javax.swing.JCheckBox chkDBPass;
    private javax.swing.JCheckBox chkDBPassword;
    private javax.swing.JButton cmdBrowse;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdDBBrowse;
    private javax.swing.JButton cmdDBClose;
    private javax.swing.JButton cmdDBOkay;
    private javax.swing.JButton cmdLogin;
    private javax.swing.JButton cmdOkay;
    private javax.swing.JButton cmdSetDB;
    private javax.swing.JDialog dlgDBSelector;
    private javax.swing.JLabel lblDBLocation;
    private javax.swing.JLabel lblDBName;
    private javax.swing.JLabel lblDBPath;
    private javax.swing.JLabel lblDBUser;
    private javax.swing.JLabel lblDBUsername;
    private javax.swing.JLabel lblDatabase;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlContainer1;
    private javax.swing.JPanel pnlDBContainer;
    private javax.swing.JTextField txtDBLocation;
    private javax.swing.JPasswordField txtDBPass;
    private javax.swing.JPasswordField txtDBPassword;
    private javax.swing.JTextField txtDBPath;
    private javax.swing.JTextField txtDBUser;
    private javax.swing.JTextField txtDBUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}