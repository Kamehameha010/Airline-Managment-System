/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cr.view.internal.plane;

import java.io.IOException;

import com.cr.controller.PlaneController;
import com.cr.model.Plane;
import com.cr.tools.component.table.CustomTableModel;

/**
 *
 * @author joel010
 */
public class ShowPlaneView extends javax.swing.JInternalFrame {
    private PlaneController _controller;
    private CustomTableModel dataModel;
    private Plane plane;
    /**
     * Creates new form ShowPlane
     * @throws IOException
     */
    public ShowPlaneView() throws IOException {
        _controller = new PlaneController();
        initComponents();
        setTableModel();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPlanes = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNew.setText("New Plain");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        getContentPane().add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

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
        tbPlanes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPlanesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPlanes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 380, 160));

        txtSearch.setText("Search plane");
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 150, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        
    }//GEN-LAST:event_btnNewActionPerformed

    private void tbPlanesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPlanesMouseClicked
        int pos = tbPlanes.getSelectedRow();
        plane = (Plane) dataModel.getSelectedRow(pos);
        System.out.println(plane);
    }//GEN-LAST:event_tbPlanesMouseClicked

    private void setTableModel() {
        dataModel = new CustomTableModel(_controller.getAll(),
                new String[] { "ID", "NAME", "CODE", "CAPACITY"});
        tbPlanes.setModel(dataModel);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNew;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPlanes;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
