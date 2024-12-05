package com.mycompany.practica;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UsuariosPanel extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;

    public UsuariosPanel() {
        setLayout(new BorderLayout());

        // Crear y configurar el modelo de la tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Cédula");
        tableModel.addColumn("Teléfono");
        tableModel.addColumn("Dirección");
        tableModel.addColumn("Rol");
        tableModel.addColumn("Estado");  // Columna para Estado (boolean)

        // Inicializar la tabla con el modelo
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Panel superior con campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));  // Cambiado de 5 a 6 filas
        txtNombre = new JTextField();
        txtCedula = new JTextField();
        txtTelefono = new JTextField();
        txtDireccion = new JTextField();
        txtRol = new JTextField();
        chkEstado = new JCheckBox("Activo");  // Checkbox para el estado

        inputPanel.add(new JLabel("Nombre:"));
        inputPanel.add(txtNombre);
        inputPanel.add(new JLabel("Cédula:"));
        inputPanel.add(txtCedula);
        inputPanel.add(new JLabel("Teléfono:"));
        inputPanel.add(txtTelefono);
        inputPanel.add(new JLabel("Dirección:"));
        inputPanel.add(txtDireccion);
        inputPanel.add(new JLabel("Rol:"));
        inputPanel.add(txtRol);
        inputPanel.add(new JLabel("Estado:"));
        inputPanel.add(chkEstado);  // Agregar checkbox para el estado

        // Botón para agregar datos
        btnAgregar = new JButton("Agregar Usuario");
        btnAgregar.addActionListener(this::agregarUsuario);

        // Botón para eliminar todas las filas de la tabla
        btnListar = new JButton("Eliminar todo");
        btnListar.addActionListener(this::eliminarTodo);

        // Panel inferior para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAgregar);
        buttonPanel.add(btnListar);

        // Crear panel principal y agregar componentes
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
    }

    /**
     * Método para agregar un usuario a la tabla
     */
    private void agregarUsuario(ActionEvent e) {
        // Obtener datos de los campos
        String nombre = txtNombre.getText();
        String cedulaStr = txtCedula.getText();
        String telefonoStr = txtTelefono.getText();
        String direccion = txtDireccion.getText();
        String rol = txtRol.getText();
        boolean estado = chkEstado.isSelected();  // Obtener el estado (boolean) del JCheckBox

        // Validar que los campos no estén vacíos
        if (nombre.isEmpty() || cedulaStr.isEmpty() || telefonoStr.isEmpty() || direccion.isEmpty() || rol.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que la cédula y el teléfono sean números enteros
        int cedula = 0;
        int telefono = 0;
        try {
            cedula = Integer.parseInt(cedulaStr);  // Convertir la cédula a int
            telefono = Integer.parseInt(telefonoStr);  // Convertir el teléfono a int
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La cédula y el teléfono deben ser números enteros.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Comprobar si la cédula ya está en la tabla
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 1).equals(cedula)) {  // La cédula está en la segunda columna
                JOptionPane.showMessageDialog(this, "Ya existe un usuario con esta cédula.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Agregar los datos al modelo de la tabla
        tableModel.addRow(new Object[]{nombre, cedula, telefono, direccion, rol, estado});

        // Limpiar los campos
        txtNombre.setText("");
        txtCedula.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtRol.setText("");
        chkEstado.setSelected(false);  // Restablecer el estado a "no activo"
    }

    /**
     * Método para eliminar todas las filas de la tabla
     */
    private void eliminarTodo(ActionEvent e) {
        // Confirmar la eliminación
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar todos los usuarios?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            tableModel.setRowCount(0); // Eliminar todas las filas
        }
    }


/**
 * This method is called from within the constructor to initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is always
 * regenerated by the Form Editor.
 */
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnListar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        txtDireccion = new javax.swing.JTextField();
        txtRol = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        tabla = new javax.swing.JScrollPane();
        chkEstado = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));

        btnListar.setText("Eliminar");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtDireccion.setText("Direccion");
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        txtRol.setText("Rol");
        txtRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRolActionPerformed(evt);
            }
        });

        txtTelefono.setText("Telefono");
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        txtCedula.setText("Cedula");
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        txtNombre.setText("Nombre");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        chkEstado.setText("Estado");
        chkEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(32, 32, 32)
                        .addComponent(btnListar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtRol, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkEstado))
                        .addGap(18, 18, 18)
                        .addComponent(tabla, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkEstado)
                        .addGap(14, 14, 14)
                        .addComponent(txtRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tabla, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnListar))
                .addContainerGap(121, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRolActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void chkEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnListar;
    private javax.swing.JCheckBox chkEstado;
    private javax.swing.JScrollPane tabla;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRol;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}