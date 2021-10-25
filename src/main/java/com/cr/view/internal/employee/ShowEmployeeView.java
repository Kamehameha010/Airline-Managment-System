/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cr.view.internal.employee;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.cr.controller.EmployeeController;
import com.cr.model.Employee;
import com.cr.model.Flight;
import com.cr.tools.component.table.CustomCellRender;
import com.cr.tools.component.table.CustomTableModel;

/**
 *
 * @author joel010
 */
public class ShowEmployeeView extends javax.swing.JInternalFrame {

    /**
     * Creates new form ShowEmployeeView
     */
    private EmployeeController _controller;
    private CustomTableModel<Employee> model;
    private CustomCellRender tableRender;
    private Employee employee;

    public ShowEmployeeView() throws IOException {
        _controller = new EmployeeController();
        initComponents();
        setTableModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmployee = new javax.swing.JTable();

        txtSearch.setText("Search Employee");

        jLabel1.setText("Employee");

        btnNew.setText("New Employee");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        tbEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEmployee);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap(49, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup().addComponent(btnNew)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addGap(156, 214, Short.MAX_VALUE).addComponent(jLabel1)
                                .addGap(0, 236, Short.MAX_VALUE))));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnNew))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addGap(0, 6, Short.MAX_VALUE).addComponent(jLabel1)
                                .addGap(0, 262, Short.MAX_VALUE))));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbEmployeeMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbEmployeeMouseClicked
        // TODO add your handling code here:
        int pos = tbEmployee.getSelectedRow();
        employee = (Employee) model.getSelectedRow(pos);
    }
    // GEN-LAST:event_tbEmployeeMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            var view = new EmployeeView();
            view.setVisible(true);
            view.show();
        } catch (IOException ex) {
            Logger.getLogger(ShowEmployeeView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_btnNewActionPerformed

    private void setTableModel() {
        model = new CustomTableModel<Employee>(_controller.getAll(),
                new String[] { "ID", "Name", "Lastname", "Username", "Password", "Rol" });
        tbEmployee.setModel(model);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbEmployee;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
