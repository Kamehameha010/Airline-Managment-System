/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cr.view.internal.flight;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.cr.controller.FlightController;
import com.cr.controller.PlaneController;
import com.cr.model.Flight;
import com.cr.model.Plane;
import com.cr.tools.SwingUtility;
import com.cr.tools.component.combobox.CustomComboBoxModel;
import com.cr.tools.component.combobox.PlaneListCellRender;

/**
 *
 * @author joel010
 */
public class FlightView extends javax.swing.JInternalFrame {

    /**
     * Creates new form FlieghtView
     */
    private SwingUtility _utility;
    private FlightController _flightController;
    private PlaneController _planeController;
    private CustomComboBoxModel<Plane> _cbModel;

    public FlightView() throws IOException {
        _utility = new SwingUtility();
        _flightController = new FlightController();
        _planeController = new PlaneController();
        _cbModel = new CustomComboBoxModel<>(_planeController.getAll());
        initComponents();
        cbPlane.setRenderer(new PlaneListCellRender());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        txtCode = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        dcDate = new com.toedter.calendar.JDateChooser();
        cbSource = new javax.swing.JComboBox<>();
        cbDestination = new javax.swing.JComboBox<>();
        cbPlane = new javax.swing.JComboBox<>(_cbModel);
        jLabel7 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel2.setText("Code:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel3.setText("Date:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel4.setText("Source:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel5.setText("Plane:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel6.setText("Destination:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 70, -1));

        txtCode.setName("code"); // NOI18N
        getContentPane().add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 240, -1));

        txtName.setName("name"); // NOI18N
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 240, -1));

        dcDate.setName("date"); // NOI18N
        getContentPane().add(dcDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 240, -1));

        cbSource.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbSource.setName("source"); // NOI18N
        getContentPane().add(cbSource, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 240, -1));

        cbDestination.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDestination.setName("destination"); // NOI18N
        getContentPane().add(cbDestination, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 240, -1));

        cbPlane.setName("idPlane"); // NOI18N
        getContentPane().add(cbPlane, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 240, -1));

        jLabel7.setText("Flight");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSaveActionPerformed
        

        var map = _utility.getDataComponents(getContentPane());
        map.put("idPlane", Plane.class.cast(map.get("idPlane")).getIdPlane());
        System.out.println(map);

        try {
            var flight = (Flight) _utility.intanceObject(Flight.class, map);     
            _flightController.create(flight);
            JOptionPane.showMessageDialog(null, "Succesful");

        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException
                | IllegalArgumentException | IntrospectionException ex) {
            Logger.getLogger(FlightView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "internal error, try again");
        }

    }// GEN-LAST:event_btnSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbDestination;
    private javax.swing.JComboBox<Plane> cbPlane;
    private javax.swing.JComboBox<String> cbSource;
    private com.toedter.calendar.JDateChooser dcDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
