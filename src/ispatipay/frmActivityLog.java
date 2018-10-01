/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ispatipay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author deuterium2h
 */
public class frmActivityLog extends javax.swing.JFrame {

    /**
     * Creates new form frmActionLog
     */
    public frmActivityLog() {
        initComponents();
        conn = Database.getConnection();
    }

    private static frmActivityLog obj = null;

    public static frmActivityLog getObj(){
        if ( obj == null ) {
            obj = new frmActivityLog();
        }

        return obj;
    }

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    static final String table = "activity_log";

    private boolean allActivityFiltersSelected() {
        boolean log = chkLogActivity.isSelected();
        boolean add = chkAddActivity.isSelected();
        boolean upd = chkUpdateActivity.isSelected();
        boolean del = chkDeleteActivity.isSelected();
        boolean prt = chkPrintActivity.isSelected();

        return ( log && add && upd && del && prt );
    }

    private void selectAllFilters() {
        chkAllActivity.setEnabled(true);
        chkAllActivity.setSelected(true);
        chkLogActivity.setEnabled(false);
        chkAddActivity.setEnabled(false);
        chkUpdateActivity.setEnabled(false);
        chkDeleteActivity.setEnabled(false);
        chkPrintActivity.setEnabled(false);
        chkLogActivity.setSelected(true);
        chkAddActivity.setSelected(true);
        chkUpdateActivity.setSelected(true);
        chkDeleteActivity.setSelected(true);
        chkPrintActivity.setSelected(true);
    }

    private void resetFilters() {
        chkAllActivity.setSelected(false);
        chkLogActivity.setEnabled(true);
        chkAddActivity.setEnabled(true);
        chkUpdateActivity.setEnabled(true);
        chkDeleteActivity.setEnabled(true);
        chkPrintActivity.setEnabled(true);
        chkLogActivity.setSelected(false);
        chkAddActivity.setSelected(false);
        chkUpdateActivity.setSelected(false);
        chkDeleteActivity.setSelected(false);
        chkPrintActivity.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgPrintForm = new javax.swing.JDialog();
        pnlFiltersContainer = new javax.swing.JPanel();
        chkUsernameFilter = new javax.swing.JCheckBox();
        txtUsernameFilter = new javax.swing.JTextField();
        pnlFilterActivitiesContainer = new javax.swing.JPanel();
        chkAllActivity = new javax.swing.JCheckBox();
        chkLogActivity = new javax.swing.JCheckBox();
        chkAddActivity = new javax.swing.JCheckBox();
        chkUpdateActivity = new javax.swing.JCheckBox();
        chkDeleteActivity = new javax.swing.JCheckBox();
        chkPrintActivity = new javax.swing.JCheckBox();
        pnlPrintResultTableContainer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cmdPrint = new javax.swing.JButton();
        cmdCancel = new javax.swing.JButton();
        pnlSearchContainer = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        pnlTableContainer = new javax.swing.JPanel();
        scrTableScroll = new javax.swing.JScrollPane();
        tblActivityLog = new javax.swing.JTable();
        mnbActivityLog = new javax.swing.JMenuBar();
        mnuOptions = new javax.swing.JMenu();
        mniPrint = new javax.swing.JMenuItem();
        mniSepartaor1 = new javax.swing.JPopupMenu.Separator();
        mniClose = new javax.swing.JMenuItem();

        dlgPrintForm.setTitle("Print Chener");
        dlgPrintForm.setLocation(new java.awt.Point(0, 0));
        dlgPrintForm.setModal(true);
        dlgPrintForm.setResizable(false);

        pnlFiltersContainer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filters", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        chkUsernameFilter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkUsernameFilter.setText("Username");
        chkUsernameFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkUsernameFilterActionPerformed(evt);
            }
        });

        txtUsernameFilter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsernameFilter.setEnabled(false);

        pnlFilterActivitiesContainer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Activities", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        chkAllActivity.setSelected(true);
        chkAllActivity.setText("All");
        chkAllActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAllActivityActionPerformed(evt);
            }
        });

        chkLogActivity.setSelected(true);
        chkLogActivity.setText("Login/Logout");
        chkLogActivity.setEnabled(false);
        chkLogActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkLogActivityActionPerformed(evt);
            }
        });

        chkAddActivity.setSelected(true);
        chkAddActivity.setText("Add");
        chkAddActivity.setEnabled(false);
        chkAddActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAddActivityActionPerformed(evt);
            }
        });

        chkUpdateActivity.setSelected(true);
        chkUpdateActivity.setText("Update");
        chkUpdateActivity.setEnabled(false);
        chkUpdateActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkUpdateActivityActionPerformed(evt);
            }
        });

        chkDeleteActivity.setSelected(true);
        chkDeleteActivity.setText("Delete");
        chkDeleteActivity.setEnabled(false);
        chkDeleteActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDeleteActivityActionPerformed(evt);
            }
        });

        chkPrintActivity.setSelected(true);
        chkPrintActivity.setText("Print");
        chkPrintActivity.setEnabled(false);
        chkPrintActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPrintActivityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFilterActivitiesContainerLayout = new javax.swing.GroupLayout(pnlFilterActivitiesContainer);
        pnlFilterActivitiesContainer.setLayout(pnlFilterActivitiesContainerLayout);
        pnlFilterActivitiesContainerLayout.setHorizontalGroup(
            pnlFilterActivitiesContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterActivitiesContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkAllActivity)
                .addGap(27, 27, 27)
                .addComponent(chkLogActivity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(chkAddActivity)
                .addGap(18, 18, 18)
                .addComponent(chkUpdateActivity)
                .addGap(18, 18, 18)
                .addComponent(chkDeleteActivity)
                .addGap(18, 18, 18)
                .addComponent(chkPrintActivity)
                .addContainerGap())
        );
        pnlFilterActivitiesContainerLayout.setVerticalGroup(
            pnlFilterActivitiesContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterActivitiesContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFilterActivitiesContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkAllActivity)
                    .addComponent(chkLogActivity)
                    .addComponent(chkAddActivity)
                    .addComponent(chkUpdateActivity)
                    .addComponent(chkDeleteActivity)
                    .addComponent(chkPrintActivity))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlFiltersContainerLayout = new javax.swing.GroupLayout(pnlFiltersContainer);
        pnlFiltersContainer.setLayout(pnlFiltersContainerLayout);
        pnlFiltersContainerLayout.setHorizontalGroup(
            pnlFiltersContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltersContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFiltersContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFilterActivitiesContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFiltersContainerLayout.createSequentialGroup()
                        .addComponent(chkUsernameFilter)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsernameFilter)))
                .addContainerGap())
        );
        pnlFiltersContainerLayout.setVerticalGroup(
            pnlFiltersContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltersContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFiltersContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkUsernameFilter)
                    .addComponent(txtUsernameFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlFilterActivitiesContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPrintResultTableContainer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Print Result Table", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout pnlPrintResultTableContainerLayout = new javax.swing.GroupLayout(pnlPrintResultTableContainer);
        pnlPrintResultTableContainer.setLayout(pnlPrintResultTableContainerLayout);
        pnlPrintResultTableContainerLayout.setHorizontalGroup(
            pnlPrintResultTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrintResultTableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlPrintResultTableContainerLayout.setVerticalGroup(
            pnlPrintResultTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrintResultTableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cmdPrint.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdPrint.setText("Print");

        cmdCancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdCancel.setText("Cancel");
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgPrintFormLayout = new javax.swing.GroupLayout(dlgPrintForm.getContentPane());
        dlgPrintForm.getContentPane().setLayout(dlgPrintFormLayout);
        dlgPrintFormLayout.setHorizontalGroup(
            dlgPrintFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgPrintFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgPrintFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFiltersContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPrintResultTableContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgPrintFormLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmdPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        dlgPrintFormLayout.setVerticalGroup(
            dlgPrintFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgPrintFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFiltersContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPrintResultTableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dlgPrintFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdCancel)
                    .addComponent(cmdPrint))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlSearchContainer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchContainerLayout = new javax.swing.GroupLayout(pnlSearchContainer);
        pnlSearchContainer.setLayout(pnlSearchContainerLayout);
        pnlSearchContainerLayout.setHorizontalGroup(
            pnlSearchContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSearchContainerLayout.setVerticalGroup(
            pnlSearchContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblActivityLog.setAutoCreateRowSorter(true);
        tblActivityLog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrTableScroll.setViewportView(tblActivityLog);

        javax.swing.GroupLayout pnlTableContainerLayout = new javax.swing.GroupLayout(pnlTableContainer);
        pnlTableContainer.setLayout(pnlTableContainerLayout);
        pnlTableContainerLayout.setHorizontalGroup(
            pnlTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrTableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTableContainerLayout.setVerticalGroup(
            pnlTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrTableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mnuOptions.setText("File");

        mniPrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mniPrint.setText("Print");
        mniPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPrintActionPerformed(evt);
            }
        });
        mnuOptions.add(mniPrint);
        mnuOptions.add(mniSepartaor1);

        mniClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        mniClose.setText("Close");
        mniClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCloseActionPerformed(evt);
            }
        });
        mnuOptions.add(mniClose);

        mnbActivityLog.add(mnuOptions);

        setJMenuBar(mnbActivityLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTableContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSearchContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSearchContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlTableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mniCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_mniCloseActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

        String sql = "SELECT * FROM activity_log WHERE username LIKE ? "
                + "OR action LIKE ? OR action_time LIKE ? OR action_date LIKE ?";

        if ( Helper.isTextFieldBlank(txtSearch) ) {
            Helper.loadTable(tblActivityLog, conn, table);
        }
        else {

            String item = txtSearch.getText() + "%";

            try {
                pst = conn.prepareStatement(sql);
                for ( int i = 1; i <= 4; i++ ) {
                    pst.setString(i, item);
                }
                rs = pst.executeQuery();
                tblActivityLog.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch ( SQLException e ) {
                System.err.println(e);
            }
            finally {
                Helper.closeIfSqlite(pst, rs);
            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void mniPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPrintActionPerformed
        dlgPrintForm.setSize(dlgPrintForm.getPreferredSize());
        dlgPrintForm.setLocationRelativeTo(null);
        dlgPrintForm.setVisible(true);
    }//GEN-LAST:event_mniPrintActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        dlgPrintForm.hide();
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void chkAllActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAllActivityActionPerformed
        if ( chkAllActivity.isSelected() ) {
            selectAllFilters();
        }
        else {
            resetFilters();
        }
    }//GEN-LAST:event_chkAllActivityActionPerformed

    private void chkLogActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkLogActivityActionPerformed
        if ( allActivityFiltersSelected() ) {
            selectAllFilters();
        }
    }//GEN-LAST:event_chkLogActivityActionPerformed

    private void chkAddActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAddActivityActionPerformed
        if ( allActivityFiltersSelected() ) {
            selectAllFilters();
        }
    }//GEN-LAST:event_chkAddActivityActionPerformed

    private void chkUpdateActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkUpdateActivityActionPerformed
        if ( allActivityFiltersSelected() ) selectAllFilters();
    }//GEN-LAST:event_chkUpdateActivityActionPerformed

    private void chkDeleteActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDeleteActivityActionPerformed
        if ( allActivityFiltersSelected() ) selectAllFilters();
    }//GEN-LAST:event_chkDeleteActivityActionPerformed

    private void chkPrintActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPrintActivityActionPerformed
        if ( allActivityFiltersSelected() ) selectAllFilters();
    }//GEN-LAST:event_chkPrintActivityActionPerformed

    private void chkUsernameFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkUsernameFilterActionPerformed
        if ( chkUsernameFilter.isSelected() ) {
            txtUsernameFilter.setEnabled(true);
        }
        else {
            txtUsernameFilter.setEnabled(false);
            txtUsernameFilter.setText("");
        }
    }//GEN-LAST:event_chkUsernameFilterActionPerformed

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
            java.util.logging.Logger.getLogger(frmActivityLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmActivityLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmActivityLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmActivityLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmActivityLog().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkAddActivity;
    private javax.swing.JCheckBox chkAllActivity;
    private javax.swing.JCheckBox chkDeleteActivity;
    private javax.swing.JCheckBox chkLogActivity;
    private javax.swing.JCheckBox chkPrintActivity;
    private javax.swing.JCheckBox chkUpdateActivity;
    private javax.swing.JCheckBox chkUsernameFilter;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdPrint;
    private javax.swing.JDialog dlgPrintForm;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuBar mnbActivityLog;
    private javax.swing.JMenuItem mniClose;
    private javax.swing.JMenuItem mniPrint;
    private javax.swing.JPopupMenu.Separator mniSepartaor1;
    private javax.swing.JMenu mnuOptions;
    private javax.swing.JPanel pnlFilterActivitiesContainer;
    private javax.swing.JPanel pnlFiltersContainer;
    private javax.swing.JPanel pnlPrintResultTableContainer;
    private javax.swing.JPanel pnlSearchContainer;
    private javax.swing.JPanel pnlTableContainer;
    private javax.swing.JScrollPane scrTableScroll;
    private javax.swing.JTable tblActivityLog;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtUsernameFilter;
    // End of variables declaration//GEN-END:variables
}
