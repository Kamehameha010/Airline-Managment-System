/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cr.view.internal.rol;

/**
 *
 * @author joel010
 */
public class ShowRolView extends javax.swing.JInternalFrame {

    /**
     * Creates new form ShowRolView
     */
    public ShowRolView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPlanes = new javax.swing.JTable();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearch.setText("Search rol");
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 150, -1));

        jLabel1.setText("Rol");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        btnNew.setText("New Rol");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        getContentPane().add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        tbPlanes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbPlanes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 380, 160));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPlanes;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}